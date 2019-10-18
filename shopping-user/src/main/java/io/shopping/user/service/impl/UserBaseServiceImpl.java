package io.shopping.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.shopping.common.constant.GlobalConstant;
import io.shopping.common.response.ServerResponse;
import io.shopping.common.response.DefaultServerResponse;
import io.shopping.common.util.DigestUtils;
import io.shopping.common.util.UUIDUtils;
import io.shopping.user.cache.UserKeyCache;
import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.mapper.UserBaseMapper;
import io.shopping.user.service.UserBaseService;
import io.shopping.user.vo.UserLoginVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * <p>
 * UserBase-业务接口
 * </p>
 *
 * @author
 * @since 2019-09-24
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {
    @Resource
    private UserBaseMapper userBaseMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Integer insert(UserBase userBase) {
        return userBaseMapper.insert(userBase);
    }

    @Override
    public ServerResponse login(UserLoginVO vo, HttpServletResponse response) {
        UserBase userBase = userBaseMapper.selectOne(new LambdaQueryWrapper<UserBase>().eq(UserBase::getMobile, vo.getMobile()));
        if (null == userBase) {
            return DefaultServerResponse.USER_NOT_EXIST;
        }
        if (DigestUtils.isDbDigestEqual(vo.getPassword(), userBase.getSalt(), userBase.getPassword())) {
            return DefaultServerResponse.PASSWORD_ERROR;
        }
        userBase.setLastLoginTime(LocalDateTime.now());
        userBaseMapper.updateById(userBase);
        refreshToken(response, UserKeyCache.TOKEN.key(UUIDUtils.uuid()), userBase);
        return ServerResponse.success();
    }

    @Override
    public UserBase getByToken(String token, HttpServletResponse response) {
        if (token == null) {
            return null;
        }
        Object userBase = redisTemplate.opsForValue().get(token);
        if (userBase == null) {
            return null;
        }
        // 延长有效期
        refreshToken(response, token, userBase);
        return (UserBase) userBase;
    }

    private void refreshToken(HttpServletResponse response, String token, Object userBase) {
        redisTemplate.opsForValue().set(token, userBase, Duration.ofSeconds(UserKeyCache.TOKEN.expireSeconds()));
        Cookie cookie = new Cookie(GlobalConstant.TOKEN, token);
        cookie.setMaxAge(UserKeyCache.TOKEN.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}

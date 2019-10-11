package io.shopping.user.service.impl;

import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.mapper.UserBaseMapper;
import io.shopping.user.service.UserBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public Integer insert(UserBase userBase) {
        return userBaseMapper.insert(userBase);
    }
}

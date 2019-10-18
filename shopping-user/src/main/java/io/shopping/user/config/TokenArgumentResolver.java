package io.shopping.user.config;

import io.shopping.common.constant.GlobalConstant;
import io.shopping.common.util.UUIDUtils;
import io.shopping.user.cache.UserKeyCache;
import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.service.UserBaseService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.stream.Stream;

/**
 * @author Wilson
 * @date 2019/10/15
 **/
@Component
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {
    @Resource
    private UserBaseService userBaseService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return UserBase.class == parameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String token = Stream.of(request.getCookies())
                .filter(cookie -> GlobalConstant.TOKEN.equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
        if (token == null) {
            return null;
        }
        System.out.println(userBaseService.getByToken(token, response));
        return userBaseService.getByToken(token, response);
    }


}

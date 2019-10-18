package io.shopping.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wilson
 * @date 2019/10/15
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private TokenArgumentResolver tokenArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(tokenArgumentResolver);
    }
}

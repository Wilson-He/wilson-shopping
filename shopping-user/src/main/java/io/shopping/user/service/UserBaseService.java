package io.shopping.user.service;

import io.shopping.common.response.ServerResponse;
import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.vo.UserLoginVO;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * UserBase-业务接口
 * </p>
 *
 * @author
 * @since 2019-09-24
 */
public interface UserBaseService {

    Integer insert(UserBase userBase);

    ServerResponse login(UserLoginVO vo, HttpServletResponse response);

    UserBase getByToken(String token, HttpServletResponse response);
}

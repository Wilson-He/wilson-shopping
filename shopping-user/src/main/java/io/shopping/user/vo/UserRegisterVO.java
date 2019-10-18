package io.shopping.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static io.shopping.user.constant.UserConstant.MOBILE_PATTERN;

/**
 * 注册信息
 *
 * @author Wilson
 * @date 2019/10/14
 **/
@Data
public class UserRegisterVO {
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = MOBILE_PATTERN)
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;
}

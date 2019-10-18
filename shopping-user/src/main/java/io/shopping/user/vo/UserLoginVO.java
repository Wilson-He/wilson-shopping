package io.shopping.user.vo;

import io.shopping.user.domain.entity.UserBase;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static io.shopping.user.constant.UserConstant.MOBILE_PATTERN;

/**
 * @author Wilson
 * @date 2019/10/14
 **/
@Data
public class UserLoginVO {
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = MOBILE_PATTERN)
    private String mobile;
    @NotBlank(message = "密码不能为空")
    @Length(min = 8)
    private String password;

    public UserBase toUserBase(){
        return new UserBase()
                .setMobile(mobile)
                .setPassword(password)
                .setSalt(RandomStringUtils.random(5));
    }
}

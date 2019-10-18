package io.shopping.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBase implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    /**
     * MD5(MD5(明文+salt)+salt)
     */
    private String password;

    private String salt;

    private Integer avatar;

    /**
     * 手机号码
     */
    private String mobile;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

}

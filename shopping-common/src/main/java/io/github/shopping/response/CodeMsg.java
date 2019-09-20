package io.github.shopping.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Wilson
 * @date 2019/9/20
 **/
@Getter
@ToString
public class CodeMsg {
    private Integer code;
    private String msg;


    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

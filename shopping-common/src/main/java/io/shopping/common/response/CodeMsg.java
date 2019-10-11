package io.shopping.common.response;

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

    public static CodeMsg ERROR = new CodeMsg(500,"服务器内部错误");


    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

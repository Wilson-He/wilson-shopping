package io.github.shopping.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Wilson
 * @date 2019/9/20
 **/
@Getter
@ToString
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static<T>  ResponseResult<T> success(T data){
        return new ResponseResult<T>(data);
    }

    public static<T>  ResponseResult<T> error(CodeMsg codeMsg){
        return new ResponseResult<T>(codeMsg);
    }

    private ResponseResult(T data){
        this.code = 200;
        this.data = data;
        this.msg = "success";
    }
    private ResponseResult(CodeMsg codeMsg){
        if(null == codeMsg){
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
}

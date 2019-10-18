package io.shopping.common.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Wilson
 * @date 2019/9/20
 **/
@Getter
@ToString
public class ServerResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public static ServerResponse success() {
        return DefaultServerResponse.SUCCESS;
    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(data);
    }

    public static <T> ServerResponse<T> error(Integer code, String msg) {
        return new ServerResponse<>(code, msg);
    }

    private ServerResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ServerResponse(T data) {
        this.code = 200;
        this.data = data;
        this.msg = "success";
    }
}

package io.shopping.user.exception;

import io.shopping.common.response.ServerResponse;
import lombok.Getter;

/**
 * @author Wilson
 * @date 2019/10/14
 **/
@Getter
public class GlobalException extends RuntimeException {
    private final ServerResponse response;

    public GlobalException(ServerResponse response) {
        this.response = response;
    }
}

package io.shopping.user.exception;

import io.shopping.common.response.ServerResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Wilson
 * @date 2019/10/14
 **/
@Configuration
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse globalExceptionHandler(GlobalException exception) {
        return exception.getResponse();
      }
}

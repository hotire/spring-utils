package com.github.hotire.spring.utils.exception;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@NoArgsConstructor
public class BaseException extends RuntimeException {

    public BaseException(final String message) {
        super(message);
    }
}

package com.github.hotire.spring.utils.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot found entity")
@RequiredArgsConstructor
public class NotFoundEntityException extends BaseException {
    private final Long id;

    public NotFoundEntityException(final Long id, final String message) {
        super(message);
        this.id = id;
    }

    public static NotFoundEntityException of(final Long id) {
        return new NotFoundEntityException(id);
    }

    public static NotFoundEntityException of(final Long id, final String message) {
        return new NotFoundEntityException(id, message);
    }
}

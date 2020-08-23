package com.github.hotire.spring.utils.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.Objects;
import java.util.concurrent.Executor;

@RequiredArgsConstructor
public class AsyncApplicationEventMulticaster extends SimpleApplicationEventMulticaster {
    public AsyncApplicationEventMulticaster(final Executor executor) {
        setTaskExecutor(Objects.requireNonNull(executor));
    }
}

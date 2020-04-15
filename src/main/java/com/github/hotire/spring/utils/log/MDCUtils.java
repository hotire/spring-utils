package com.github.hotire.spring.utils.log;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MDCUtils {

    private final static MDCAdapter ADAPTER = MDC.getMDCAdapter();

    public static void put(String key, String value) {
        ADAPTER.put(key, value);
    }

    public static Optional<String> get(String key) {
        return Optional.ofNullable(ADAPTER.get(key));
    }

    public static void remove(String key) {
        ADAPTER.remove(key);
    }

    public static void clear() {
        ADAPTER.clear();;
    }

    public static Map<String, String> getCopyOfContextMap() {
        return ADAPTER.getCopyOfContextMap();
    }

    public static void putAll(Map<String, String> map) {
        map.forEach(ADAPTER::put);
    }
}


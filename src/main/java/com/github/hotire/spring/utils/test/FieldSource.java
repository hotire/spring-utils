package com.github.hotire.spring.utils.test;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(FieldArgumentsProvider.class)
public @interface FieldSource {
  String value();
}

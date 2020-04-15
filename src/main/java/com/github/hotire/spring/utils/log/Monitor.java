package com.github.hotire.spring.utils.log;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Monitor {
    boolean timer() default true;
    MonitorAspect.Level level() default MonitorAspect.Level.DEBUG;
}

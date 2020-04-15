package com.github.hotire.spring.utils.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Objects;


@Slf4j
@Aspect
@Component
public class MonitorAspect {

    interface Logger {
        void log(final String format, Object... args);
    }

    public enum Level implements Logger {
        TRACE {
            @Override
            public void log(String format, Object... args) {
                log.trace(format, args);
            }
        },
        DEBUG {
            @Override
            public void log(String format, Object... args) {
                log.debug(format, args);
            }
        },
        INFO {
            @Override
            public void log(String format, Object... args) {
                log.info(format, args);
            }
        },
        WARN {
            @Override
            public void log(String format, Object... args) {
                log.warn(format, args);
            }
        },
        ERROR {
            @Override
            public void log(String format, Object... args) {
                log.error(format, args);
            }
        }
        ;
    }

    @Around("@annotation(monitor)")
    public Object monitorMethod(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        return monitor(joinPoint, monitor);
    }

    @Around("@within(monitor)")
    public Object monitorType(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        return monitor(joinPoint, monitor);
    }

    protected Object monitor(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final StopWatch stopWatch = new StopWatch();
        final Logger logger = monitor.level();
        stopWatch.start();

        logger.log("monitor :{}", monitor);
        logger.log("Monitor Start");
        logger.log("method : {}", methodSignature.getMethod());

        for (Object arg : joinPoint.getArgs()) {
            if (Objects.nonNull(arg)) {
                logger.log("arg type : {} value : {}", arg.getClass().getSimpleName(), arg);
            }
        }

        final Object result = joinPoint.proceed();

        stopWatch.stop();;

        logger.log("result : {}", result);
        logger.log("total elapsed time : {}", stopWatch.getTotalTimeSeconds());
        logger.log("Monitor End");

        return result;
    }

}

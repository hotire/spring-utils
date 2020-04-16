package com.github.hotire.spring.utils.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class MonitorAspectTest {

    @Test
    void log() {
        // no assert
        Arrays.stream(MonitorAspect.Level.values())
              .forEach(level -> level.log("", ""));
    }

    @Test
    void monitorType() throws Throwable {
        // given
        final ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        final MethodSignature methodSignature = mock(MethodSignature.class);
        final Monitor monitor = mock(Monitor.class);
        final MonitorAspect monitorAspect = new MonitorAspect();

        // when
        when(proceedingJoinPoint.getSignature()).thenReturn(methodSignature);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{});
        when(monitor.level()).thenReturn(MonitorAspect.Level.DEBUG);
        when(monitor.timer()).thenReturn(false);
        monitorAspect.monitorType(proceedingJoinPoint, monitor);

        // then
        verify(proceedingJoinPoint, times(1)).proceed();
    }

    @Test
    void monitorMethod() throws Throwable {
        // given
        final ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        final MethodSignature methodSignature = mock(MethodSignature.class);
        final Monitor monitor = mock(Monitor.class);
        final MonitorAspect monitorAspect = new MonitorAspect();

        // when
        when(proceedingJoinPoint.getSignature()).thenReturn(methodSignature);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{});
        when(monitor.level()).thenReturn(MonitorAspect.Level.DEBUG);
        when(monitor.timer()).thenReturn(true);
        monitorAspect.monitorMethod(proceedingJoinPoint, monitor);

        // then
        verify(proceedingJoinPoint, times(1)).proceed();
    }
}
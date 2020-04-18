package org.springframework.security.oauth.samples.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(org.springframework.security.oauth.samples.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed();
		final long executionTime = System.currentTimeMillis() - start;
		logger.info(String.format("%s executed in %d milliseconds", joinPoint.getSignature(), executionTime));
		return proceed;
	}
}

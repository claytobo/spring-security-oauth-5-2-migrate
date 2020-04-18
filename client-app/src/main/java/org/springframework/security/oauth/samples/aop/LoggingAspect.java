package org.springframework.security.oauth.samples.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(org.springframework.security.oauth.samples.aop.LogExecution)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
    	Signature signature = joinPoint.getSignature();
    	String args = Arrays.toString(joinPoint.getArgs());
    	logger.info(String.format("%s started with the following arguments: %s", signature, args));
		final Object proceed = joinPoint.proceed();
		logger.info(String.format("%s finished with result %s", signature, proceed));
		return proceed;
	}
}

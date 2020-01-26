package com.jbk.springdemo.aspect;





import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingaspect {
	Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.jbk.springdemo.controller.*.*(..))")
	public void forcontroller() {}
	
	@Pointcut("execution(* com.jbk.springdemo.dao.*.*(..))")
	public void fordao() {}
	
	@Pointcut("execution(* com.jbk.springdemo.customerservice.*.*(..))")
	public void forService() {}
	
	@Pointcut("forcontroller() || forService() || forcontroller()")
	public void app() {}
	@Before("app()")
	public void appflow(JoinPoint joinpoint) {
		logger.info("@before advice>>"+joinpoint.getSignature().toShortString());
		Object[] obj=joinpoint.getArgs();
		for(Object args:obj) {
			logger.info("arguments passes>>"+args);
		}
		}
	@AfterReturning(pointcut = "app()",returning = "result")
	public void AfterReturn(JoinPoint join,Object result) {
		
		logger.info("@After returning>>"+join.getSignature().toShortString());
		logger.info("result>>"+result);
		
	}
	
	
	
	
	
}

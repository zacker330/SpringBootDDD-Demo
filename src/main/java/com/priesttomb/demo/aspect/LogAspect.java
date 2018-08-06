package com.priesttomb.demo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.priesttomb.demo.service.*.*(..))")
	private void pointCutMethod() {
		
	}
	
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("方法执行前，入参："+Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(pointcut = "pointCutMethod()", returning = "rtnParam")
	public void doAfterReturning(Object rtnParam) {
		logger.info("方法执行后，返回参数："+rtnParam);
	}
}

package codes.showme.demo.aspect;

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
	
	@Pointcut("execution(* codes.showme.demo.service.*.*(..))")
	private void pointCutMethod() {
		
	}
	
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("before execute, inParam = "+Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(pointcut = "pointCutMethod()", returning = "outParam")
	public void doAfterReturning(Object outParam) {
		logger.info("after execute, outParam = "+outParam);
	}
}

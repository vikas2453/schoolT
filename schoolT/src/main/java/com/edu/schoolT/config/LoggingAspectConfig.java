package com.edu.schoolT.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LoggingAspectConfig {
	
	private static LoggingAspectConfig loggingAspectConfig;

	@Bean
	public LoggingAspectConfig createBean() {
		if(loggingAspectConfig==null)
		return new LoggingAspectConfig();
		else
			return loggingAspectConfig;
	}
	
	
	private LoggingAspectConfig () {
		
	}

	@Before("execution(* com.edu.schoolT.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		if(log.isDebugEnabled()) {
			Object[] args= joinPoint.getArgs();
			Map<String, String> typeValue= new HashMap<>();
			for(Object obj: args) {
				if(obj!=null) {
					typeValue.put(obj.getClass().getName(), obj.toString());
				}
			}
			//log.debug("calling Method:"+joinPoint.getSignature().getDeclaringTypeName()+", "+joinPoint.getSignature().getName()+", Parameter:-> "+ typeValue);
		}
	}

	@AfterReturning(pointcut = "execution(* com.edu.schoolT.*.*.*(..))", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		/*if (log.isDebugEnabled() && result!=null) {			
			log.debug("Method returned:" + 
					joinPoint.getSignature().getName() + ", Result: " + result.getClass().getName()+" -->"+result);
		}*/
	}

}

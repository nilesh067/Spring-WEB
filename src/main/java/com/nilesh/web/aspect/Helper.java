package com.nilesh.web.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Helper {

		private static final Logger log = LoggerFactory.getLogger(Helper.class);	
		@Before(value = "DAONotifier()")
		public void methodCalled(JoinPoint joinPoint) {
			
			log.debug(""+joinPoint.toString()+" :: Execution Start.");
			log.debug(""+joinPoint.toString()+" :: Arguments :: "+Arrays.toString(joinPoint.getArgs()));
		}
		
		
		@After(value = "DAONotifier()")//advice without using point cut
		public void methodEnd(JoinPoint joinPoint) {
			log.debug(""+joinPoint.toString()+" :: Execution End.");
		}
		@Pointcut("execution(* com.nilesh.data.DAO.*.*(..))")
		public void DAONotifier() {}
		
		//@AfterReturning(pointcut="execution(* com.nilesh.data.DAO.*.*(..))",  returning="returnValue")
			    public void runAfter(JoinPoint joinPoint, String returnValue) throws Throwable {
			         
			        System.out.println("Inside RunAfterExecution.afterReturning() method...");
			        System.out.println("inserted after : " + joinPoint.getSignature().getName());
			        System.out.println("Method returned value is : " + returnValue);
			    }
			
}

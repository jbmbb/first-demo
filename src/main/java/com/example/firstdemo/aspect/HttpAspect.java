package com.example.firstdemo.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 切面
 * @author xxlai
 *
 */
@Aspect
@Component
public class HttpAspect {
	private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	/**
	 * 日志记录PersonController的所有方法的操作记录
	 */
	@Pointcut("execution(public * com.example.firstdemo.controller.PersonController.*(..))")
	public void log(){
		
	}
	
	/**
	 * 执行controller方法之前，记录请求的相应信息
	 * @param joinPoint
	 */
	@Before(value = "log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		logger.info("url={}",request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//类方法
		logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		logger.info("args={}",joinPoint.getArgs());
	}
	
	@After(value = "log()")
	public void doAfter(){
		
	}
	
	@AfterReturning(returning="object",pointcut="log()")
	public void doAfterReturning(Object object){
		logger.info("response={}",object.toString());
	}
}

package com.cwfkm.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cwfkm.annotation.RequiredLog;
import com.cwfkm.common.utils.IPUtils;
import com.cwfkm.common.utils.ShiroUtil;
import com.cwfkm.pojo.SysLog;
import com.cwfkm.service.ShiroService;
import com.cwfkm.service.SysLogService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class SyslogAspect {
	@Autowired
	private SysLogService sysLogService;
	@Autowired
	private ShiroService shiroService;

	@Pointcut("@annotation(com.cwfkm.annotation.RequiredLog)")
	private void doPointCut(){}
	
	@Around("doPointCut()")
	public Object doAround(ProceedingJoinPoint jp)throws Throwable{
		try {
		long startTime = System.currentTimeMillis();
		Object result = jp.proceed();
		long endTime = System.currentTimeMillis();
		savelog(jp,endTime-startTime);
		return result;
		}catch(Throwable e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	private void savelog(ProceedingJoinPoint jp, long l) throws Exception {
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Class<?> c = jp.getTarget().getClass();
		Method method = c.getDeclaredMethod(signature.getName(), signature.getParameterTypes());
		String opraString = method
				.getAnnotation(RequiredLog.class).operation();
		String targetClassMethod=c.getName()+"."+signature.getName();
		String params=//值为jason格式字符串
				new ObjectMapper().writeValueAsString(jp.getArgs());
		SysLog logObject = new SysLog(null, 
				shiroService.getUsernameInSubject(), 
				opraString, 
				targetClassMethod, params, l, 
				IPUtils.getIpAddr(), new Date());
		sysLogService.saveObject(logObject);
	}
}

package com.cwfkm.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cwfkm.annotation.ReForward;
import com.cwfkm.dao.SysExpDao;
import com.cwfkm.pojo.User;
import com.cwfkm.service.ShiroService;
import com.cwfkm.service.SysUserService;

@Aspect
@Component
public class ExpAspect {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ShiroService shiroService;
	@Autowired
	private SysExpDao sysExpDao;

	@Pointcut("@annotation(com.cwfkm.annotation.ReForward)")
	private void doPointCut(){}
	
	@Around("doPointCut()")
	public Object doAround(ProceedingJoinPoint jp)throws Throwable{
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Class<?> c = jp.getTarget().getClass();
		Method method = c.getDeclaredMethod(signature.getName(), signature.getParameterTypes());
		int incred = method.getAnnotation(ReForward.class).incred();
		String username = shiroService.getUsernameInSubject();
		Integer id = sysUserService.findIdByName(username);
		User user = sysUserService.findUserById(id);
		user.setSumExp(user.getSumExp()+incred);
		user.setLevel(sysExpDao.findObjectBylimit(user.getExp()).getLevel());
		sysUserService.updatePersonMsg(user);
		System.out.println(username+"：经验+"+incred);
		return jp.proceed();
	}
}

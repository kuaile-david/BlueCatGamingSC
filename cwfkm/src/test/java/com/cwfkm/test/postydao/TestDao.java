package com.cwfkm.test.postydao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cwfkm.dao.SysPostyDao;
import com.cwfkm.dao.SysUserDao;
import com.cwfkm.service.SysUserService;

@SpringBootTest
public class TestDao {
	@Autowired
	private SysPostyDao sysPostyDao;
	@Autowired
	private SysUserService sys;
	@Autowired
	private SysUserDao sysUserDao;
	
	
	@Test
	public void test1() {
		System.out.println("*************************"+sys.findUserById(28));
	}
	
}

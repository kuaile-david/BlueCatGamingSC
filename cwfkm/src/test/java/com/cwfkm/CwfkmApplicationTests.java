package com.cwfkm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cwfkm.dao.SysBoardMenuDao;

@SpringBootTest
class CwfkmApplicationTests {

	@Autowired
	SysBoardMenuDao dao;
	@Test
	void contextLoads() {
		System.out.println(dao.findAllObjects());
	}
}

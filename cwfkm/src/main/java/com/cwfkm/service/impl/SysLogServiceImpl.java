package com.cwfkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cwfkm.common.exception.ServiceException;
import com.cwfkm.common.utils.Assert;
import com.cwfkm.common.vo.PageObject;
import com.cwfkm.dao.SysLogDao;
import com.cwfkm.pojo.SysLog;
import com.cwfkm.service.SysLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
  *  日志模块业务层对象.
  *  思考:业务层对象要处理哪些业务呢?
 * 1)核心业务 (数据和业务的基本操作)
 * 2)拓展业务 (权限控制,缓存,异步,...)
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;
	
	/**
	 * @Async 描述的方法,表示让这个访问,运行在一个spring框架提供的线程对象中(
	 * 这个线程对象会来自于一个线程池).
	 */
	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveObject(SysLog entity) {
		String tName=Thread.currentThread().getName();
		System.out.println("Log.thread.name="+tName);
		sysLogDao.insertObject(entity);
		try{Thread.sleep(5000);}
		catch (Exception e) {e.printStackTrace();}
	}
	
	@Transactional
	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		//if(ids==null||ids.length==0)
		//	throw new IllegalArgumentException("请先选择");
		Assert.isValid(ids!=null&&ids.length>0,"请先选择");
		//2.执行删除业务
		int rows=sysLogDao.deleteObjects(ids);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public PageObject<SysLog> findPageObjects(
			String username, Integer pageCurrent){
		//1.参数校验
		Assert.isValid(pageCurrent!=null&&pageCurrent>=1, "页码值无效");
		//2.设置查询起始位置
		int pageSize=8;
		Page<SysLog> page=
		PageHelper.startPage(pageCurrent,pageSize);
		//3.查询当前页日志记录
		List<SysLog> records=sysLogDao.findPageObjects(username);
		return new PageObject<>(records,(int)page.getTotal(), pageCurrent, pageSize);
	} 
}

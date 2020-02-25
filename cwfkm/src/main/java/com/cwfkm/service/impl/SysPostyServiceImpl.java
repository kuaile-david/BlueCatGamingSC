package com.cwfkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import com.cwfkm.annotation.ReForward;
import com.cwfkm.common.exception.ServiceException;
import com.cwfkm.common.vo.PageObject;
import com.cwfkm.common.vo.SysPostyPageVo;
import com.cwfkm.common.vo.SysPostyVo;
import com.cwfkm.common.vo.SysReply;
import com.cwfkm.dao.SysPostyDao;
import com.cwfkm.dao.SysReplyDao;
import com.cwfkm.dao.SysUserDao;
import com.cwfkm.pojo.Posty;
import com.cwfkm.service.ShiroService;
import com.cwfkm.service.SysPostyService;

@Service
public class SysPostyServiceImpl implements SysPostyService{
	@Autowired
	private SysPostyDao sysPostyDao;
	@Autowired
	private SysReplyDao sysReplyDao;
	@Autowired
	private ShiroService shiroService;
	@Autowired
	private SysUserDao sysUserDao;
	
	
	@Override
	public SysPostyPageVo findPageObjectById(Integer postyId) {
		Integer userId = sysPostyDao.findObjectById(postyId).getUserId();
		
		Date createdTime = sysPostyDao.findObjectById(postyId).getCreatedTime();
		Date modifiedTime = sysPostyDao.findObjectById(postyId).getModifiedTime();
		String valid = sysPostyDao.findObjectById(postyId).getValid();
		
		//获取该用户所有主题
		List<SysPostyVo> postyList = sysPostyDao.findAllByUserId(userId);
		System.out.println(postyList.toString());
		//根据该用户获得经验值
		Integer exp = sysUserDao.findUserById(userId).getExp();
		//获取该用户所有回复
		List<SysReply> replyList = sysReplyDao.findAllByUserId(userId);
		//获取该主题内容
		SysPostyVo postyObject = sysPostyDao.findObjectById(postyId);
		//获取页面显示信息
		
		String username = postyObject.getUserName();
		Integer postyNum = postyList.size();
		Integer replyNum = replyList.size();
		String postyTitle = postyObject.getTitle();
		String postyContent = postyObject.getContent();		
		
		return new SysPostyPageVo(userId, username, postyNum, replyNum, postyTitle, postyContent, createdTime, modifiedTime, exp, valid);
		
		
	}
	@Override
	public PageObject<Posty> findPostyObjectsByName(String like, Integer pageCurrent,Integer pageSize) {
		int pageIndex = (pageCurrent-1)*pageSize;
		if(pageCurrent==null || pageCurrent<1) {
			throw new ServiceException("页码不正确");
		}
		int rowCount = sysPostyDao.countSearchPosty(like, pageIndex, pageSize); //传入的板块id
		if(rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		List<Posty> records = sysPostyDao.findPostyObjectsByName(like, pageIndex, pageSize);
		return new PageObject<Posty>(records, rowCount, pageCurrent, pageSize);
	}

	@Override
	public List<Posty> findReplyByPostyId(Integer postyId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ReForward(incred = 30)
	@Override
	public int updatePosty(String title,Integer boardId,String content) {
		String username = shiroService.getUsernameInSubject();
		Integer userid = sysUserDao.findIdByName(username);
		Posty posty = new Posty(userid, boardId, title, content, username, null);
		return sysPostyDao.insertContent(posty);
	}
}

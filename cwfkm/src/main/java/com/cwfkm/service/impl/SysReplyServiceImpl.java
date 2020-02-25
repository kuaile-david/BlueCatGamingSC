package com.cwfkm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwfkm.annotation.ReForward;
import com.cwfkm.common.exception.ServiceException;
import com.cwfkm.common.vo.PageObject;
import com.cwfkm.common.vo.SysReply;
import com.cwfkm.common.vo.SysReplyPageObject;
import com.cwfkm.dao.SysPostyDao;
import com.cwfkm.dao.SysReplyDao;
import com.cwfkm.dao.SysUserDao;
import com.cwfkm.pojo.Reply;
import com.cwfkm.service.SysReplyService;

@Service
public class SysReplyServiceImpl implements SysReplyService{
	
	@Autowired
	SysUserDao sysUserDao;
	@Autowired
	SysReplyDao sysReplyDao;
	@Autowired
	SysPostyDao sysPostyDao;
	
	public PageObject<SysReplyPageObject> findPageObjectByPostyId(Integer postyId, Integer pageCurrent) {
		
		if(pageCurrent==null || pageCurrent<1) {
			throw new ServiceException("页码不正确");
		}
		
		//根据帖子id获取每个帖子总回复数量
		int rowCount = sysReplyDao.getRowCounts(postyId);
		if(rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		//设定每页有9条数据
		int pageSize = 9;
		int pageIndex = (pageCurrent-1)*pageSize;
		
		List<SysReply> replyObjects = sysReplyDao.findPageObjectByPostyId(postyId, pageIndex, pageSize);
		
		List<SysReplyPageObject> records = new ArrayList<>();
		
		for (SysReply sysReplyVo : replyObjects) {
			Integer postyId1 = sysReplyVo.getPostyId();
			Integer boardId = sysReplyVo.getBoardId();
			Integer userId = sysReplyVo.getUserId();
			String userName = sysUserDao.findUserNameById(userId);
			Integer postyNum = sysPostyDao.findAllByUserId(userId).size();
			Integer replyNum = sysReplyDao.findAllByUserId(userId).size();
			
			String context = sysReplyVo.getContext();
			
			System.out.println(context);
			if(context==null) {
				throw new ServiceException("回复内容不能为空");
			}
			Date createdTime = sysReplyVo.getCreatedTime();
			String valid = sysReplyVo.getValid();
			
			records.add(new SysReplyPageObject(postyId1, boardId, userId, userName, postyNum, replyNum, context, createdTime, valid));
		}
		if(records==null || records.size()==0) {
			throw new ServiceException("没有记录");
		}
		return new PageObject<SysReplyPageObject>(records, rowCount, pageCurrent, pageSize);
	}

	@ReForward(incred = 10)
	@Override
	public int updateReply(Integer postyId, Integer username, String content) {
		return sysReplyDao.updateObject(new Reply(postyId, username, content));
	}



}

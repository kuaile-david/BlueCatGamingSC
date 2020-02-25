package com.cwfkm.bga.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bga.common.exception.ServiceException;
import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysPostyPageVo;
import com.bga.common.vo.SysPostyVo;
import com.bga.common.vo.SysReply;
import com.bga.pojo.Posty;
import com.bga.service.SysPostyService;
import com.cwfkm.bga.dao.SysPostyDao;


@Service
public class PostyServiceImpl implements SysPostyService{
	@Autowired
	private SysPostyDao sysPostyDao;
	@Autowired
	private ReplyFeignService sysReplyDao;
//	@Autowired
//	private ShiroService shiroService;
	@Autowired
	private UserFeignService sysUserDao;
	
	
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
	@Override
	public int updatePosty(String title, Integer boardId, String content) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	@Override
//	public int updatePosty(String title,Integer boardId,String content) {
////		String username = shiroService.getUsernameInSubject();
////		Integer userid = sysUserDao.findIdByName(username);
//		Posty posty = new Posty(userid, boardId, title, content, username, null);
//		return sysPostyDao.insertContent(posty);
//	}
}

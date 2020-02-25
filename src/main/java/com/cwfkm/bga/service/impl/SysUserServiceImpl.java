package com.cwfkm.bga.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bga.common.exception.ServiceException;
import com.bga.common.utils.Assert;
import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysMyPostyVo;
import com.bga.common.vo.SysPostyVo;
import com.bga.pojo.ExpLevel;
import com.bga.pojo.LogonObject;
import com.bga.pojo.User;
import com.bga.service.SysUserService;
import com.cwfkm.bga.dao.SysExpDao;
import com.cwfkm.bga.dao.SysUserDao;
import com.cwfkm.bga.service.PostyFeignService;
@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysExpDao sysExpDao;
	
	@Autowired
	private PostyFeignService sysPostyDao;
	
//	@Autowired
//	private ShiroService shiroService;
	@Override
	public User findUserById(Integer id) {
		User user = sysUserDao.findUserById(id);
		List<ExpLevel> empLevel = sysExpDao.findObjectByExp();
		Integer d = 0;
		Double c = 0.0;
		for (ExpLevel e : empLevel) {
			if(user.getSumExp()<e.getSumExp()) {
				user.setExp(user.getSumExp()-d);
				user.setLevel(e.getLevel());
				c =  (user.getExp().doubleValue()/e.getExp())*100;
				break;
			}else {
				d=e.getSumExp();
				continue;
			}
		}
		user.setPercent(c.intValue()+"%");
		return user;
	}
	@Override
	public int updatePersonMsg(User entity) {
		int rows = sysUserDao.updateObject(entity);

		return rows;
	}
//	@RequiredLog(operation = "修改密码")
	@Override
	public int updatePassword(String password, 
			String newPasssword, 
			String cfgPassword) {
				return 1;
//		//1.参数校验
//		Assert.isEmpty(password, "原密码不能为空");
//		Assert.isEmpty(newPasssword, "新密码不能为空");
//		Assert.isValid(newPasssword.equals(cfgPassword), "两次密码输入不一致");
//		//检查原密码是否正确
//		User user=ShiroUtil.getLoginUser();
//		String salt=user.getSalt();
//		SimpleHash sh=new SimpleHash("MD5",password, salt,1);
//		String hashedPwd=sh.toHex();
//		Assert.isValid(user.getPassword().equals(hashedPwd),"原密码不正确");
//		//2.更新密码
//		String newSalt=UUID.randomUUID().toString();
//		String newHashedPwd=new SimpleHash("MD5",cfgPassword, newSalt,1).toHex();
//		int rows=sysUserDao.updatePassword(newHashedPwd, newSalt,user.getId());
//		if(rows==0)
//			throw new ServiceException("更新失败");
//		//3.返回结果
//		return rows;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	@ReForward(incred = 5)
//	@RequiredLog(operation = "登录")
	@Override
	public int saveObject(LogonObject logonObject) {
//		//1.参数校验
//		Assert.isNull(logonObject, "保存对象不能为空");
//		Assert.isEmpty(logonObject.getUsername(), "用户名不能为空");
//		Assert.isEmpty(logonObject.getPassword(), "密码不能为空");
//		Assert.isEmpty(logonObject.getRoleId().toString(), "必须为用户分配角色");
//		//2.保存用户自身信息
//		//2.1对密码进行加密
//		String salt=UUID.randomUUID().toString();
//		SimpleHash sh=new SimpleHash(
//				"MD5",//algorithmName 算法名称
//				logonObject.getPassword(),//0source 未加密的密码
//				salt,//盐值
//				1);//hashIterations 加密次数
//		String newPassword=sh.toHex();
//		//2.2重新存储到entity对象
//		logonObject.setSalt(salt);
//		logonObject.setPassword(newPassword);
//		//2.3持久化用户信息
//		int rows=sysUserDao.saveUser(logonObject);
//		//3.保存用户和角色关系数据
//		//4.返回结果
//		return rows;
		return 1;
	}

	@Override
	public int isExists(String columnName, String columnValue) {
		//参数检验
		Assert.isEmpty(columnValue,"字段值不正确");
		//基于字段以及值进行统计查询
		return sysUserDao.isExist("sys_users", columnName, columnValue);
	}
	@Override
	public Integer findIdByName(String userName) {
		return sysUserDao.findIdByName(userName);
	}
	@Override
	public PageObject<SysMyPostyVo> findMyPostyById(Integer userId,Integer pageIndex ) {
		Integer pageSize=10;
		List<SysPostyVo> postyList = sysPostyDao.findPostysByUserId(userId, pageIndex, pageSize);
		List<SysMyPostyVo> list = new ArrayList<>();
		for (SysPostyVo posty : postyList) {
			Integer postyId = posty.getId();
			String title = posty.getTitle();
			Date createdTime = posty.getCreatedTime();
			Integer boardId = posty.getBoardId();
			String valid = posty.getValid();
			Integer replyNum = sysPostyDao.getRowCountsByUserId(userId);
			list.add(new SysMyPostyVo(postyId, title, createdTime, boardId, valid, replyNum));
		}
		Integer rowCount = sysPostyDao.getRowCountsByUserId(userId);
		return new PageObject<SysMyPostyVo>(list, rowCount, pageIndex, pageSize);
	}
	@Override
	public PageObject<User> findAllUser(Integer pageCurrent) {
		int pageSize = 10;
		int pageIndex = (pageCurrent-1)*pageSize;
		if(pageCurrent==null || pageCurrent<1) {
			throw new ServiceException("页码不正确");
		}
		int rowCount = sysUserDao.getCount(); //传入的板块id
		if(rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		List<User> records = sysUserDao.findAllUser(pageIndex,pageSize);
		return new PageObject<User>(records, rowCount, pageCurrent, pageSize);
	}

	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		if(id==null || id<=0) {
			throw new ServiceException("参数不合法,id="+id);
		}
		if(valid!=1&&valid!=0)
			throw new ServiceException("参数不合法,valie="+valid);
			if(StringUtils.isEmpty(modifiedUser))
			throw new ServiceException("修改用户不能为空");
			//2.执行禁用或启用操作
			int rows=sysUserDao.validById(id, valid, modifiedUser);
			//3.判定结果,并返回
			if(rows==0)
			throw new ServiceException("此记录可能已经不存在");
			return rows;
	}
}

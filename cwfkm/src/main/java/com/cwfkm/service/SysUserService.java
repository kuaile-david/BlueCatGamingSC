package com.cwfkm.service;

import com.cwfkm.common.vo.PageObject;
import com.cwfkm.common.vo.SysMyPostyVo;
import com.cwfkm.pojo.LogonObject;
import com.cwfkm.pojo.User;

public interface SysUserService {
	int validById(Integer id, Integer valid, String modifiedUser);
	/**
	 * 	基于用户id查找所有Id
	 * @param id
	 * @return
	 */
	PageObject<SysMyPostyVo> findMyPostyById(Integer id,Integer pageIndex);
	/**
	 * 	注册/新建用户
	 * @param logonObject
	 * @return
	 */
	int saveObject(LogonObject logonObject);
	/**
	 * 	根据id查找用户个性化信息
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	PageObject<User> findAllUser(Integer pageCurrent);
	/**	
	 * 	更改用户信息
	 * @param entity
	 * @return
	 */
	int updatePersonMsg(User entity);

	/**
	 * 	更改用户密码
	 */
	int updatePassword(String password, 
			String newPasssword, 
			String cfgPassword);
	/**
	 * 	注册查重
	 * @param columnName
	 * @param columnValue
	 * @return
	 */
	int isExists(String columnName,String columnValue);
	Integer findIdByName(String userName);
}

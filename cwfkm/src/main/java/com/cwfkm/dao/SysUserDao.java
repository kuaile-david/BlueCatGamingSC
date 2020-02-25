package com.cwfkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cwfkm.pojo.LogonObject;
import com.cwfkm.pojo.User;
@Mapper
public interface SysUserDao{
	/**
	 * 基于用户id ,修改用户信息状态
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	@Update("update sys_users set valid=#{valid},modified_user=#{modifiedUser},modified_time=now() where id=#{id}")
	int validById(@Param("id")Integer id,
					@Param("valid")Integer valid,
					@Param("modifiedUser")String modifiedUser);
	/**
	 * 分页查询所有用户信息
	 * */
	@Select("select * from sys_users limit #{pageCurrent},#{pageSize}")
	List<User> findAllUser(Integer pageCurrent,Integer pageSize);
	/**
	 * 根据id获取userName
	 * @param id
	 * @return
	 */
	@Select("select username from sys_users where id=#{id}")
	String findUserNameById(Integer id);
	
	
	/**
	 * 通过id获取User信息
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	/**
	 * 	持久化用户自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(User entity);
	/**	更新密码
	 * @param newHashedPwd
	 * @param newSalt
	 * @param id
	 * @return
	 */
	int updatePassword(String newHashedPwd, String newSalt, Integer id);
	/**
	 *  注册/新建用户
	 * @param user
	 * @return
	 */
	int saveUser(LogonObject logonObject);
	/**
	 * 	判定此列对应的值是否已经存在
	 * @param columnName
	 * @param columnValue
	 * @return	统计结果，结果大于0说明结果存在
	 */
	@Select("select count(*) from ${tableName} where ${columnName} =#{columnValue}")
	int isExist(
			@Param("tableName") String tableName,
			@Param("columnName") String columnName,
			@Param("columnValue") String columnValue);
	/**
	 * 基于用户名查找用户信息
	 * @param username
	 * @return
	 */
	@Select("select count(*) from sys_users")
	int getCount();
	
	@Select("select * from sys_users where username=#{username}")
	User findUserByUserName(String username);

	@Select("select id from sys_users where username=#{username}")
	Integer findIdByName(String username);
	
}

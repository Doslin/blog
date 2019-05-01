package com.java.dao;

import com.java.entity.Blogger;

/**
 * 博主Dao接口
 * @author 
 */
public interface BloggerDao {

	/**
	 * 查询博主信息
	 * @return
	 */
	public Blogger find();
	
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	/**
	 * 更新博主信息
	 * @param blogger
	 * @return
	 */
	public Integer update(Blogger blogger);
}

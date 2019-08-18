package com.web.dao;

import java.util.List;

import com.web.entity.InCheckProject;

public interface InCheckProjectDao {
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<InCheckProject> queryByCondition(InCheckProject inCheckProject);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(InCheckProject inCheckProject);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer inCheckID);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public InCheckProject queryById(Integer inCheckID);
	
	/**
	 * 添加
	 * @param department
	 */
	public void add(InCheckProject inCheckProject);
}

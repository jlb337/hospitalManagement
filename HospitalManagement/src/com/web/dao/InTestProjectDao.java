package com.web.dao;

import java.util.List;

import com.web.entity.InTestProject;

public interface InTestProjectDao {
	
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<InTestProject> queryByCondition(InTestProject inTestProject);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(InTestProject inTestProject);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer inTestID);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public InTestProject queryById(Integer inTestID);
	
	/**
	 * 添加
	 * @param department
	 */
	public void add(InTestProject inTestProject);
}

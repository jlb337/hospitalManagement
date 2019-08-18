package com.web.dao;



import java.util.List;

import com.web.entity.Duty;



/**
 * 值班的数据访问层
 * @author ASUS
 *
 */
public interface DutyDao {
	/**
	 * 全查询
	 * @return
	 */
	public List<Duty> query();
	
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<Duty> queryByCondition(Duty duty);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(Duty duty);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer dutyID);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public Duty queryById(Integer dutyID);
	
	/**
	 * 添加
	 * @param department
	 */
	public void add(Duty duty);
}
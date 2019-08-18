package com.web.dao;



import java.util.List;


import com.web.entity.OutRecord;



/**
 * 值班的数据访问层
 * @author ASUS
 *
 */
public interface OutRecordDao {
	/**
	 * 全查询
	 * @return
	 */
	public List<OutRecord> query();
	
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<OutRecord> queryByCondition(OutRecord outRecord);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(OutRecord outRecord);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer outRecordID);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public OutRecord queryById(Integer outRecordID);
	
	/**
	 * 修改
	 * @param department
	 */
	public void add(OutRecord outRecord);
}
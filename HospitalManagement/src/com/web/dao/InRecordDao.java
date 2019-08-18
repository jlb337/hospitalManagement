package com.web.dao;



import java.util.List;


import com.web.entity.InRecord;



/**
 * 值班的数据访问层
 * @author ASUS
 *
 */
public interface InRecordDao {
	/**
	 * 全查询
	 * @return
	 */
	public List<InRecord> query();
	
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<InRecord> queryByCondition(InRecord inRecord);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(InRecord inRecord);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer inRecordID);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public InRecord queryById(Integer inRecordID);
	
	/**
	 * 修改
	 * @param department
	 */
	public void add(InRecord inRecord);
}
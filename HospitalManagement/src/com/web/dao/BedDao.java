package com.web.dao;



import java.util.List;

import com.web.entity.Bed;


/**
 * 床位的数据访问层
 * @author ASUS
 *
 */
public interface BedDao {
	/**
	 * 全查询
	 * @return
	 */
	public List<Bed> query();
	
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<Bed> queryByCondition(Bed bed);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(Bed bed);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer bedIDs);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public Bed queryById(Integer bedID);
	
	/**
	 * 添加
	 * @param department
	 */
	public void add(Bed bed);
}
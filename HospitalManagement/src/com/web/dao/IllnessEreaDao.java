package com.web.dao;



import java.util.List;

import com.web.entity.IllnessErea;



/**
 * 床位的数据访问层
 * @author ASUS
 *
 */
public interface IllnessEreaDao {
	/**
	 * 全查询
	 * @return
	 */
	public List<IllnessErea> query();
	
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<IllnessErea> queryByCondition(IllnessErea illnessErea);
	
	/**
	 * 修改
	 * @param department
	 */
	public void update(IllnessErea illnessErea);
	
	/**
	 * 删除
	 * @param department
	 */
	public void delete(Integer illnessEreaID);
	
	/**
	 * in子句的查询
	 * @param ids
	 * @return
	 */
	public IllnessErea queryById(Integer illnessEreaID);
	
	/**
	 * 添加
	 * @param department
	 */
	public void add(IllnessErea illnessErea);
}
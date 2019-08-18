package com.web.biz;

import java.util.List;

import com.web.entity.Bed;

/**
 * 床位的业务逻辑层
 */
public interface BedBiz {
	/**
	 * 根据条件查询
	 * @return
	 */
	public List<Bed> query();
	
	public List<Bed> queryByCondition(Bed bed);
	
	public void update(Bed bed);
	
	public Bed queryById(Integer bedID);
	
	public void delete(Integer bedIDs);
	
	public void add(Bed bed);
}

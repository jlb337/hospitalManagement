package com.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.OrderDetail;

public interface OrderDetailDao {

	List<OrderDetail> query();
	
	List<OrderDetail> queryByCondition(Map<String, Object> map);
	
	OrderDetail findById(@Param("detailID") Integer detailID);
	
	void update(OrderDetail orderDetail);
	
	void delete(@Param("detailID") Integer detailID);

	void add(OrderDetail orderDetail);
}

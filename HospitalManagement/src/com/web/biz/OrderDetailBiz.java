package com.web.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.OrderDetail;

public interface OrderDetailBiz {

	public List<OrderDetail> query();
	
	public List<OrderDetail> queryByCondition(Map<String, Object> map);
	
	public OrderDetail findById(@Param("detailID") Integer detailID);

	public boolean update(OrderDetail orderDetail);
	
	public boolean delete(@Param("detailID") Integer detailID);
	
	public boolean add(OrderDetail orderDetail);
}

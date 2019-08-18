package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.OrderDetailBiz;
import com.web.dao.OrderDetailDao;
import com.web.entity.OrderDetail;
import com.web.util.MyBatisUtil;

public class OrderDetailBizImpl implements OrderDetailBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	OrderDetailDao od = sqlSession.getMapper(OrderDetailDao.class);
	
	@Override
	public List<OrderDetail> query() {
		List<OrderDetail> list = od.query();	
		sqlSession.close();
		return list; 
	}

	@Override
	public List<OrderDetail> queryByCondition(Map<String, Object> map) {
		return od.queryByCondition(map);
	}

	@Override
	public OrderDetail findById(Integer detailID) {
		OrderDetail t=od.findById(detailID);
		sqlSession.close();
		return t;
	}

	@Override
	public boolean update(OrderDetail orderDetail) {
		try {
			od.update(orderDetail);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.close();
			return false;
		}
	}

	@Override
	public boolean delete(Integer detailID) {
		od.delete(detailID);
		sqlSession.commit();//提交
		sqlSession.close();
		return true;
	}

	@Override
	public boolean add(OrderDetail orderDetail) {
		try {
			od.add(orderDetail);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.close();
			return false;
		}
	}
}

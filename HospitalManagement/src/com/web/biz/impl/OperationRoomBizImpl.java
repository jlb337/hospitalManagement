package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.OperationRoomBiz;
import com.web.dao.OperationRoomDao;
import com.web.entity.OperationRoom;
import com.web.util.MyBatisUtil;

public class OperationRoomBizImpl implements OperationRoomBiz{

	SqlSession sqlSession = MyBatisUtil.openSession();
	OperationRoomDao od = sqlSession.getMapper(OperationRoomDao.class);
	
	@Override
	public List<OperationRoom> query() {
		List<OperationRoom> list = od.query();	
		sqlSession.close();
		return list; 
	}

	@Override
	public List<OperationRoom> queryByCondition(OperationRoom operationRoom) {
		return od.queryByCondition(operationRoom);
	}

	@Override
	public OperationRoom findById(Integer operationRoomID) {
		OperationRoom t=od.findById(operationRoomID);
		sqlSession.close();
		return t;
	}

	@Override
	public boolean update(OperationRoom operationRoom) {
		try {
			od.update(operationRoom);
			
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
	public boolean delete(Integer operationRoomID) {
		od.delete(operationRoomID);
		sqlSession.commit();//提交
		sqlSession.close();
		return true;
	}

	@Override
	public boolean add(OperationRoom operationRoom) {
		try {
			od.add(operationRoom);
			
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

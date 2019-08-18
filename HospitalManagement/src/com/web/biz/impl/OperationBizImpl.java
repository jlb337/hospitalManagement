package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.OperationBiz;
import com.web.dao.OperationDao;
import com.web.entity.Operation;
import com.web.util.MyBatisUtil;

public class OperationBizImpl implements OperationBiz{

	SqlSession sqlSession = MyBatisUtil.openSession();
	OperationDao od = sqlSession.getMapper(OperationDao.class);
	
	@Override
	public List<Operation> query() {
		List<Operation> list = od.query();	
		sqlSession.close();
		return list; 
	}

	@Override
	public List<Operation> queryByCondition(Map<String, Object> map) {
		return od.queryByCondition(map);
	}

	@Override
	public Operation findById(Integer operationID) {
		Operation t=od.findById(operationID);
		sqlSession.close();
		return t;
	}

	@Override
	public boolean update(Operation operation) {
		try {
			od.update(operation);
			
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
	public boolean delete(Integer operationID) {
		od.delete(operationID);
		sqlSession.commit();//提交
		sqlSession.close();
		return true;
	}

	@Override
	public boolean add(Operation operation) {
		try {
			od.add(operation);
			
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

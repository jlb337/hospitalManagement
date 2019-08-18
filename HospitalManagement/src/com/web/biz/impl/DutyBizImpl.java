package com.web.biz.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.DutyBiz;
import com.web.dao.DutyDao;
import com.web.entity.Duty;
import com.web.util.MyBatisUtil;

public class DutyBizImpl implements DutyBiz {
	
	SqlSession sqlSession = MyBatisUtil.openSession();
	DutyDao dd = sqlSession.getMapper(DutyDao.class);
	

	@Override
	public List<Duty> query() {
		List<Duty> list = dd.query();
		sqlSession.close();
		return list;
	}

	@Override
	public List<Duty> queryByCondition(Duty duty) {
		List<Duty> list = dd.queryByCondition(duty);
		sqlSession.close();
		return list;
	}

	@Override
	public void update(Duty duty) {
		dd.update(duty);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public Duty queryById(Integer dutyID) {
		Duty duty = new Duty();
		duty = dd.queryById(dutyID);
		sqlSession.close();
		return duty;
	}

	@Override
	public void delete(Integer dutyID) {
		dd.delete(dutyID);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void add(Duty duty) {
		dd.add(duty);
		sqlSession.commit();
		sqlSession.close();
	}

}

package com.web.biz.impl;


import java.util.List;



import org.apache.ibatis.session.SqlSession;

import com.web.biz.OutRecordBiz;

import com.web.dao.OutRecordDao;

import com.web.entity.OutRecord;
import com.web.util.MyBatisUtil;

public class OutRecordBizImpl implements OutRecordBiz {
	SqlSession sqlSession = MyBatisUtil.openSession();
	OutRecordDao dd = sqlSession.getMapper(OutRecordDao.class);

	@Override
	public List<OutRecord> query() {
		List<OutRecord> list = dd.query();
		sqlSession.close();
		return list;
	}

	@Override
	public List<OutRecord> queryByCondition(OutRecord outRecord) {
		List<OutRecord> list = dd.queryByCondition(outRecord);
		sqlSession.close();
		return list;
	}

	@Override
	public void update(OutRecord outRecord) {
		dd.update(outRecord);
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public OutRecord queryById(Integer outRecordID) {
		OutRecord outRecord = new OutRecord();
		outRecord = dd.queryById(outRecordID);
		sqlSession.close();
		return outRecord;
	}

	@Override
	public void delete(Integer outRecordID) {
		dd.delete(outRecordID);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void add(OutRecord outRecord) {
		dd.add(outRecord);
		sqlSession.commit();
		sqlSession.close();
	}

}

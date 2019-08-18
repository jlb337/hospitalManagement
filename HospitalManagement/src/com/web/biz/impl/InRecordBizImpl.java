package com.web.biz.impl;


import java.util.List;



import org.apache.ibatis.session.SqlSession;

import com.web.biz.InRecordBiz;

import com.web.dao.InRecordDao;

import com.web.entity.InRecord;
import com.web.util.MyBatisUtil;

public class InRecordBizImpl implements InRecordBiz {
	SqlSession sqlSession = MyBatisUtil.openSession();
	InRecordDao dd = sqlSession.getMapper(InRecordDao.class);

	@Override
	public List<InRecord> query() {
		List<InRecord> list = dd.query();
		sqlSession.close();
		return list;
	}

	@Override
	public List<InRecord> queryByCondition(InRecord inRecord) {
		List<InRecord> list = dd.queryByCondition(inRecord);
		sqlSession.close();
		return list;
	}

	@Override
	public void update(InRecord inRecord) {
		dd.update(inRecord);
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public InRecord queryById(Integer inRecordID) {
		InRecord inRecord = new InRecord();
		inRecord = dd.queryById(inRecordID);
		sqlSession.close();
		return inRecord;
	}

	@Override
	public void delete(Integer inRecordID) {
		dd.delete(inRecordID);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void add(InRecord inRecord) {
		dd.add(inRecord);;
		sqlSession.commit();
		sqlSession.close();
	}

}

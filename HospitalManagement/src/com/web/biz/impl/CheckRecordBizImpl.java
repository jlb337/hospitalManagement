package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.CheckRecordBiz;
import com.web.dao.CheckRecordDao;

import com.web.entity.CheckRecord;

import com.web.util.MyBatisUtil;

public class CheckRecordBizImpl implements CheckRecordBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	CheckRecordDao cd = sqlSession.getMapper(CheckRecordDao.class);
	
	@Override
	public List<CheckRecord> query() {
		List<CheckRecord> list = cd.query();	
		sqlSession.close();
		return list; 
	}	
	
	
	@Override
	public List<CheckRecord> queryByCondition(Map<String, Object> map) {
		return cd.queryByCondition(map);
	}
	
	
	@Override
	public CheckRecord findById(Integer checkRecordID) {
		CheckRecord t=cd.findById(checkRecordID);
		sqlSession.close();
		return t;
	}


	@Override
	public boolean update(CheckRecord checkRecord) {
		try {
			cd.update(checkRecord);
			
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
	public boolean delete(Integer checkRecordID){
		cd.delete(checkRecordID);
		sqlSession.commit();//提交
		sqlSession.close();
		return true;
	}


	@Override
	public boolean add(CheckRecord checkRecord) {
		try {
			cd.add(checkRecord);
			
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

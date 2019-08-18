package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.DrugBiz;
import com.web.dao.DrugDao;
import com.web.entity.Drug;
import com.web.util.MyBatisUtil;

public class DrugBizImpl implements DrugBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	DrugDao dd = sqlSession.getMapper(DrugDao.class);
	
	@Override
	public Drug selectByID(Integer ID) {
		Drug drug = dd.selectByID(ID);
		sqlSession.close();
		return drug;
	}

	@Override
	public List<Drug> selectByCondition(Map<String, Object> map) {
		List<Drug> list = dd.selectByCondition(map);
		sqlSession.close();
		return list;
	}

	@Override
	public boolean update(Drug drug) {
		try {
			dd.update(drug);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Integer drugID) {
		try {
			dd.delete(drugID);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insert(Drug drug) {
		try {
			dd.insert(drug);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Drug> query() {
		List<Drug> list = dd.query();
		sqlSession.close();
		return list;
	}

}

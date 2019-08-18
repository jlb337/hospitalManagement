package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.DoctorAdviceBiz;
import com.web.dao.DoctorAdviceDao;
import com.web.entity.DoctorAdvice;
import com.web.util.MyBatisUtil;

public class DoctorAdviceBizImpl implements DoctorAdviceBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	DoctorAdviceDao dd = sqlSession.getMapper(DoctorAdviceDao.class);
	
	@Override
	public DoctorAdvice selectByID(Integer ID) {
		DoctorAdvice doctorAdvice = dd.selectByID(ID);
		return doctorAdvice;
	}

	@Override
	public List<DoctorAdvice> selectByCondition(DoctorAdvice doctorAdvice) {
		List<DoctorAdvice> list = dd.selectByCondition(doctorAdvice);
		return list;
	}

	@Override
	public boolean update(DoctorAdvice doctorAdvice) {
		
		try {
			dd.update(doctorAdvice);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Integer willID) {
		try {
			dd.delete(willID);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insert(DoctorAdvice doctorAdvice) {
		try {
			dd.insert(doctorAdvice);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

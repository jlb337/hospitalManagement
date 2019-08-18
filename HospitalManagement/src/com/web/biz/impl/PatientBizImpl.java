package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.PatientBiz;
import com.web.dao.PatientDao;
import com.web.entity.Patient;
import com.web.util.MyBatisUtil;

public class PatientBizImpl implements PatientBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	PatientDao dd = sqlSession.getMapper(PatientDao.class);
	
	@Override
	public List<Patient> query_Name() {
		// TODO Auto-generated method stub
		List<Patient> list = dd.query_Name();
		sqlSession.close();
		return list;
	}

	@Override
	public Patient selectByID(Integer ID) {
		Patient p = dd.selectByID(ID);
		return p;
	}

	@Override
	public List<Patient> selectByCondition(Patient patient) {
		List<Patient> p = dd.selectByCondition(patient);
		return p;
	}

	@Override
	public boolean update(Patient patient) {
		try {
			dd.update(patient);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Integer patientID) {

		try {
			dd.delete(patientID);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean insert(Patient patient) {
		try {
			dd.insert(patient);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

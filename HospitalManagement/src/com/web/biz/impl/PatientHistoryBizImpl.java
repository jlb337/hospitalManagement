package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.PatientHistoryBiz;
import com.web.dao.PatientHistoryDao;
import com.web.entity.PatientHistory;
import com.web.util.MyBatisUtil;

public class PatientHistoryBizImpl implements PatientHistoryBiz {
	SqlSession sqlSession = MyBatisUtil.openSession();
	PatientHistoryDao pd=sqlSession.getMapper(PatientHistoryDao.class);
	@Override
	public boolean insert(PatientHistory patientHistory) {
		boolean flag=pd.insert(patientHistory);
		sqlSession.commit();
		return flag;
	}

	@Override
	public List<PatientHistory> queryByCondition(PatientHistory patientHistory) {
		List<PatientHistory> result=pd.queryByCondition(patientHistory);
		sqlSession.close();
		return  result;
	}

	@Override
	public PatientHistory findById(Integer patientHistoryID) {
		PatientHistory result=pd.findById(patientHistoryID);
		sqlSession.close();
		return result;
	}

	@Override
	public boolean update(PatientHistory patientHistory) {
		try {
			pd.update(patientHistory);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(PatientHistory patientHistory) {
		try {
			pd.delete(patientHistory);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

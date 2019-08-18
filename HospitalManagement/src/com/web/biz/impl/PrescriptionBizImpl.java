package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.PrescriptionBiz;
import com.web.dao.PrescriptionDao;
import com.web.entity.Prescription;
import com.web.util.MyBatisUtil;

public class PrescriptionBizImpl implements PrescriptionBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	PrescriptionDao dd = sqlSession.getMapper(PrescriptionDao.class);

	@Override
	public List<Prescription> query() {
		List<Prescription> list = dd.query();
		sqlSession.close();
		return list;
	}

	@Override
	public Prescription selectByID(Integer ID) {
		Prescription prescription = dd.selectByID(ID);
		sqlSession.close();
		return prescription;
	}

	@Override
	public List<Prescription> selectByCondition(Map<String, Object> map) {
		List<Prescription> list =dd.selectByCondition(map);
		sqlSession.close();
		return list;
	}

	@Override
	public boolean update(Prescription prescription) {
		try {
			dd.update(prescription);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Integer prescriptionID2) {
		try {
			dd.delete(prescriptionID2);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insert(Prescription prescription) {
		try {
			dd.insert(prescription);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

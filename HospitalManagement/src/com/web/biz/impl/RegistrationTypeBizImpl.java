package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.RegistrationTypeBiz;
import com.web.dao.RegistrationTypeDao;
import com.web.entity.RegistrationType;
import com.web.util.MyBatisUtil;



public class RegistrationTypeBizImpl implements RegistrationTypeBiz {


	SqlSession sqlSession = MyBatisUtil.openSession();
	RegistrationTypeDao rd=sqlSession.getMapper(RegistrationTypeDao.class);
	
	@Override
	public boolean insert(RegistrationType registrationType) {
		boolean flag=rd.insert(registrationType);
		sqlSession.commit();
		
		return flag;
	}

	@Override
	public List<RegistrationType> queryByCondition(RegistrationType registrationType) {
		List<RegistrationType> result=rd.queryByCondition(registrationType);
		sqlSession.close();
		return  result;
	}

	@Override
	public RegistrationType findById(Integer registrationTypeID) {
		RegistrationType result=rd.findById(registrationTypeID);
		sqlSession.close();
		return result;
	}

	@Override
	public boolean update(RegistrationType registrationType) {
		try {
			rd.update(registrationType);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(RegistrationType registrationType) {
		try {
			rd.delete(registrationType);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<RegistrationType> listRegistrationType() {
		List<RegistrationType> result=rd.listRegistrationType();
		sqlSession.close();
		return result;
	}

}

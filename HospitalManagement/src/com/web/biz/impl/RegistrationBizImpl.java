package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.RegistrationBiz;
import com.web.dao.RegistrationDao;
import com.web.entity.Registration;
import com.web.util.MyBatisUtil;

public class RegistrationBizImpl implements RegistrationBiz {
	SqlSession sqlSession = MyBatisUtil.openSession();
	RegistrationDao rd=sqlSession.getMapper(RegistrationDao.class);
	
	@Override
	public boolean insert(Registration registration) {
		boolean flag=rd.insert(registration);
		sqlSession.commit();
		return flag;
	}

	@Override
	public List<Registration> queryByCondition(Registration registration) {
		List<Registration> result=rd.queryByCondition(registration);
		sqlSession.close();
		return  result;
	}

	@Override
	public Registration findById(Integer registrationID) {
		Registration result=rd.findById(registrationID);
		sqlSession.close();
		return result;
		
	}

	@Override
	public boolean update(Registration registration) {
		// TODO Auto-generated method stub
		try {
			rd.update(registration);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Registration registration) {
		// TODO Auto-generated method stub
		try {
			rd.delete(registration);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}

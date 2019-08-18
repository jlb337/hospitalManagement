package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.ChargeProjectSituationBiz;
import com.web.dao.ChargeProjectSituationDao;
import com.web.entity.ChargeProjectSituation;
import com.web.util.MyBatisUtil;

public class ChargeProjectSituationBizImpl implements ChargeProjectSituationBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	ChargeProjectSituationDao dd = sqlSession.getMapper(ChargeProjectSituationDao.class);
	@Override
	public List<ChargeProjectSituation> query() 
	{
		// TODO Auto-generated method stub
		List<ChargeProjectSituation> list = dd.query();
		sqlSession.close();
		return list;
	}
	
	
	@Override
	public ChargeProjectSituation selectByID(Integer ID) 
	{
		// TODO Auto-generated method stub
		ChargeProjectSituation c =dd.selectByID(ID);
		sqlSession.close();
		return c;
	}


	@Override
	public List<ChargeProjectSituation> selectByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<ChargeProjectSituation> list = dd.selectByCondition(map);
		sqlSession.close();
		return list;
	}


	@Override
	public boolean update(ChargeProjectSituation situation) {

		try {
			dd.update(situation);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(Integer chargeID) {
		
		try {
			dd.delete(chargeID);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean insert(ChargeProjectSituation situation) {
		try {
			dd.insert(situation);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}

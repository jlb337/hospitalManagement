package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.InCheckProjectBiz;
import com.web.dao.InCheckProjectDao;
import com.web.entity.InCheckProject;
import com.web.util.MyBatisUtil;

public class InCheckProjectBizImpl implements InCheckProjectBiz {
	
	SqlSession sqlSession = MyBatisUtil.openSession();
	InCheckProjectDao dd = sqlSession.getMapper(InCheckProjectDao.class);

	@Override
	public List<InCheckProject> queryByCondition(InCheckProject inCheckProject) {
		List<InCheckProject> list = dd.queryByCondition(inCheckProject);
		sqlSession.close();
		return list;
	}
	
	@Override
	public void update(InCheckProject inCheckProject) {
		dd.update(inCheckProject);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public InCheckProject queryById(Integer inCheckID) {
		InCheckProject inCheckProject = new InCheckProject();
		inCheckProject = dd.queryById(inCheckID);
		sqlSession.close();
		return inCheckProject;
	}

	@Override
	public void delete(Integer inCheckID) {
		dd.delete(inCheckID);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void add(InCheckProject inCheckProject) {
		dd.add(inCheckProject);
		sqlSession.commit();
		sqlSession.close();
	}

	

}

package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.InTestProjectBiz;
import com.web.dao.InTestProjectDao;
import com.web.entity.InTestProject;
import com.web.util.MyBatisUtil;

public class InTestProjectBizImpl implements InTestProjectBiz {
	SqlSession sqlSession = MyBatisUtil.openSession();
	InTestProjectDao dd = sqlSession.getMapper(InTestProjectDao.class);
	
	@Override
	public List<InTestProject> queryByCondition(InTestProject inTestProject) {
		 List<InTestProject> list = dd.queryByCondition(inTestProject);
		 sqlSession.close();
		 return list;
	}

	@Override
	public void update(InTestProject inTestProject) {
		dd.update(inTestProject);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public InTestProject queryById(Integer inTestID) {
		InTestProject inTestProject = new InTestProject();
		inTestProject = dd.queryById(inTestID);
		sqlSession.close();
		return inTestProject;
	}

	@Override
	public void delete(Integer inTestID) {
		dd.delete(inTestID);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void add(InTestProject inTestProject) {
		dd.add(inTestProject);
		sqlSession.commit();
		sqlSession.close();
	}

}

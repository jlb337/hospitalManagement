package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.TestProjectBiz;
import com.web.dao.TestProjectDao;
import com.web.entity.TestProject;
import com.web.util.MyBatisUtil;

public class TestProjectBizImpl implements TestProjectBiz{

	SqlSession sqlSession = MyBatisUtil.openSession();
	TestProjectDao td = sqlSession.getMapper(TestProjectDao.class);

	public List<TestProject> query() {
			List<TestProject> list = td.query();	
			sqlSession.close();
			return list; 
	}


	@Override
	public List<TestProject> queryByCondition(Map<String, Object> map) {
		return td.queryByCondition(map);
	}
	
	
	@Override
	public TestProject findById(Integer testID) {
		TestProject t=td.findById(testID);
		sqlSession.close();
		return t;
	}


	@Override
	public boolean update(TestProject testProject) {
		try {
			td.update(testProject);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.close();
			return false;
		}

	}
	
	@Override
	public boolean delete(Integer testID){
		td.delete(testID);
		sqlSession.commit();//提交
		sqlSession.close();
		return true;
	}


	@Override
	public boolean add(TestProject testProject) {
		try {
			td.add(testProject);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.close();
			return false;
		}
	}


}

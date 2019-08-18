package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.CheckProjectBiz;
import com.web.dao.CheckProjectDao;
import com.web.entity.CheckProject;
import com.web.util.MyBatisUtil;

public class CheckProjectBizImpl implements CheckProjectBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	CheckProjectDao cd = sqlSession.getMapper(CheckProjectDao.class);
	
	
	@Override
	public List<CheckProject> query() {
		List<CheckProject> list = cd.query();	
		sqlSession.close();
		return list;
	}
	
	
	@Override
	public List<CheckProject> queryByCondition(Map<String, Object> map) {
		return cd.queryByCondition(map);
	}
	
	
	@Override
	public CheckProject findById(Integer checkID) {
		CheckProject t=cd.findById(checkID);
		sqlSession.close();
		return t;
	}


	@Override
	public boolean update(CheckProject checkProject) {
		try {
			cd.update(checkProject);
			
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
	public boolean delete(Integer checkID){
		cd.delete(checkID);
		sqlSession.commit();//提交
		sqlSession.close();
		return true;
	}


	@Override
	public boolean add(CheckProject checkProject) {
		try {
			cd.add(checkProject);
			
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

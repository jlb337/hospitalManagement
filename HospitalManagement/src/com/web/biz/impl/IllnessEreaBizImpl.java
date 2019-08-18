package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.IllnessEreaBiz;
import com.web.dao.IllnessEreaDao;
import com.web.entity.IllnessErea;
import com.web.util.MyBatisUtil;

public class IllnessEreaBizImpl implements IllnessEreaBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	IllnessEreaDao dd = sqlSession.getMapper(IllnessEreaDao.class);
	
	@Override
	public List<IllnessErea> query() {
		List<IllnessErea> list = dd.query();
		sqlSession.close();
		return list;
	}

	@Override
	public List<IllnessErea> queryByCondition(IllnessErea illnessErea) {
		List<IllnessErea> list = dd.queryByCondition(illnessErea);
		sqlSession.close();
		return list;
	}

	@Override
	public void update(IllnessErea illnessErea) {
		dd.update(illnessErea);
		sqlSession.commit();
		sqlSession.close();
		
	}

	@Override
	public void delete(Integer illnessEreaID) {
		dd.delete(illnessEreaID);
		sqlSession.commit();
		sqlSession.close();
		
	}

	@Override
	public IllnessErea queryById(Integer illnessEreaID) {
		IllnessErea illnessErea = new IllnessErea();
		illnessErea = dd.queryById(illnessEreaID);
		sqlSession.close();
		return illnessErea;
	}

	@Override
	public void add(IllnessErea illnessErea) {
		dd.add(illnessErea);
		sqlSession.commit();
		sqlSession.close();
	}

}

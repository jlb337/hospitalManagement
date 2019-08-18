package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.BedBiz;
import com.web.dao.BedDao;
import com.web.entity.Bed;
import com.web.util.MyBatisUtil;

/**
 * 床位的业务逻辑层实现类
 * @author ASUS
 *
 */
public class BedBizImpl implements BedBiz{

	SqlSession sqlSession = MyBatisUtil.openSession();
	BedDao dd = sqlSession.getMapper(BedDao.class);

	/**
	 * 根据条件查询
	 */
	
	@Override
	public List<Bed> query(){
		List<Bed> list = dd.query();
		sqlSession.close();
		return list;
	}
	
	@Override
	public List<Bed> queryByCondition(Bed bed) {
		
		List<Bed> list = dd.queryByCondition(bed);
		sqlSession.close();
		return list;
	}

	@Override
	public void update(Bed bed) {

		dd.update(bed);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public Bed queryById(Integer bedID) {

		Bed bed = new Bed();
		bed = dd.queryById(bedID);
		sqlSession.close();
		return bed;
	}

	@Override
	public void delete(Integer bedIDs) {
		
		dd.delete(bedIDs);
		sqlSession.commit();
		sqlSession.close();

		
	}

	@Override
	public void add(Bed bed) {
		dd.add(bed);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
	
}

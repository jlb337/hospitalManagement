package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.DrugOrderBiz;
import com.web.dao.DrugOrderDao;
import com.web.entity.DrugOrder;
import com.web.entity.DrugOrderExample;
import com.web.util.MyBatisUtil;

public class DrugOrderBizImpl implements DrugOrderBiz {


	SqlSession sqlSession =MyBatisUtil.openSession();
	DrugOrderDao ud=sqlSession.getMapper(DrugOrderDao.class);
	
	@Override
	public List<DrugOrder> queryByCondition(DrugOrder drugOrder) {
		List<DrugOrder> t=ud.queryByCondition(drugOrder);	
		sqlSession.close();
		return t;	
	}
	
	@Override
	public long countByExample(DrugOrderExample example) {
		long t=ud.countByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public int deleteByExample(DrugOrderExample example) {
		int t=ud.deleteByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public int deleteByPrimaryKey(Integer DrugOrderId) {
		return ud.deleteByPrimaryKey(DrugOrderId);
	}

	@Override
	public int insert(DrugOrder record) {
		try {
			int r=ud.insert(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		//return ud.insert(record);
	}

	@Override
	public int insertSelective(DrugOrder record) {
		try {
			int r=ud.insertSelective(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<DrugOrder> selectByExample(DrugOrderExample example) {
		List<DrugOrder> t=ud.selectByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public DrugOrder selectByPrimaryKey(Integer DrugOrderId) {
		DrugOrder t=ud.selectByPrimaryKey(DrugOrderId);
		sqlSession.close();
		return t;
	}

	@Override
	public int updateByExampleSelective(DrugOrder record, DrugOrderExample example) {
		try {
			int r=ud.updateByExampleSelective(record, example);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public int updateByExample(DrugOrder record, DrugOrderExample example) {
		try {
			int r=ud.updateByExample(record, example);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public int updateByPrimaryKeySelective(DrugOrder record) {
		try {
			int r=ud.updateByPrimaryKeySelective(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateByPrimaryKey(DrugOrder record) {
		try {
			int r=ud.updateByPrimaryKey(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	

}

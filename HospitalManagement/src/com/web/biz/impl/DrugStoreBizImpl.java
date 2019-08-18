package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.DrugStoreBiz;
import com.web.dao.DrugStoreDao;
import com.web.entity.DrugStore;
import com.web.util.MyBatisUtil;

public class DrugStoreBizImpl implements DrugStoreBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	DrugStoreDao dd=sqlSession.getMapper(DrugStoreDao.class);
	
	
	@Override
	public boolean insert(DrugStore drugStore) {
		boolean flag=dd.insert(drugStore);
		sqlSession.commit();
		return flag;
	}

	@Override
	public List<DrugStore> queryByCondition(DrugStore drugStore) {
		List<DrugStore> result=dd.queryByCondition(drugStore);
		sqlSession.close();
		return  result;
	}

	@Override
	public DrugStore findById(Integer drugStoreID) {
		DrugStore result=dd.findById(drugStoreID);
		sqlSession.close();
		return result;
	}

	@Override
	public boolean update(DrugStore drugStore) {
		try {
			dd.update(drugStore);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(DrugStore drugStore) {
		try {
			dd.delete(drugStore);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

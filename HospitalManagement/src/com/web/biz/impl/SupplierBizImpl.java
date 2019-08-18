package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.SupplierBiz;
import com.web.dao.SupplierDao;
import com.web.entity.Supplier;
import com.web.util.MyBatisUtil;

public class SupplierBizImpl implements SupplierBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	SupplierDao dd = sqlSession.getMapper(SupplierDao.class);
	


	@Override
	public Supplier selectByID(Integer ID) {
		Supplier supplier = dd.selectByID(ID);
		sqlSession.close();
		return supplier;
	}

	@Override
	public List<Supplier> selectByCondition(Supplier supplier) {
		
		List<Supplier> list = dd.selectByCondition(supplier);
		sqlSession.close();
		return list;
	}

	@Override
	public boolean update(Supplier supplier) {
		
		try {
			dd.update(supplier);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Integer supplierID) {
		try {
			dd.delete(supplierID);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insert(Supplier supplier) {
		try {
			dd.insert(supplier);
			
			sqlSession.commit();//提交
			sqlSession.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Supplier> query() {
		List<Supplier> suppliers = dd.query();
		return suppliers;
	}

}

package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.SupplierDrugOrderBiz;
import com.web.dao.DepartmentDao;
import com.web.dao.SupplierDrugOrderDao;
import com.web.entity.SupplierDrugOrder;
import com.web.entity.SupplierDrugOrderExample;
import com.web.entity.SupplierDrugOrderKey;
import com.web.util.MyBatisUtil;

public class SupplierDrugOrderBizImpl implements SupplierDrugOrderBiz {

	SqlSession sqlSession = MyBatisUtil.openSession();
	SupplierDrugOrderDao sdd = sqlSession.getMapper(SupplierDrugOrderDao.class);
	@Override
	public List<SupplierDrugOrder> queryByCondition(SupplierDrugOrder sd) {
		List<SupplierDrugOrder> t=sdd.queryByCondition(sd);
//		sqlSession.close();
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public long countByExample(SupplierDrugOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(SupplierDrugOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(SupplierDrugOrderKey key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SupplierDrugOrder record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SupplierDrugOrder record) {
		
		int t=sdd.insertSelective(record);
		sqlSession.commit();
		sqlSession.close();
		return t;
	}

	@Override
	public List<SupplierDrugOrder> selectByExample(SupplierDrugOrderExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDrugOrder selectByPrimaryKey(SupplierDrugOrderKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(SupplierDrugOrder record, SupplierDrugOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(SupplierDrugOrder record, SupplierDrugOrderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(SupplierDrugOrder record) {
		int t= 0;
		try {
			t=sdd.updateByPrimaryKeySelective(record);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public int updateByPrimaryKey(SupplierDrugOrder record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBy2(SupplierDrugOrder sd) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}

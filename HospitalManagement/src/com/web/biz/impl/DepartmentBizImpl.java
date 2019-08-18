package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.DepartmentBiz;
import com.web.dao.DepartmentDao;
import com.web.entity.Department;
import com.web.util.MyBatisUtil;

public class DepartmentBizImpl implements DepartmentBiz {
	
	SqlSession sqlSession = MyBatisUtil.openSession();
	DepartmentDao dd = sqlSession.getMapper(DepartmentDao.class);

	@Override
	public List<Department> queryByCondition(Department department) {
		List<Department> result=dd.queryByCondition(department);
		sqlSession.close();
		return  result;
	}

	

	@Override
	public Department findById(Integer deptId) {
		Department result=dd.findById(deptId);
		sqlSession.close();
		return result;
	}

	@Override
	public boolean update(Department department) {
		try {
			dd.update(department);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Department department) {
	try {
			dd.delete(department);
			sqlSession.commit();//提交
			sqlSession.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insert(Department department) {
		boolean flag=dd.insert(department);
		sqlSession.commit();
		sqlSession.close();
		return flag;
	}



	@Override
	public List<Department> listDepartment() {
		List<Department> result =dd.listDepartment();
		sqlSession.close();
		return result;
	}

}

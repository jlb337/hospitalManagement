package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Department;



public interface DepartmentDao {
	public boolean insert(Department department);
	//public List<Department> query();
	public  List<Department> queryByCondition(Department department);
	//public List<Department> queryIds(@Param("ids") List<Integer> ids);
	public Department findById(@Param("departmentID")Integer departmentID);
	
	public boolean update(Department department);
	public boolean delete(Department department);
	public List<Department> listDepartment();
}

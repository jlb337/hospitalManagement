package com.web.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.CheckProject;


public interface CheckProjectBiz {
	
	public List<CheckProject> query();
	
	public List<CheckProject> queryByCondition(Map<String, Object> map);
	
	public CheckProject findById(@Param("checkID") Integer checkID);

	public boolean update(CheckProject checkProject);
	
	public boolean delete(@Param("checkID") Integer checkID);
	
	public boolean add(CheckProject checkProject);
}

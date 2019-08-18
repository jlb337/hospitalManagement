package com.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.CheckProject;

public interface CheckProjectDao {

	List<CheckProject> query();
	
	List<CheckProject> queryByCondition(Map<String, Object> map);
	
	CheckProject findById(@Param("checkID") Integer checkID);
	
	void update(CheckProject checkProject);
	
	void delete(@Param("checkID") Integer checkID);

	void add(CheckProject checkProject);

}

package com.web.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.TestProject;

public interface TestProjectBiz {
	
	public List<TestProject> query();
	
	public List<TestProject> queryByCondition(Map<String, Object> map);
	
	public TestProject findById(@Param("testID") Integer testID);

	public boolean update(TestProject testProject);
	
	public boolean delete(@Param("testID") Integer testID);
	
	public boolean add(TestProject testProject);


}

package com.web.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.web.entity.TestProject;

/**
 *门诊检查项目的数据访问层
 * @author guokaixin
 *
 */
public interface TestProjectDao {
	
	public List<TestProject> query();
	
	public List<TestProject> queryByCondition(Map<String, Object> map);
	
	public TestProject findById(@Param("testID") Integer testID);
	
	public void update(TestProject testProject);
	
	public void delete(@Param("testID") Integer testID);

	public void add(TestProject testProject);

}

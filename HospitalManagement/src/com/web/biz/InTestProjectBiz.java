package com.web.biz;

import java.util.List;

import com.web.entity.InTestProject;

public interface InTestProjectBiz  {
	
	public List<InTestProject> queryByCondition(InTestProject inTestProject);
	
	public void update(InTestProject inTestProject);
	
	public InTestProject queryById(Integer inTestID);
	
	public void delete(Integer inTestID);	
	
	public void add(InTestProject inTestProject);
}

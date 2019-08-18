package com.web.biz;

import java.util.List;

import com.web.entity.InCheckProject;

public interface InCheckProjectBiz  {
	
	public List<InCheckProject> queryByCondition(InCheckProject inCheckProject);
	
	public void update(InCheckProject inCheckProject);
	
	public InCheckProject queryById(Integer inCheckID);
	
	public void delete(Integer inCheckID);	
	
	public void add(InCheckProject inCheckProject);
}

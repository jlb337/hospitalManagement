package com.web.biz;

import java.util.List;


import com.web.entity.Duty;

public interface DutyBiz{
	public List<Duty> query();
	
	public List<Duty> queryByCondition(Duty duty);
	
	public void update(Duty duty);
	
	public Duty queryById(Integer dutyID);
	
	public void delete(Integer dutyID);
	
	public void add(Duty duty);
}

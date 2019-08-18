package com.web.biz;

import java.util.List;


import com.web.entity.OutRecord;

public interface OutRecordBiz  {
	public List<OutRecord> query();
	
	public List<OutRecord> queryByCondition(OutRecord outRecord);
	
	public void update(OutRecord outRecord);
	
	public OutRecord queryById(Integer outRecordID);
	
	public void delete(Integer outRecordID);
	
	public void add(OutRecord outRecord);
}

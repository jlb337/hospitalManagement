package com.web.biz;

import java.util.List;


import com.web.entity.InRecord;

public interface InRecordBiz  {
	public List<InRecord> query();
	
	public List<InRecord> queryByCondition(InRecord inRecord);
	
	public void update(InRecord inRecord);
	
	public InRecord queryById(Integer inRecordID);
	
	public void delete(Integer inRecordID);
	
	public void add(InRecord inRecord);
}

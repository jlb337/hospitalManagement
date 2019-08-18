package com.web.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.CheckRecord;


public interface CheckRecordBiz {
	
	public List<CheckRecord> query();
	
	public List<CheckRecord> queryByCondition(Map<String, Object> map);
	
	public CheckRecord findById(@Param("checkRecordID") Integer checkRecordID);

	public boolean update(CheckRecord checkRecord);
	
	public boolean delete(@Param("checkRecordID") Integer checkRecordID);
	
	public boolean add(CheckRecord checkRecord);
	

}

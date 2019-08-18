package com.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.CheckRecord;

public interface CheckRecordDao {
	
	List<CheckRecord> query();
	
	List<CheckRecord> queryByCondition(Map<String, Object> map);
	
	CheckRecord findById(@Param("checkRecordID") Integer checkRecordID);
	
	void update(CheckRecord checkRecord);
	
	void delete(@Param("checkRecordID") Integer checkRecordID);

	void add(CheckRecord checkRecord);
	


}

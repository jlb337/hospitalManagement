package com.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Operation;

public interface OperationDao {

	List<Operation> query();
	
	List<Operation> queryByCondition(Map<String, Object> map);
	
	Operation findById(@Param("operationID") Integer operationID);
	
	void update(Operation operation);
	
	void delete(@Param("operationID") Integer operationID);

	void add(Operation operation);
}

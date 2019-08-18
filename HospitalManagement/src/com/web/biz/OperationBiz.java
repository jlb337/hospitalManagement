package com.web.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Operation;

public interface OperationBiz {

	public List<Operation> query();
	
	public List<Operation> queryByCondition(Map<String, Object> map);
	
	public Operation findById(@Param("operationID") Integer operationID);

	public boolean update(Operation operation);
	
	public boolean delete(@Param("operationID") Integer operationID);
	
	public boolean add(Operation operation);
}

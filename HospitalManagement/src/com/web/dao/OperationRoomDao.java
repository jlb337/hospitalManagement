package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.OperationRoom;

public interface OperationRoomDao {

	List<OperationRoom> query();
	
	List<OperationRoom> queryByCondition(OperationRoom operationRoom);
	
	OperationRoom findById(@Param("operationRoomID") Integer operationRoomID);
	
	void update(OperationRoom operationRoom);
	
	void delete(@Param("operationRoomID") Integer operationRoomID);

	void add(OperationRoom operationRoom);
}

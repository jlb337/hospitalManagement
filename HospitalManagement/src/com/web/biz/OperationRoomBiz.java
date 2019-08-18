package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.OperationRoom;

public interface OperationRoomBiz {

	public List<OperationRoom> query();
	
	public List<OperationRoom> queryByCondition(OperationRoom operationRoom);
	
	public OperationRoom findById(@Param("operationRoomID") Integer operationRoomID);

	public boolean update(OperationRoom operationRoom);
	
	public boolean delete(@Param("operationRoomID") Integer operationRoomID);
	
	public boolean add(OperationRoom operationRoom);
}

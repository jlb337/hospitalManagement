package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.DrugStore;

public interface DrugStoreDao {
	public boolean insert(DrugStore drugStore);
	public List<DrugStore> queryByCondition(DrugStore drugStore);
	public DrugStore findById(@Param("drugStoreID")Integer drugStoreID);
	
	boolean update(DrugStore drugStore);
	boolean delete(DrugStore drugStore);
	
}

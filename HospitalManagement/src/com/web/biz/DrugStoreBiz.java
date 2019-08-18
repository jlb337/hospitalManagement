package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.DrugStore;

public interface DrugStoreBiz {
	public boolean insert(DrugStore drugStore);
	public List<DrugStore> queryByCondition(DrugStore drugStore);
	public DrugStore findById(@Param("drugStoreID")Integer drugStoreID);
	
	boolean update(DrugStore drugStore);
	boolean delete(DrugStore drugStore);
}

package com.web.dao;

import com.web.entity.Supplier;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SupplierDao 
{
	
	List<Supplier> query();

	Supplier selectByID(Integer ID);
    
    List<Supplier> selectByCondition(Supplier supplier);
    
    boolean update(Supplier supplier);
    
    boolean delete(@Param("supplierID") Integer supplierID);
    
    boolean insert(Supplier supplier);
    
}
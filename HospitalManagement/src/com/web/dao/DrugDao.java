package com.web.dao;

import com.web.entity.Drug;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DrugDao {

	List<Drug> query ();
    
    Drug selectByID(Integer ID);
    
    List<Drug> selectByCondition(Map<String, Object> map);
    
    boolean update(Drug drug);
    
    boolean delete(@Param("drugID") Integer drugID);
    
    boolean insert(Drug drug);
    
}
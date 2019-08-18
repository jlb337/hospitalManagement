package com.web.dao;

import com.web.entity.DoctorAdvice;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DoctorAdviceDao {

	
	DoctorAdvice selectByID(Integer ID);
    
    List<DoctorAdvice> selectByCondition(DoctorAdvice doctorAdvice);
    
    boolean update(DoctorAdvice doctorAdvice);
    
    boolean delete(@Param("willID") Integer willID);
    
    boolean insert(DoctorAdvice doctorAdvice);
	
}
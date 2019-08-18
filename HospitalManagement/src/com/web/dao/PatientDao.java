package com.web.dao;

import com.web.entity.Patient;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PatientDao {

	List<Patient> query_Name();
	
    Patient selectByID(Integer ID);
    
    List<Patient> selectByCondition(Patient patient);
    
    boolean update(Patient patient);
    
    boolean delete(@Param("patientID") Integer patientID);
    
    boolean insert(Patient patient);
	
}
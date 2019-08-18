package com.web.dao;

import com.web.entity.Prescription;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PrescriptionDao {

    List<Prescription> query();
    
    Prescription selectByID(Integer ID);
    
    List<Prescription> selectByCondition(Map<String, Object> map);
    
    boolean update(Prescription prescription);
    
    boolean delete(@Param("prescriptionID2") Integer prescriptionID2);
    
    boolean insert(Prescription prescription);

}
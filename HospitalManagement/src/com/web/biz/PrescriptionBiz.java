package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.entity.Prescription;




public interface PrescriptionBiz {

    public  List<Prescription> query();
    
    public Prescription selectByID(Integer ID);
    
    public List<Prescription> selectByCondition(Map<String, Object> mapn);
    
    public boolean update(Prescription prescription);
    
    public boolean delete(Integer prescriptionID2);
    
    public boolean insert(Prescription prescription);
}

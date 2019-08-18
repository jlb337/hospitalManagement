package com.web.biz;

import java.util.List;

import com.web.entity.Patient;




public interface PatientBiz {

    public List<Patient> query_Name();
    
    public Patient selectByID(Integer ID);
    
    public List<Patient> selectByCondition(Patient patient);
    
    public boolean update(Patient patient);
    
    public boolean delete(Integer patientID);
    
    public boolean insert(Patient patient);

}

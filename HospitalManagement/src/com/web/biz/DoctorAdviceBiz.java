package com.web.biz;

import java.util.List;

import com.web.entity.DoctorAdvice;




public interface DoctorAdviceBiz {

    
    public DoctorAdvice selectByID(Integer ID);
    
    public List<DoctorAdvice> selectByCondition(DoctorAdvice doctorAdvice);
    
    public boolean update(DoctorAdvice doctorAdvice);
    
    public boolean delete(Integer willID);
    
    public boolean insert(DoctorAdvice doctorAdvice);

}

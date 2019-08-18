package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.entity.Drug;




public interface DrugBiz {
	public List<Drug> query ();
    
    public Drug selectByID(Integer ID);
    
    public List<Drug> selectByCondition(Map<String, Object> map);
    
    public boolean update(Drug drug);
    
    public boolean delete(Integer drugID);
    
    public boolean insert(Drug drug);
}

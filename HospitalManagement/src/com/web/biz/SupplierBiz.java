package com.web.biz;

import java.util.List;

import com.web.entity.Supplier;




public interface SupplierBiz {

	List<Supplier> query();
    
    public Supplier selectByID(Integer ID);
    
    public List<Supplier> selectByCondition(Supplier supplier);
    
    public boolean update(Supplier supplier);
    
    public boolean delete(Integer supplierID);
    
    public boolean insert(Supplier supplier);
}

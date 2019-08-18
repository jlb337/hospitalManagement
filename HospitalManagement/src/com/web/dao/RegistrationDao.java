package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Registration;


public interface RegistrationDao {
	public boolean insert(Registration registration);
	public  List<Registration> queryByCondition(Registration registration); 
	public Registration findById(@Param("registrationID")Integer registrationID);
	public boolean update(Registration registration);
	public boolean delete(Registration registration);
}

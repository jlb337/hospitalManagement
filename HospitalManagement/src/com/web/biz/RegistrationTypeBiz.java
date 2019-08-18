package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.RegistrationType;

public interface RegistrationTypeBiz {
	public boolean insert(RegistrationType registrationType);
	public List<RegistrationType> queryByCondition(RegistrationType registrationType);
	public RegistrationType findById(@Param("registrationTypeID") Integer registrationTypeID);
	
	boolean update(RegistrationType registrationType);
	boolean delete(RegistrationType registrationType);
	List<RegistrationType> listRegistrationType();
}

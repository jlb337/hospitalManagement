package com.web.dao;

import com.web.entity.ChargeProjectSituation;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ChargeProjectSituationDao {

	//冗余
    List<ChargeProjectSituation> query();
    
    ChargeProjectSituation selectByID(Integer ID);
    
    List<ChargeProjectSituation> selectByCondition(Map<String, Object> map);
    
    boolean update(ChargeProjectSituation situation);
    
    boolean delete(@Param("chargeID") Integer chargeID);
    
    boolean insert(ChargeProjectSituation situation);
}
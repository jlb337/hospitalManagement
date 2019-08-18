package com.web.biz;

import java.util.List;
import java.util.Map;

import com.web.entity.ChargeProjectSituation;




public interface ChargeProjectSituationBiz {

    public  List<ChargeProjectSituation> query();
    
    public ChargeProjectSituation selectByID(Integer ID);
    
    public List<ChargeProjectSituation> selectByCondition(Map<String, Object> map);
    
    public boolean update(ChargeProjectSituation situation);
    
    public boolean delete(Integer chargeID);
    
    public boolean insert(ChargeProjectSituation situation);
}

package com.web.dao;

import com.web.entity.DrugOrder;
import com.web.entity.DrugOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrugOrderDao {
    long countByExample(DrugOrderExample example);

    int deleteByExample(DrugOrderExample example);

    int deleteByPrimaryKey(Integer drugOrderID);

    int insert(DrugOrder record);

    int insertSelective(DrugOrder record);

    List<DrugOrder> selectByExample(DrugOrderExample example);
    List<DrugOrder> queryByCondition(DrugOrder drugOrder);

    DrugOrder selectByPrimaryKey(Integer drugOrderID);

    int updateByExampleSelective(@Param("record") DrugOrder record, @Param("example") DrugOrderExample example);

    int updateByExample(@Param("record") DrugOrder record, @Param("example") DrugOrderExample example);

    int updateByPrimaryKeySelective(DrugOrder record);

    int updateByPrimaryKey(DrugOrder record);
}
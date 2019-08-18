package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.DrugOrder;
import com.web.entity.DrugOrderExample;

public interface DrugOrderBiz {
	List<DrugOrder> queryByCondition(DrugOrder drugOrder);
	long countByExample(DrugOrderExample example);

    int deleteByExample(DrugOrderExample example);

    int deleteByPrimaryKey(Integer drugOrderID);

    int insert(DrugOrder record);

    int insertSelective(DrugOrder record);

    List<DrugOrder> selectByExample(DrugOrderExample example);

    DrugOrder selectByPrimaryKey(Integer drugOrderID);

    int updateByExampleSelective(@Param("record") DrugOrder record, @Param("example") DrugOrderExample example);

    int updateByExample(@Param("record") DrugOrder record, @Param("example") DrugOrderExample example);

    int updateByPrimaryKeySelective(DrugOrder record);

    int updateByPrimaryKey(DrugOrder record);
}

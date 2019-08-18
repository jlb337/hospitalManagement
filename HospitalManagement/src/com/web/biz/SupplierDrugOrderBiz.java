package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.SupplierDrugOrder;
import com.web.entity.SupplierDrugOrderExample;
import com.web.entity.SupplierDrugOrderKey;

public interface SupplierDrugOrderBiz {
	
	List<SupplierDrugOrder> queryByCondition(SupplierDrugOrder sd);
	int updateBy2(SupplierDrugOrder sd);
	long countByExample(SupplierDrugOrderExample example);

    int deleteByExample(SupplierDrugOrderExample example);

    int deleteByPrimaryKey(SupplierDrugOrderKey key);

    int insert(SupplierDrugOrder record);

    int insertSelective(SupplierDrugOrder record);

    List<SupplierDrugOrder> selectByExample(SupplierDrugOrderExample example);

    SupplierDrugOrder selectByPrimaryKey(SupplierDrugOrderKey key);

    int updateByExampleSelective(@Param("record") SupplierDrugOrder record, @Param("example") SupplierDrugOrderExample example);

    int updateByExample(@Param("record") SupplierDrugOrder record, @Param("example") SupplierDrugOrderExample example);

    int updateByPrimaryKeySelective(SupplierDrugOrder record);

    int updateByPrimaryKey(SupplierDrugOrder record);
}

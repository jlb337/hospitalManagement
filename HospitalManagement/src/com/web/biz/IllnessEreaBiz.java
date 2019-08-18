package com.web.biz;

import java.util.List;

import com.web.entity.IllnessErea;

public interface IllnessEreaBiz {

	public List<IllnessErea> query();
	
	public List<IllnessErea> queryByCondition(IllnessErea illnessErea);

	public void update(IllnessErea illnessErea);

	public void delete(Integer illnessEreaID);

	public IllnessErea queryById(Integer illnessEreaID);
	
	public void add(IllnessErea illnessErea);

}

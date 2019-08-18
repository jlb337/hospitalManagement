package com.web.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Position;
import com.web.entity.PositionExample;

public interface PositionBiz {
	
	//public long countByExample(PositionExample example);
	public int deleteByExample(PositionExample example);
	public int deleteByPrimaryKey(Integer poId);
	public int insert(Position record);
	public int insertSelective(Position record);
	public List<Position> selectByExample(PositionExample example);
	public Position selectByPrimaryKey(Integer poId);
	/**
	 * Map<String,Object> map
	 * map.put("poName","医生");
	 * @return
	 */
	public List<Position>  queryByCondition(Map<String, Object> map);
	public List<Position>  query(Position position);
	public int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);
	public int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);
	public int updateByPrimaryKeySelective(Position record);
	public int updateByPrimaryKey(Position record);
}

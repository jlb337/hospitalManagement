package com.web.dao;

import com.web.entity.Position;
import com.web.entity.PositionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PositionDao {
    long countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer poId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer poId);
    
    public List<Position>  queryByCondition(Map<String, Object> map);
    public List<Position>  query(Position position);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}
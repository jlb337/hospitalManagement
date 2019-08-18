package com.web.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.web.biz.PositionBiz;
import com.web.dao.PositionDao;
import com.web.entity.Position;
import com.web.entity.PositionExample;
import com.web.util.MyBatisUtil;

public class PositionBizImpl implements PositionBiz {
	
	SqlSession sqlSession =MyBatisUtil.openSession();
	PositionDao dd=sqlSession.getMapper(PositionDao.class);
	
//	public long countByExample(PositionExample example)
//	{
//		
//	}

	public int deleteByExample(PositionExample example)
    {
    	return dd.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer poId)
	{
		return dd.deleteByPrimaryKey(poId);
	}

	public int insert(Position record)
	{
		try {
			int r=dd.insert(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		//return dd.insert(record);
	}

	public int insertSelective(Position record)
	{
		try {
			int r=dd.insertSelective(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		//return dd.insertSelective(record);
		
	}

	public List<Position> selectByExample(PositionExample example)
	{
		return dd.selectByExample(example);
	}

	public Position selectByPrimaryKey(Integer poId)
	{
		return dd.selectByPrimaryKey(poId);
	}

	public int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example)
	{
		try {
			int r=dd.updateByExampleSelective(record, example);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		//return dd.updateByExampleSelective(record, example);
	}

	public int updateByExample(@Param("record") Position record, @Param("example") PositionExample example)
	{
		try {
			int r=dd.updateByExample(record, example);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		//return dd.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Position record)
	{
		try {
			int r=dd.updateByPrimaryKeySelective(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateByPrimaryKey(Position record)
	{
		try {
			int r=dd.updateByPrimaryKey(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	/**
	 * Map<String,Object> map
	 * map.put("poName","医生");
	 * @return
	 */
	public List<Position>  queryByCondition(Map<String, Object> map) {
		List<Position> t=dd.queryByCondition(map);	
		sqlSession.close();
		return t;		
	}

	@Override
	public List<Position> query(Position position) {
		// TODO Auto-generated method stub
		List<Position> t=dd.query(position);
		sqlSession.close();
		return t;
	}
}

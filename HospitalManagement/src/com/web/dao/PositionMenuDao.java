package com.web.dao;

import com.web.entity.PositionMenu;
import com.web.entity.PositionMenuExample;
import com.web.entity.PositionMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMenuDao {
	
	/**
	 * 根据职位id得到菜单id集合
	 * @param poId
	 * @return
	 */
	public List<Integer> findMenuByPoId(@Param("poId") Integer poId);
	
	/**
     * 保存
     * @param record
     * @return
     */
   public int saveAuthority(Integer poId,Integer menuId);
   
   /**
    * 根据岗位id删除菜单信息
    * @param poId
    */
   public void deleteByPoId(Integer poId);
   
   /**
    * 添加
    * @param positionMenu
    */
   public void addMenuPosition(PositionMenu positionMenu);
	
	
    long countByExample(PositionMenuExample example);

    int deleteByExample(PositionMenuExample example);

    int deleteByPrimaryKey(PositionMenuKey key);

    int insert(PositionMenu record);

    int insertSelective(PositionMenu record);

    List<PositionMenu> selectByExample(PositionMenuExample example);

    PositionMenu selectByPrimaryKey(PositionMenuKey key);

    int updateByExampleSelective(@Param("record") PositionMenu record, @Param("example") PositionMenuExample example);

    int updateByExample(@Param("record") PositionMenu record, @Param("example") PositionMenuExample example);

    int updateByPrimaryKeySelective(PositionMenu record);

    int updateByPrimaryKey(PositionMenu record);
}
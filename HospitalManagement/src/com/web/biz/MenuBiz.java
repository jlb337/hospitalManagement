package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.Menu;
import com.web.entity.MenuExample;

public interface MenuBiz {

	/**
	 * 根据父级id查询菜单的信息
	 * @param parentId
	 * @return
	 */
	public List<Menu> findByParentID(@Param("parentID") Integer parentID);
	
	public List<Menu> findByCondition(Menu menu);
	
	long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuID);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuID);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
	
}

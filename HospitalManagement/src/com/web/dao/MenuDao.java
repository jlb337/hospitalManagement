package com.web.dao;

import com.web.entity.Menu;
import com.web.entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuDao {
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
    
    /**
	 * 根据父级id查询菜单的信息
	 * @param parentId
	 * @return
	 */
	List<Menu> findByParentID(Integer parentId);
	List<Menu> findByCondition(Menu menu);
}
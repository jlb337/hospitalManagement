package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.MenuBiz;
import com.web.dao.MenuDao;
import com.web.entity.Menu;
import com.web.entity.MenuExample;
import com.web.util.MyBatisUtil;

public class MenuBizImpl implements MenuBiz {
	
	SqlSession sqlSession = MyBatisUtil.openSession();
	MenuDao md = sqlSession.getMapper(MenuDao.class);

	@Override
	public List<Menu> findByParentID(Integer parentId) {
		
		//查询到第一层的菜单信息
		List<Menu> firstList = md.findByParentID(parentId);
		
		//递归调用算法
		execursion(firstList);
		
		return firstList;
	}

	/**
	 * 递归
	 */
	public void  execursion(List<Menu> firstList){
		if(firstList != null && firstList.size()>0){
			for (Menu tMenu : firstList) {
				//获取第二层菜单的父级id
				Integer twoparentId = tMenu.getMenuID();
				
				//得到第二层的菜单信息
				List<Menu> secondList = md.findByParentID(twoparentId);
				
				//递归调用
				execursion(secondList);
				
				tMenu.setChildMenu(secondList);//设置第一层菜单的子菜单
			}
		}
	}

	@Override
	public long countByExample(MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer menuID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Menu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Menu record) {
		// TODO Auto-generated method stub
		int t=md.insertSelective(record);
		sqlSession.commit();
		sqlSession.close();
		return t;
	}

	@Override
	public List<Menu> selectByExample(MenuExample example) {
		// TODO Auto-generated method stub
		List<Menu> t=md.selectByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public Menu selectByPrimaryKey(Integer menuID) {
		// TODO Auto-generated method stub
		Menu t=md.selectByPrimaryKey(menuID);
		sqlSession.close();
		return t;
	}

	@Override
	public int updateByExampleSelective(Menu record, MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Menu record, MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		int t=md.updateByPrimaryKeySelective(record);
		sqlSession.commit();
		sqlSession.close();
		return t;
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> findByCondition(Menu menu) {
		// TODO Auto-generated method stub
		List<Menu> t=md.findByCondition(menu);
		sqlSession.close();
		return t;
	}
	
	
}

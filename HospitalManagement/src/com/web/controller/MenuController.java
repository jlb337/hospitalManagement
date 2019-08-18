/**
 * 
 */
package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.MenuBiz;
import com.web.biz.PositionBiz;
import com.web.biz.PositionMenuBiz;
import com.web.biz.impl.MenuBizImpl;
import com.web.biz.impl.PositionBizImpl;
import com.web.biz.impl.PositionMenuBizImpl;
import com.web.entity.Menu;
import com.web.entity.Position;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;
import com.web.pojo.TreePojo;

/**
 * @author Justin林
 *
 */
@WebServlet(urlPatterns="/menu")
public class MenuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("menu");
		String method = req.getParameter("method");
				
		MenuBiz mb = new MenuBizImpl();
		if(method.equals("queryByCondition"))
		{
			System.out.println("queryByCondition");
			
			String menuName=req.getParameter("menuName");
			Menu m =new Menu();
			m.setMenuName(menuName);
			
			List<Menu> list=mb.findByCondition(m);
			

			//把数据传到页面上
			req.setAttribute("list", list);
			
			//把数据转换为json字符串
			String json = JsonUtil.getJson(list);
			  
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(json);//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
//		else if(method.equals("query"))
//		{
//			System.out.println("query");
//			Position p=new Position();
//			List<Position> list=pb.query(p);
//			String json = JsonUtil.getJson(list);
//			System.out.println(json);
//			//获取输出对象
//			PrintWriter out = resp.getWriter();
//			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
//			out.write(json);//输出
//			out.flush();//刷新
//			out.close();//关闭
//		}
		else if(method.equals("sendUpdate"))
		{
			System.out.println("sendUpdate");
			String menuID=req.getParameter("menuID");
			
			Menu m =new Menu();
			if(StringUtil.isStrNotEmpty(menuID))
				m =  mb.selectByPrimaryKey(Integer.parseInt(menuID));
			
			//把数据转换为json字符串
			String json = JsonUtil.getJson(m);
			System.out.println(json);
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(json);//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("update"))
		{
			System.out.println("update");
			//修改
			String menuID = req.getParameter("menuID");
			String menuName = req.getParameter("menuName");
			String menuURL = req.getParameter("menuURL");
			String menuImage = req.getParameter("menuImage");
			Menu m=new Menu();
			
			if(StringUtil.isStrNotEmpty(menuID))
			{
				m.setMenuID(Integer.parseInt(menuID));				
			}
			else
			{
				System.out.println("menuID为空");
			}
			m.setMenuName(menuName);
			m.setMenuUrl(menuURL);
			m.setMenuImage(menuImage);
			//TODO
			int flag1=mb.updateByPrimaryKeySelective(m);

			 
			//System.out.println(flag1);
			 
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag1==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("add"))
		{
			System.out.println("add");
			
			String menuName = req.getParameter("menuName");
			String menuURL = req.getParameter("menuURL");
			String menuImage = req.getParameter("menuImage");
			Menu m=new Menu();
			
			m.setMenuName(menuName);
			m.setMenuUrl(menuURL);
			m.setMenuImage(menuImage);
			
			
			int flag=mb.insertSelective(m);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
		else if(method.equals("delete"))
		{
			System.out.println("delete");
			
			String MenuID=req.getParameter("MenuID");
			
			Menu m=new Menu();
			if(StringUtil.isStrNotEmpty(MenuID))
			{
				m.setMenuID(Integer.parseInt(MenuID));
			}
			else
			{
				System.out.println("MenuID为空");
			}
			m.setIsDelete(1);
			
			int flag=mb.updateByPrimaryKeySelective(m);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else
		{
			System.out.println("no such method\n\n");
		}
		
	}
	
	
	/**
	 * 匹配权限
	 * @param menuList
	 * @param myList
	 * @return
	 */
	public List<TreePojo> merge(List<Integer> menuList,List<Menu> allMenu ){
		
		List<TreePojo> list = new ArrayList<>();
		
		for (Menu tMenu : allMenu) {
			TreePojo pj = new TreePojo();
			
			//判断是否有权限 来设置是否选中状态
			pj.setChecked(hasAuthority(tMenu.getMenuID(), menuList));
			
			//递归
			pj.setChildren(merge(menuList,tMenu.getChildMenu()));
			
			pj.setIcon(tMenu.getMenuImage());
			pj.setId(tMenu.getMenuID());
			pj.setUrl(tMenu.getMenuUrl());
			pj.setPid(tMenu.getParentID());
			pj.setName(tMenu.getMenuName());
			
			list.add(pj);
			
		}
		return list;
	}
	
	/**
	 * 判断是否有权限
	 * @param menuId
	 * @param menuList
	 * @return
	 */
	public boolean hasAuthority(Integer menuId,List<Integer> menuList){
		
		for (Integer b : menuList) {
			
			if(menuId == b){
				return true;//有权限
			}
		}
		return false;//没有权限
	}
	

}

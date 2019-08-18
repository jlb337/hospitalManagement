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
@WebServlet(urlPatterns="/position")
public class PositionController extends HttpServlet {

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
		System.out.println("position");
		String method = req.getParameter("method");
		
		PositionBiz pb=new PositionBizImpl();
		PositionMenuBiz pmb = new PositionMenuBizImpl();
//		DepartmentBiz db=new DepartmentBizImpl();
		MenuBiz mb = new MenuBizImpl();
		if(method.equals("queryByCondition"))
		{
			System.out.println("queryByCondition");
			
			Map<String, Object> map = new HashMap<>();
			
			String poName = req.getParameter("poName");
			if(StringUtil.isStrNotEmpty(poName)){
				map.put("poName", poName);
			}
			
			String poSalary1 = req.getParameter("poSalary1");
			if(StringUtil.isStrNotEmpty(poSalary1)){
				map.put("poSalary1", Double.parseDouble(poSalary1));
			}
			
			String poSalary2 = req.getParameter("poSalary2");
			if(StringUtil.isStrNotEmpty(poSalary2)){
				map.put("poSalary2", Double.parseDouble(poSalary2));
			}
			
			String departmentIDs = req.getParameter("departmentID");
			if(StringUtil.isStrNotEmpty(departmentIDs)){
				Integer departmentID = Integer.parseInt(departmentIDs);
				if(departmentID  != 0){
					map.put("departmentID", departmentID);
				}
			}
			
			List<Position> list=pb.queryByCondition(map);
			

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
		else if(method.equals("query"))
		{
			System.out.println("query");
			Position p=new Position();
			List<Position> list=pb.query(p);
			String json = JsonUtil.getJson(list);
			System.out.println(json);
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(json);//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("sendUpdate"))
		{
			System.out.println("sendUpdate");
			String poId=req.getParameter("poId");
			System.out.println("jlb:"+poId);
			Position position =  pb.selectByPrimaryKey(Integer.parseInt(poId));
			System.out.println(position);
			//把数据转换为json字符串
			String json = JsonUtil.getJson(position);
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
			String poId = req.getParameter("poId");
			String departmentID = req.getParameter("departmentID");
			String poName = req.getParameter("poName");
			String poSalary = req.getParameter("poSalary");
			
//			TDepartment department = new TDepartment();
			Position position =new Position();
			position.setPoId(Integer.parseInt(poId));
			position.setDepartmentID(Integer.parseInt(departmentID));
			position.setPoName(poName);
			position.setPoSalary(poSalary);
	
			int flag1=pb.updateByPrimaryKeySelective(position);

			 
			System.out.println(flag1);
			 
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag1==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("sendAuthority"))
		{
			System.out.println("sendAuthority");
			String poId = req.getParameter("poId");

			//根据职位id查询菜单id集合  （权限)
			List<Integer> menuList = pmb.findMenuByPoId(Integer.parseInt(poId));

			//查询所有的菜单
			List<Menu> allMenu = mb.findByParentID(null);

			//匹配操作
			List<TreePojo> myList = merge(menuList,allMenu);
//			List<MenuPojo> myList = merge(menuList,allMenu);

			//把数据转换为json字符串
			String json = JsonUtil.getJson(myList);

			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(json);//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("saveAuthority"))
		{
			System.out.println("saveAuthority");
			String idss = req.getParameter("menuIDs");//"1,2,3,4,5,6"
			String[] ids = idss.split(",");//【1,2,3,4,5】

			Integer poId = Integer.parseInt(req.getParameter("poId").toString());
			System.out.println(poId);
			int[] idsInt = new int[ids.length];

			for(int i=0;i<ids.length;i++){
			idsInt[i]=Integer.parseInt(ids[i]);
			}

			boolean flag = pmb.saveAuthority(poId, idsInt);

			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("add"))
		{
			System.out.println("add");
			
			String poId = req.getParameter("poId");
			String departmentID = req.getParameter("departmentID");
			String poName = req.getParameter("poName");
			String poSalary = req.getParameter("poSalary");
			
			Position p =new Position();
			if(StringUtil.isStrNotEmpty(poId))
			{
				p.setPoId(Integer.parseInt(poId));				
			}
			else
			{
				System.out.println("Ids为空");
			}
			if(StringUtil.isStrNotEmpty(departmentID))
			{
				p.setDepartmentID(Integer.parseInt(departmentID));
			}
			else
			{
				System.out.println("departmentID为空");
			}
			
			p.setPoName(poName);
			p.setPoSalary(poSalary);
			
			int flag=pb.insertSelective(p);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
		else if(method.equals("delete"))
		{
			System.out.println("delete");
			
			String poIds=req.getParameter("poId");
			
			Position p =new Position();
			if(StringUtil.isStrNotEmpty(poIds))
			{
				p.setPoId(Integer.parseInt(poIds));
			}
			else
			{
				System.out.println("userIds为空");
			}
			p.setIsDelete(1);
			
			int flag=pb.updateByPrimaryKeySelective(p);
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

package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.code.kaptcha.Constants;
import com.web.biz.MenuBiz;
import com.web.biz.PositionMenuBiz;
import com.web.biz.UserBiz;
import com.web.biz.impl.MenuBizImpl;
import com.web.biz.impl.PositionMenuBizImpl;
import com.web.biz.impl.UserBizImpl;
import com.web.entity.Menu;
import com.web.entity.User;
import com.web.entity.UserExample;
import com.web.entity.UserExample.Criteria;
import com.web.pojo.MenuPojo;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/user")
public class UserController extends HttpServlet {
	
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
		System.out.println("user");
		String method = req.getParameter("method");
		
		UserBiz ub=new UserBizImpl();
		PositionMenuBiz pmb = new PositionMenuBizImpl();
		
		MenuBiz mb = new MenuBizImpl();
		if(method.equals("login"))
		{
			//登录
			System.out.println("login!");
			//判断验证码是否输入正确
			HttpSession session = req.getSession();
			
			//获取随机生成的验证码
			String randomCode = session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
			
			//获取页面上输入的验证码
			String code = req.getParameter("code");
			
			if(code.equalsIgnoreCase(randomCode))
			{
				System.out.println("验证码正确");
				//判断用户名和密码在数据库中是否存在
				String userName = req.getParameter("userName");
				String userPassword = req.getParameter("userPassword");
				
				//调用用户的业务逻辑层方法
				User user = ub.login(userName, userPassword);
				
				if(user !=null){
					
					System.out.println("登录成功！");
					//得到用户的职位id
					Integer poId = user.getPoId();
					
					String userPhoto=user.getUserPhoto();
					

					String userSex=user.getUserSex();
					//根据职位id查询菜单id集合  （权限)
					List<Integer> menuList = pmb.findMenuByPoId(poId);
					
					//查询所有的菜单,null表示根节点
					List<Menu> allMenu = mb.findByParentID(null);
					
					//匹配操作，查看该职位id能查看那些菜单
					List<MenuPojo> myList = merge(menuList,allMenu);
					
					//把数据传到页面上去
					req.setAttribute("mymenuList", myList);	
					req.setAttribute("userPhoto", userPhoto);
					req.setAttribute("userName", userName);
					req.setAttribute("userSex", userSex);
					
					//转发跳转页面
					req.getRequestDispatcher("menu_demo.jsp").forward(req, resp);
					
				}else{
					//用户名和密码输入错误
					System.out.println("用户名和密码输入错误");
					//获取输出对象
					req.getRequestDispatcher("login_1.jsp").forward(req, resp);
				}
				
			}else{
				//验证码输入错误
				System.out.println("验证码输入错误");
				  

				req.getRequestDispatcher("login_1.jsp").forward(req, resp);
			}
			
		
		}
		else if(method.equals("login1"))
		{
			//登录
			System.out.println("login1!");
			//判断验证码是否输入正确
			HttpSession session = req.getSession();
			
			//获取随机生成的验证码
			String randomCode = session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
			
			//获取页面上输入的验证码
			String code = req.getParameter("code");
			
			if(code.equalsIgnoreCase(randomCode))
			{
				System.out.println("验证码正确");
				//判断用户名和密码在数据库中是否存在
				String userName = req.getParameter("userName");
				String userPassword = req.getParameter("userPassword");
				
				//调用用户的业务逻辑层方法
				User user = ub.login(userName, userPassword);
				
				if(user !=null){
					
					System.out.println("登录成功！");
		
				}else{
					//用户名和密码输入错误
					System.out.println("用户名和密码输入错误");
					//把数据转换为json字符串
					  
					//获取输出对象
					PrintWriter out = resp.getWriter();
					resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
					out.write("2");//输出
					out.flush();//刷新
					out.close();//关闭
				}
				
			}else{
				//验证码输入错误
				System.out.println("验证码输入错误");
				  
				//获取输出对象
				PrintWriter out = resp.getWriter();
				resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
				out.write("1");//输出
				out.flush();//刷新
				out.close();//关闭
				
			}
			
		
		}
		else if(method.equals("listDoctor"))
		{
			System.out.println("listDoctor");
			
			String departmentID=req.getParameter("departmentID");
			
			UserExample example=new UserExample();
			Criteria c=example.createCriteria();
			if(StringUtil.isStrNotEmpty(departmentID)){
				//map.put("poSalary1", Double.parseDouble(poSalary1));
				c.andDepartmentIDEqualTo(Integer.parseInt(departmentID));
			}
			else
			{
				System.out.println("departmentID is null!\n");
			}
			List<User> list=ub.selectByExample(example);
			
			//把数据传到页面上
			req.setAttribute("doctorList", list);
			
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
			
			UserExample example=new UserExample();
			List<User> list=ub.selectByExample(example);
			
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
		else if(method.equals("queryPositionAndDepartmentByCondition"))
		{
			System.out.println("queryPositionAndDepartmentByCondition");
			
			String userIds=req.getParameter("userId");
			String userName=req.getParameter("userName");
			String userSex=req.getParameter("userSex");
			String departmentID=req.getParameter("departmentID");
			String poId=req.getParameter("poId");
			
			User user=new User();
			if(StringUtil.isStrNotEmpty(userIds))
			{
				user.setUserId(Integer.parseInt(userIds));				
			}
			else
			{
				System.out.println("userIds为空");
			}
			if(StringUtil.isStrNotEmpty(departmentID))
			{
				user.setDepartmentID(Integer.parseInt(departmentID));				
			}
			else
			{
				System.out.println("departmentID为空");
			}
			if(StringUtil.isStrNotEmpty(poId))
			{
				user.setPoId(Integer.parseInt(poId));				
			}
			else
			{
				System.out.println("poId为空");
			}
			user.setUserName(userName);
			user.setUserSex(userSex);
			System.out.println(userSex);
			List<User> list=ub.queryPositionAndDepartmentByCondition(user);
			
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
		else if(method.equals("sendUpdate"))
		{
			System.out.println("sendUpdate");
			String userId=req.getParameter("userId");
			System.out.println("userId:"+userId);
			User user =ub.selectByPrimaryKey(Integer.parseInt(userId));
			//Position position =  pb.selectByPrimaryKey(Integer.parseInt(poId));
			System.out.println(user);
			//把数据转换为json字符串
			String json = JsonUtil.getJson(user);
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
			
			//JSONObject object=new JSONObject("user");
			//JSONObject jsonOb = object.getJSONObject(0+"");
			//String userId= jsonOb.getString("userId");
			//修改
//			String user1 = req.getParameter("user");
//			System.out.println(user1);
			String userId = req.getParameter("userId");
			String userName = req.getParameter("userName");
			String departmentID = req.getParameter("departmentID");
			String poId = req.getParameter("poId");
			String userDescribe = new String(req.getParameter("userDescribe").getBytes("iso-8859-1"),"utf-8");//用request获取URL传递的中文参数
			String userPhoto = req.getParameter("userPhoto");
			int baseURL="D:/SummerProject/project_zhenghe/HospitalManagement/WebContent/".length();
			String photo=userPhoto.substring(baseURL);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String sdate=req.getParameter("userBirthday");
			System.out.println(sdate);
			//Date date=null;
			User u=new User();
			try {
				u.setUserBirthday(sdf.parse(sdate));
//				  duty.setDutyDate(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}		
			u.setDepartmentID(Integer.parseInt(departmentID));
			u.setPoId(Integer.parseInt(poId));
			u.setUserName(userName);
			u.setUserDescribe(userDescribe);
			u.setUserPhoto(photo);
			System.out.println(userPhoto);
			System.out.println(photo);
			System.out.println("userDescribe:"+userDescribe);
			if(StringUtil.isStrNotEmpty(userId))
				u.setUserId(Integer.parseInt(userId));
			else
			{
				u.setUserId(0);
				System.out.println("Id 为空！");
			}
	
			int flag1=ub.updateByPrimaryKeySelective(u);
			 
			System.out.println(flag1);
			 
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
			String userIds=req.getParameter("userId");
			String userName=req.getParameter("userName");
			String userSex=req.getParameter("userSex");
			String departmentID=req.getParameter("departmentID");
			String poId=req.getParameter("poId");
			
			User user=new User();
			if(StringUtil.isStrNotEmpty(userIds))
			{
				user.setUserId(Integer.parseInt(userIds));				
			}
			else
			{
				System.out.println("userIds为空");
			}
			if(StringUtil.isStrNotEmpty(departmentID))
			{
				user.setDepartmentID(Integer.parseInt(departmentID));				
			}
			else
			{
				System.out.println("departmentID为空");
			}
			if(StringUtil.isStrNotEmpty(poId))
			{
				user.setPoId(Integer.parseInt(poId));				
			}
			else
			{
				System.out.println("poId为空");
			}
			user.setUserName(userName);
			user.setUserSex(userSex);
			
			int flag=ub.insertSelective(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("delete"))
		{
			System.out.println("delete");
			String userIds=req.getParameter("userId");
			
			User user=new User();
			if(StringUtil.isStrNotEmpty(userIds))
			{
				user.setUserId(Integer.parseInt(userIds));				
			}
			else
			{
				System.out.println("userIds为空");
			}
			user.setIsDelete(1);
			
			int flag=ub.updateByPrimaryKeySelective(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		
		else
		{
			System.out.println("no such method\n\n");
			System.out.println("进来的method是："+method);
		}
		
	}
	
	/**
	 * 匹配权限
	 * [1,2,3,8,9]
	 * 1,2,3,4,5,6,7,8,9,10
	 * @return
	 */
	public List<MenuPojo>  merge(List<Integer> menuList,List<Menu> allMenu){
		
		List<MenuPojo> list = new ArrayList<>();
		
		if(allMenu != null && allMenu.size() > 0){
			for (Menu Menu : allMenu) {
				Integer menuId = Menu.getMenuID();
				
				if(hasAuthority(menuId, menuList)){//判断是否有权限
					
					MenuPojo mp = new MenuPojo();
					
					mp.setHasAuthority(true);
					mp.setIsDelete(Menu.getIsDelete());
					mp.setMenuId(Menu.getMenuID());
					mp.setMenuImage(Menu.getMenuImage());
					mp.setMenuLevel(Menu.getMenuLevel());
					mp.setMenuName(Menu.getMenuName());
					mp.setMenuSort(Menu.getMenuSort());
					mp.setMenuUrl(Menu.getMenuUrl());
					mp.setParentId(Menu.getParentID());
					
					//递归算法
					mp.setChildMenu(merge(menuList,Menu.getChildMenu()));
					
					list.add(mp);//把对象一个一个的添加进去
				}
			}
		}
		return list;
	}
	
	/**
	 * 判断是否有权限
	 * menuId是否在menuList中
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

package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.web.biz.OperationRoomBiz;
import com.web.biz.impl.OperationRoomBizImpl;
import com.web.entity.OperationRoom;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/operationroom")
public class OperationRoomController extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		OperationRoomBiz ob = new OperationRoomBizImpl();
		
		if("query".equals(method)){
			  List<OperationRoom> list = ob.query();
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(list);
			  System.out.println("搜索"+json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		}else if("queryByCondition".equals(method)){
			  //接收前台传过来的参数
				String userName=req.getParameter("user.userName");
				System.out.println("获取的userName:"+userName);
				String operationRoomAddress=req.getParameter("operationRoomAddress");
				
				OperationRoom operationRoom = new OperationRoom();
				User user = new User();
				
				user.setUserName(userName);
				operationRoom.setUser(user);
				
				operationRoom.setOperationRoomAddress(operationRoomAddress);
				
				
				List<OperationRoom> list = ob.queryByCondition(operationRoom);
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(list);
			  System.out.println("搜索"+json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("sendUpdate".equals(method)){
			  //跳转到修改页面  （需要根据主键从数据库中查询原来的数据信息)
			  String operationRoomID = req.getParameter("operationRoomID");
			  
			  //调用业务逻辑层的查询方法
			  OperationRoom operationRoom  =  ob.findById(Integer.parseInt(operationRoomID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(operationRoom);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  String operationRoomID=req.getParameter("operationRoomID");
			  String userId = req.getParameter("userId");			  
			  String operationRoomAddress = req.getParameter("operationRoomAddress");	

			  OperationRoom operationRoom = new OperationRoom();

			  if(StringUtil.isStrNotEmpty(operationRoomID)){
				  operationRoom.setOperationRoomID(Integer.parseInt(operationRoomID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(userId)){
				  operationRoom.setUserId(Integer.parseInt(userId));
			  }
			  
			  operationRoom.setOperationRoomAddress(operationRoomAddress);
			  			 
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  ob.update(operationRoom);
			 
			 System.out.println("更新"+flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("delete".equals(method)) {
			  //删除			  
			  String operationRoomID = req.getParameter("operationRoomID");
			  
			  Integer oid = Integer.parseInt(operationRoomID);
			  
			  boolean flag =  ob.delete(oid);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("add".equals(method)) {
			  
			  String userId = req.getParameter("userId");
			  String operationRoomAddress = req.getParameter("operationRoomAddress");
			  String operationDescrip = req.getParameter("operationDescrip");
			  
			  OperationRoom operationRoom = new OperationRoom();

			  if(StringUtil.isStrNotEmpty(userId)){
				  operationRoom.setUserId(Integer.parseInt(userId)); 
			  }
			  
			  operationRoom.setOperationRoomAddress(operationRoomAddress);
			  operationRoom.setOperationDescrip(operationDescrip);
			  
			  operationRoom.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  ob.add(operationRoom);
			 
			 System.out.println("添加成功"+flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}
	
	
	
}

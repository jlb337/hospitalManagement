package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.web.biz.IllnessEreaBiz;
import com.web.biz.impl.IllnessEreaBizImpl;
import com.web.entity.IllnessErea;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * 病区的控制层
 * @author ASUS
 *
 */

@WebServlet(urlPatterns="/illnessErea")
public class IllnessEreaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		//实例化业务逻辑层IllnessEreaBizImpl
		  
		IllnessEreaBiz bb =new IllnessEreaBizImpl();

		  //url:http://localhost:8080/HospitalManager/illnessErea?method=query
		  if("query".equals(method)){
			  //查询
			  
			  IllnessErea illnessErea = new IllnessErea();
			  
//			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("illnessEreaID"))){
				  illnessErea.setIllnessEreaID(Integer.parseInt(req.getParameter("illnessEreaID")));
				}
			  
			  illnessErea.setIllnessEreaName(req.getParameter("illnessEreaName"));
			  
			  
//			  if(StringUtil.isStrNotEmpty(req.getParameter("IllnessEreaDate"))){
//				  duty.setDutyDate(StringUtil.StringToDate(req.getParameter("dutyDate")));
//			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("cureRate1"))){
				  illnessErea.setCureRate1(Float.parseFloat(req.getParameter("cureRate1")));
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("deathRate1"))){
				  illnessErea.setDeathRate1(Float.parseFloat(req.getParameter("deathRate1")));
			  }
			  
				
			  User user = new User();
			  user.setUserName(req.getParameter("userName"));
			  user.setTelephone(req.getParameter("telephone"));
			  
			  illnessErea.setUser(user);

			  //调用业务逻辑层中的查询方法
			  List<IllnessErea> list = bb.queryByCondition(illnessErea);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(list);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  } if("sendUpdate".equals(method)){
			  
			  Integer illnessEreaID = 0;
			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("illnessEreaID"))){
				  illnessEreaID = (Integer.parseInt(req.getParameter("illnessEreaID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  IllnessErea illnessErea = bb.queryById(illnessEreaID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(illnessErea);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			  
			  IllnessErea illnessErea = new IllnessErea();
			//接收前台传过来的参数 
			  String IllnessEreaIDs = req.getParameter("illnessEreaID");
			  Integer illnessEreaID = Integer.parseInt(IllnessEreaIDs);
			  illnessErea.setIllnessEreaID(illnessEreaID);
			  illnessErea.setUserId(Integer.parseInt(req.getParameter("userId")));
			  illnessErea.setIllnessEreaName(req.getParameter("illnessEreaName"));
			  illnessErea.setBedCount(Integer.parseInt(req.getParameter("bedCount")));
			  illnessErea.setInPeopleCount(Integer.parseInt(req.getParameter("inPeopleCount")));
			  illnessErea.setOutPeopleCount(Integer.parseInt(req.getParameter("outPeopleCount")));
			  illnessErea.setBetterRate(Float.parseFloat(req.getParameter("betterRate")));
			  illnessErea.setCureRate(Float.parseFloat(req.getParameter("cureRate")));
			  illnessErea.setDeathRate(Float.parseFloat(req.getParameter("deathRate")));
			  illnessErea.setBadRate(Float.parseFloat(req.getParameter("badRate")));
			  
			 
			  
			  //调用业务逻辑层中的更新方法
			  bb.update(illnessErea);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 		  		  
			 
			//接收前台传过来的参数 
			  String IllnessEreaIDs = req.getParameter("illnessEreaID");
			  Integer IllnessEreaID = Integer.parseInt(IllnessEreaIDs);
			
			  //调用业务逻辑层中的查询方法
			  bb.delete(IllnessEreaID);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  
			  IllnessErea illnessErea = new IllnessErea();
			//接收前台传过来的参数 
			  illnessErea.setUserId(Integer.parseInt(req.getParameter("userId")));
			  illnessErea.setIllnessEreaName(req.getParameter("illnessEreaName"));
			  illnessErea.setBedCount(Integer.parseInt(req.getParameter("bedCount")));
			  illnessErea.setInPeopleCount(Integer.parseInt(req.getParameter("inPeopleCount")));
			  illnessErea.setOutPeopleCount(Integer.parseInt(req.getParameter("outPeopleCount")));
			  illnessErea.setBetterRate(Float.parseFloat(req.getParameter("betterRate")));
			  illnessErea.setCureRate(Float.parseFloat(req.getParameter("cureRate")));
			  illnessErea.setDeathRate(Float.parseFloat(req.getParameter("deathRate")));
			  illnessErea.setBadRate(Float.parseFloat(req.getParameter("badRate")));
			  
			 
			  
			  //调用业务逻辑层中的更新方法
			  bb.add(illnessErea);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}
}

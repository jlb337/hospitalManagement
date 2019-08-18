package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.BedBiz;
import com.web.biz.DutyBiz;
import com.web.biz.impl.BedBizImpl;
import com.web.biz.impl.DutyBizImpl;
import com.web.entity.Bed;
import com.web.entity.Duty;
import com.web.entity.IllnessErea;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * 值班的控制层
 * @author ASUS
 *
 */

@WebServlet(urlPatterns="/duty")
public class DutyController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			doPost(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("method");
		
		//实例化业务逻辑层DutyBizImpl
		  DutyBiz bb =new DutyBizImpl();

		  //url:http://localhost:8080/HospitalManager/duty?method=query
		  if("query".equals(method)){
			  //查询
			  
			  Duty duty = new Duty();
			  
//			//接收前台传过来的参数
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("dutyID"))){
				  duty.setDutyID(Integer.parseInt(req.getParameter("dutyID")));
				}
		
			  User user = new User();
			  user.setUserName(req.getParameter("userName"));
			  user.setLevel(req.getParameter("level"));
			  user.setTelephone(req.getParameter("telephone"));
			  
			  duty.setUser(user);

			  //调用业务逻辑层中的查询方法
			  List<Duty> list = bb.queryByCondition(duty);
			  		  
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
			  
			  Integer dutyID = 0;
			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("dutyID"))){
				  dutyID = (Integer.parseInt(req.getParameter("dutyID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  Duty duty = bb.queryById(dutyID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(duty);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			  
			  Duty duty = new Duty();
			//接收前台传过来的参数
			//接收前台传过来的参数 
			  String dutyIDs = req.getParameter("dutyID");
			  Integer dutyID = Integer.parseInt(dutyIDs);
			  duty.setDutyID(dutyID);
			  String userIds = req.getParameter("userId");
			  Integer userId = Integer.parseInt(userIds);
			  duty.setUserId(userId);
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("dutyDate");
			  //Date date=null;
			  try {
				  duty.setDutyDate(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			 // System.out.println(date);
			 
			  
			  //调用业务逻辑层中的更新方法
			  bb.update(duty);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 		  		  
			 
			//接收前台传过来的参数 
			  String dutyIDs = req.getParameter("dutyID");
			  Integer dutyID = Integer.parseInt(dutyIDs);
			
			  //调用业务逻辑层中的查询方法
			  bb.delete(dutyID);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  
			  Duty duty = new Duty();
			//接收前台传过来的参数 
			  String userIds = req.getParameter("userId");
			  Integer userId = Integer.parseInt(userIds);
			  duty.setUserId(userId);
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("dutyDate");
			  //Date date=null;
			  try {
				  duty.setDutyDate(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			 // System.out.println(date);
			 
			  
			  //调用业务逻辑层中的更新方法
			  bb.add(duty);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}

	
}


 
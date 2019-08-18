package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.impl.ChargeProjectSituationBizImpl;
import com.web.biz.impl.DoctorAdviceBizImpl;
import com.web.biz.impl.PatientBizImpl;
import com.web.biz.ChargeProjectSituationBiz;
import com.web.biz.DoctorAdviceBiz;
import com.web.biz.PatientBiz;
import com.web.entity.ChargeProjectSituation;
import com.web.entity.DoctorAdvice;
import com.web.entity.Patient;
import com.web.entity.PatientHistory;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/doctoradvice")
public class DoctorAdviceController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String method = req.getParameter("method");
		  
		  DoctorAdviceBiz db = new DoctorAdviceBizImpl();
		  
		  if("selectByCondition".equals(method)){
			  //查询
			  //接收前台传过来的参数
			  
			  String patientName;
			  String userName;
			  Integer patientHistoryID;
			  String illnessName;
			  Integer flagOut;
			  
			  DoctorAdvice doctorAdvice = new DoctorAdvice();
			  
			  Patient patient = new Patient();
			  User user = new User();
			  PatientHistory patientHistory = new PatientHistory();
			  
			  System.out.println(req.getParameter("patienthistory.patientHistoryID")+"*******************************");
			  if(StringUtil.isStrNotEmpty(req.getParameter("patienthistory.patientHistoryID")))
			  {
				  patientHistoryID = Integer.parseInt(req.getParameter("patienthistory.patientHistoryID"));
				  patientHistory.setPatientHistoryID(patientHistoryID);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("flagOut")))
			  {
				  flagOut = Integer.parseInt(req.getParameter("flagOut"));
				  doctorAdvice.setFlagOut(flagOut);
			  }

			  if(StringUtil.isStrNotEmpty(req.getParameter("patient.patientName")))
			  {
				  patientName = req.getParameter("patient.patientName");
				  patient.setpatientName(patientName);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("user.userName")))
			  {
				  userName = req.getParameter("user.userName");
				  user.setUserName(userName);
			  }

			  if(StringUtil.isStrNotEmpty(req.getParameter("illnessName")))
			  {
				  illnessName = req.getParameter("illnessName");
				  doctorAdvice.setIllnessName(illnessName);
			  }
			  
				  
			  
			  doctorAdvice.setPatient(patient);
			  doctorAdvice.setUser(user);
			  doctorAdvice.setPatienthistory(patientHistory);
			  
			  //调用业务逻辑层中的查询方法
			  List<DoctorAdvice> list = db.selectByCondition(doctorAdvice);
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(list);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  	}
		  
		  	else if("sendUpdate".equals(method)){
			  //跳转到修改页面  （需要根据主键从数据库中查询原来的数据信息)
		  		
			  String willID = req.getParameter("willID");
			  
			  //调用业务逻辑层的查询方法
			  DoctorAdvice doctorAdvice = db.selectByID(Integer.parseInt(willID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(doctorAdvice);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  
			  String willID = req.getParameter("willID");
			  String userId = req.getParameter("userId");
			  String patientHistoryID = req.getParameter("patientHistoryID");
			  String patientID = req.getParameter("patientID");
			  String startDate = req.getParameter("startDate");
			  String endDate = req.getParameter("endDate");
			  String doctorAdvice = req.getParameter("doctorAdvice");
			  String illnessName = req.getParameter("illnessName");
			  String flagOut = req.getParameter("flagOut");
			  System.out.println("willID"+willID+"userId"+userId+"patientHistoryID"+patientHistoryID+"patientID"+patientID);
			  DoctorAdvice doctoradvice = new DoctorAdvice();
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  try {
				  doctoradvice.setEndDate(sdf.parse(endDate));
				  doctoradvice.setStartDate(sdf.parse(startDate));
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			  
			  doctoradvice.setWillID(Integer.parseInt(willID));
			  doctoradvice.setUserId(Integer.parseInt(userId));
			  doctoradvice.setPatientHistoryID(Integer.parseInt(patientHistoryID));
			  doctoradvice.setPatientID(Integer.parseInt(patientID));
			  doctoradvice.setDoctorAdvice(doctorAdvice);
			  doctoradvice.setIllnessName(illnessName);
			  doctoradvice.setFlagOut(Integer.parseInt(flagOut));
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.update(doctoradvice);
			 
			 System.out.println(flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  	else if("sendDelete".equals(method)){
			  //跳转到修改页面  （需要根据主键从数据库中查询原来的数据信息)
			  String willID = req.getParameter("willID");
			  
			  //调用业务逻辑层的查询方法
			  DoctorAdvice doctorAdvice =  db.selectByID(Integer.parseInt(willID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(doctorAdvice);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  
		  else if("Delete".equals(method)){
			  //修改
			  String willID = req.getParameter("willID");
	
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.delete(Integer.parseInt(willID));
			 
			 System.out.println(flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  else if("insert".equals(method)){
			  
			  //插入
			  DoctorAdvice doctorAdvice1 = new DoctorAdvice();
			  
			  Integer userId;
			  Integer patientHistoryID;
			  Integer patientID;
			  Date startDate;
			  Date endDate;
			  Integer flagOut;
			  String doctorAdvice;
			  String illnessName;

			  if(StringUtil.isStrNotEmpty(req.getParameter("userId")))
			  {
				  userId = Integer.parseInt(req.getParameter("userId"));
				  doctorAdvice1.setUserId(userId);
			  }

			  if(StringUtil.isStrNotEmpty(req.getParameter("patientHistoryID")))
			  {
				  patientHistoryID = Integer.parseInt(req.getParameter("patientHistoryID"));
				  doctorAdvice1.setPatientHistoryID(patientHistoryID);
			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("patientID")))
			  {
				  patientID = Integer.parseInt(req.getParameter("patientID"));
				  doctorAdvice1.setPatientID(patientID);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("flagOut")))
			  {
				  flagOut = Integer.parseInt(req.getParameter("flagOut"));
				  doctorAdvice1.setFlagOut(flagOut);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("startDate")))
			  {
				  startDate = StringUtil.stringToDate(req.getParameter("startDate"));
				  doctorAdvice1.setStartDate(startDate);
			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("endDate")))
			  {
				  endDate = StringUtil.stringToDate(req.getParameter("endDate"));
				  doctorAdvice1.setEndDate(endDate);
			  }
			  
			  doctorAdvice1.setDoctorAdvice(req.getParameter("doctorAdvice"));
			  doctorAdvice1.setIllnessName(req.getParameter("illnessName"));
			  
			  
			  //调用业务逻辑层中的查询方法
			  boolean flag = db.insert(doctorAdvice1);
			  
			  System.out.println(flag);
				 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}
}

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
import com.web.biz.impl.PatientBizImpl;
import com.web.biz.ChargeProjectSituationBiz;
import com.web.biz.PatientBiz;
import com.web.entity.ChargeProjectSituation;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/patient")
public class PatientController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String method = req.getParameter("method");
		  
		  PatientBiz db = new PatientBizImpl();
		  
		  if("query".equals(method)){
			  
				List<Patient> list = new ArrayList<>();

				list = db.query_Name();
				
				for (Patient p : list) {
					
					
					System.out.println("PatientName:"+p.getpatientName());
					
					System.out.println("---------------------------");
				}
				
				System.out.println("病人姓名");
				String json = JsonUtil.getJson(list);

				//获取输出对象
				PrintWriter out = resp.getWriter();
				resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
				out.write(json);	//输出
				out.flush();		//刷新
				out.close();
				System.out.println("病人姓名2");
				for (Patient p : list) {
					
					
					System.out.println("PatientName:"+p.getpatientName());
					
					System.out.println("---------------------------");
				}
				
				
		  }
		  
		  else if("selectByCondition".equals(method)){
			  //查询
			  //接收前台传过来的参数
			  //String name = req.getParameter("name");
			  
			  String patientName;
			  Integer age;
			  String ID;
			  String postCode;
			  
			  Patient patient = new Patient();
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("age")))
			  {
				  age = Integer.parseInt(req.getParameter("age"));
				  patient.setAge(age);
			  }
			  
			  patientName = req.getParameter("patientName");
			  patient.setpatientName(patientName);
			  
			  ID = req.getParameter("ID");
			  patient.setID(ID);
			  
			  postCode = req.getParameter("postCode");
			  patient.setPostCode(postCode);
			  
			  //调用业务逻辑层中的查询方法
			  List<Patient> list = db.selectByCondition(patient);
			  
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
			  String patientID = req.getParameter("patientID");
			  
			  //调用业务逻辑层的查询方法
			  Patient patient = db.selectByID(Integer.parseInt(patientID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(patient);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  
			  String patientID = req.getParameter("patientID");
			  String patientName = req.getParameter("patientName");
			  String sex = req.getParameter("sex");
			  String age = req.getParameter("age");
			  String occupation = req.getParameter("occupation");
			  String birthPlace = req.getParameter("birthPlace");
			  String nation = req.getParameter("nation");
			  String ID = req.getParameter("ID");
			  String nationality = req.getParameter("nationality");
			  String workPlace = req.getParameter("workPlace");
			  String tel = req.getParameter("tel");
			  String postCode = req.getParameter("postCode");
			  String permanentAddress = req.getParameter("permanentAddress");
			  String contactPersonName = req.getParameter("contactPersonName");
			  String contactPersonAddress = req.getParameter("contactPersonAddress");
			  String contactPersonRelationship = req.getParameter("contactPersonRelationship");
			  String contactPersonTel = req.getParameter("contactPersonTel");
			  String marrySituation = req.getParameter("marrySituation");
			  
			  
			  Patient patient = new Patient();
			  patient.setPatientID(Integer.parseInt(patientID));
			  patient.setpatientName(patientName);
			  patient.setSex(sex);
			  
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String birthday=req.getParameter("birthday");
			  System.out.println(birthday);
			  try {
				  patient.setBirthday(sdf.parse(birthday));
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			  
			  
			  patient.setAge(Integer.parseInt(age));
			  patient.setOccupation(occupation);
			  patient.setBirthPlace(birthPlace);
			  patient.setNation(nation);
			  patient.setID(ID);
			  patient.setNationality(nationality);
			  patient.setWorkPlace(workPlace);
			  patient.setTel(tel);
			  patient.setPostCode(postCode);
			  patient.setPermanentAddress(permanentAddress);
			  patient.setContactPersonName(contactPersonName);
			  patient.setContactPersonAddress(contactPersonAddress);
			  patient.setContactPersonRelationship(contactPersonRelationship);
			  patient.setContactPersonTel(contactPersonTel);
			  patient.setMarrySituation(marrySituation);
			  patient.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.update(patient);
			 
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
			  String patientID = req.getParameter("patientID");
			  
			  //调用业务逻辑层的查询方法
			  Patient patient =  db.selectByID(Integer.parseInt(patientID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(patient);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  
		  else if("Delete".equals(method)){
			  //修改
			  String patientID = req.getParameter("patientID");
	
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.delete(Integer.parseInt(patientID));
			 
			 System.out.println(flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  else if("insert".equals(method)){
			  //修改
			  Patient patient = new Patient();
			  Integer age;
			  Date birthday;
			  
//			  if(StringUtil.isStrNotEmpty(req.getParameter("patientID")))
//			  {
//				  patientID = Integer.parseInt(req.getParameter("patientID"));
//				  patient.setPatientID(patientID);
//			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("birthday")))
			  {
				  birthday = StringUtil.stringToDate(req.getParameter("birthday"));
				  patient.setBirthday(birthday);
			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("age")))
			  {
				  age = Integer.parseInt(req.getParameter("age"));
				  patient.setAge(age);
			  }
			  
			  String patientName = req.getParameter("patientName");
			  String sex = req.getParameter("sex");
			  String occupation = req.getParameter("occupation");
			  String birthPlace = req.getParameter("birthPlace");
			  String nation = req.getParameter("nation");
			  String ID = req.getParameter("ID");
			  String nationality = req.getParameter("nationality");
			  String workPlace = req.getParameter("workPlace");
			  String tel = req.getParameter("tel");
			  String postCode = req.getParameter("postCode");
			  String permanentAddress = req.getParameter("permanentAddress");
			  String contactPersonName = req.getParameter("contactPersonName");
			  String contactPersonAddress = req.getParameter("contactPersonAddress");
			  String contactPersonRelationship = req.getParameter("contactPersonRelationship");
			  String contactPersonTel = req.getParameter("contactPersonTel");
			  String marrySituation = req.getParameter("marrySituation"); 
			  
			  
			  patient.setpatientName(patientName);
			  patient.setSex(sex);
			  patient.setOccupation(occupation);
			  patient.setBirthPlace(birthPlace);
			  patient.setNation(nation);
			  patient.setID(ID);
			  patient.setNationality(nationality);
			  patient.setWorkPlace(workPlace);
			  patient.setTel(tel);
			  patient.setPostCode(postCode);
			  patient.setPermanentAddress(permanentAddress);
			  patient.setContactPersonName(contactPersonName);
			  patient.setContactPersonAddress(contactPersonAddress);
			  patient.setContactPersonRelationship(contactPersonRelationship);
			  patient.setContactPersonTel(contactPersonTel);
			  patient.setMarrySituation(marrySituation);
			  patient.setIsDelete(0);
			  
			  
			  //调用业务逻辑层中的查询方法
			  boolean flag = db.insert(patient);
			  
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

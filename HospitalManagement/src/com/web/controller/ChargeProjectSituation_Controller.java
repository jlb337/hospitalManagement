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

import com.web.biz.impl.ChargeProjectSituationBizImpl;
import com.web.biz.ChargeProjectSituationBiz;
import com.web.entity.ChargeProjectSituation;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/chargeprojectsituation")
public class ChargeProjectSituation_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String method = req.getParameter("method");
		  System.out.println("111");
		  
		  //实例化业务逻辑层
		  ChargeProjectSituationBiz db = new ChargeProjectSituationBizImpl();
		  
		  //url:http://localhost:8080/HospitalManager/department?method=selectByCondition
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  if("selectByCondition".equals(method)){
			  //查询
			  //接收前台传过来的参数
			  //String name = req.getParameter("name");
			  
			  Map<String, Object> map = new HashMap<>();
			  
			  Integer chargeType;
			  Integer flagCheckOut;
			  Integer flagTransfer;
			  String patientName;
			  Float chargeTypeMoney1;
			  Float chargeTypeMoney2;
			  
			  ChargeProjectSituation situation = new ChargeProjectSituation();
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("chargeType")))
			  {
				  chargeType = Integer.parseInt(req.getParameter("chargeType"));
				  map.put("chargeType", chargeType);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("flagCheckOut")))
			  {
				  flagCheckOut = Integer.parseInt(req.getParameter("flagCheckOut"));
				  map.put("flagCheckOut", flagCheckOut);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("flagTransfer")))
			  {
				  flagTransfer = Integer.parseInt(req.getParameter("flagTransfer"));
				  map.put("flagTransfer", flagTransfer);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("chargeTypeMoney1")))
			  {
				  chargeTypeMoney1 = Float.parseFloat(req.getParameter("chargeTypeMoney1"));
				  map.put("chargeTypeMoney1", chargeTypeMoney1);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("chargeTypeMoney2")))
			  {
				  chargeTypeMoney2 = Float.parseFloat(req.getParameter("chargeTypeMoney2"));
				  map.put("chargeTypeMoney2", chargeTypeMoney2);
			  }
			  
			  patientName = req.getParameter("patient.patientName");
			  Patient p = new Patient();
			  p.setpatientName(patientName);
			  
			  map.put("patient", p);
			  //situation.getPatient().setContactPersonName(name);
			  
			  
			  //调用业务逻辑层中的查询方法
			  List<ChargeProjectSituation> list = db.selectByCondition(map);
			  
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
			  String chargeID = req.getParameter("chargeID");
			  
			  //调用业务逻辑层的查询方法
			  ChargeProjectSituation situation =  db.selectByID(Integer.parseInt(chargeID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(situation);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  
			  String chargeID = req.getParameter("chargeID");
			  String patientID = req.getParameter("patientID");
			  String chargeType = req.getParameter("chargeType");
			  String chargeTypeMoney = req.getParameter("chargeTypeMoney");
			  String flagCheckOut = req.getParameter("flagCheckOut");
			  String flagTransfer = req.getParameter("flagTransfer");
			  
			  ChargeProjectSituation situation = new ChargeProjectSituation();
			  situation.setChargeID(Integer.parseInt(chargeID));
			  situation.setPatientID(Integer.parseInt(patientID));
			  situation.setChargeType(Integer.parseInt(chargeType));
			  situation.setChargeTypeMoney(Float.parseFloat(chargeTypeMoney));
			  situation.setFlagCheckOut(Integer.parseInt(flagCheckOut));
			  situation.setFlagTransfer(Integer.parseInt(flagTransfer));
			  situation.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.update(situation);
			 
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
			  String chargeID = req.getParameter("chargeID");
			  
			  //调用业务逻辑层的查询方法
			  ChargeProjectSituation situation =  db.selectByID(Integer.parseInt(chargeID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(situation);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  
		  else if("Delete".equals(method)){
			  //修改
			  String chargeID = req.getParameter("chargeID");
	
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.delete(Integer.parseInt(chargeID));
			 
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
			  Integer chargeType;
			  float chargeTypeMoney;
			  Integer flagCheckOut;
			  Integer flagTransfer;
			  Integer patientID;
			  
			  ChargeProjectSituation situation = new ChargeProjectSituation();
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("chargeType")))
			  {
				  chargeType = Integer.parseInt(req.getParameter("chargeType"));
				  situation.setChargeType(chargeType);
			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("chargeTypeMoney")))
			  {
				  chargeTypeMoney = Integer.parseInt(req.getParameter("chargeTypeMoney"));
				  situation.setChargeTypeMoney(chargeTypeMoney);;
			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("flagCheckOut")))
			  {
				  flagCheckOut = Integer.parseInt(req.getParameter("flagCheckOut"));
				  situation.setFlagCheckOut(flagCheckOut);
			  }
			  if(StringUtil.isStrNotEmpty(req.getParameter("flagTransfer")))
			  {
				  flagTransfer = Integer.parseInt(req.getParameter("flagTransfer"));
				  situation.setFlagTransfer(flagTransfer);
			  }
			  
			  System.out.println("传过来的东西："+req.getParameter("patientID"));
			  if(StringUtil.isStrNotEmpty(req.getParameter("patientID")))
			  {
				  patientID = Integer.parseInt(req.getParameter("patientID"));
				  situation.setPatientID(patientID);;
			  }			  
			  
			  //situation.getPatient().setContactPersonName(name);
			  
			  
			  //调用业务逻辑层中的查询方法
			  boolean flag = db.insert(situation);
			  
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

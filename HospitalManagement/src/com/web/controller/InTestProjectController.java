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


import com.web.biz.InTestProjectBiz;
import com.web.biz.impl.InTestProjectBizImpl;
import com.web.entity.InTestProject;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/inTestProject")
public class InTestProjectController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("method");
		
		//实例化业务逻辑层BedBizImpl
		  InTestProjectBiz bb =new InTestProjectBizImpl();

		  //url:http://localhost:8080/HospitalManager/inTestProject?method=query
		  if("query".equals(method)){
			  //查询
			  
			  InTestProject inTestProject = new InTestProject();
			  
//			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("testCost1"))){
				  inTestProject.setTestCost1(Float.parseFloat(req.getParameter("testCost1")));
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("testCost2"))){
				  inTestProject.setTestCost2(Float.parseFloat(req.getParameter("testCost2")));
			  }
			  	
			  String testName = req.getParameter("testName");
			  inTestProject.setTestName(testName);
			  
			  Patient patient= new Patient();
			  patient.setpatientName(req.getParameter("patientName"));
			  patient.setID(req.getParameter("ID"));
			  inTestProject.setPatient(patient);
			  
			  //调用业务逻辑层中的查询方法
			  List<InTestProject> list = bb.queryByCondition(inTestProject);
			  		  
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
			  
			  Integer inTestID = 0;
			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("inTestID"))){
				  inTestID = (Integer.parseInt(req.getParameter("inTestID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  InTestProject inTestProject = bb.queryById(inTestID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(inTestProject);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			  
			//接收前台传过来的参数
				InTestProject inTestProject = new InTestProject();
				inTestProject.setTestName(req.getParameter("testName"));
				System.out.println("inTestID:"+req.getParameter("inTestID"));
				//inTestProject.setTestDate(StringUtil.StringToDate(req.getParameter("TestDate")));
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				  String sdate=req.getParameter("testDate");
				  //System.out.println(sdate);
				  //Date date=null;
				  try {
					  inTestProject.setTestDate(sdf.parse(sdate));
				} catch (Exception e) {
					e.printStackTrace();
				}
				inTestProject.setInTestID(Integer.parseInt(req.getParameter("inTestID")));
				inTestProject.setTestLeader(req.getParameter("testLeader"));
				inTestProject.setTestContent(req.getParameter("testContent"));
				inTestProject.setTestResult(req.getParameter("testResult"));
				inTestProject.setPatientID(Integer.parseInt(req.getParameter("patientID")));
				inTestProject.setTestCost(Float.parseFloat(req.getParameter("testCost")));
			  //调用业务逻辑层中的查询方法
			  
			   bb.update(inTestProject);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 
			//接收前台传过来的参数 
			  Integer inTestID = Integer.parseInt(req.getParameter("inTestID"));
		
			  //调用业务逻辑层中的查询方法
			  bb.delete(inTestID);				  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  

			//接收前台传过来的参数
			InTestProject inTestProject = new InTestProject();
			inTestProject.setTestName(req.getParameter("testName"));
			//inTestProject.setTestDate(StringUtil.StringToDate(req.getParameter("TestDate")));
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("testDate");
			  System.out.println(sdate);
			  //Date date=null;
			  try {
				  inTestProject.setTestDate(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}

			inTestProject.setTestLeader(req.getParameter("testLeader"));
			inTestProject.setTestContent(req.getParameter("testContent"));
			inTestProject.setTestResult(req.getParameter("testResult"));
			inTestProject.setPatientID(Integer.parseInt(req.getParameter("patientID")));
			inTestProject.setTestCost(Float.parseFloat(req.getParameter("testCost")));
			
			//调用业务逻辑层中的查询方法
			bb.add(inTestProject);
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}
 
 
}

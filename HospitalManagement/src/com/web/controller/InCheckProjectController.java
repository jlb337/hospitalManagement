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

import com.web.biz.InCheckProjectBiz;
import com.web.biz.impl.InCheckProjectBizImpl;
import com.web.entity.InCheckProject;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/inCheckProject")
public class InCheckProjectController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("method");
		
		//实例化业务逻辑层BedBizImpl
		  InCheckProjectBiz bb =new InCheckProjectBizImpl();

		  //url:http://localhost:8080/HospitalManager/inCheckProject?method=query
		  if("query".equals(method)){
			  //查询
			  
			  InCheckProject inCheckProject = new InCheckProject();
			  
//			//接收前台传过来的参数
				
			  String checkName = req.getParameter("checkName");
			  inCheckProject.setCheckName(checkName);
			  
			  Patient patient= new Patient();
			  patient.setpatientName(req.getParameter("patientName"));
			  patient.setID(req.getParameter("ID"));
			  inCheckProject.setPatient(patient);
			  
			  //调用业务逻辑层中的查询方法
			  List<InCheckProject> list = bb.queryByCondition(inCheckProject);
			  		  
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
			  
			  Integer inCheckID = 0;
			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("inCheckID"))){
				  inCheckID = (Integer.parseInt(req.getParameter("inCheckID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  InCheckProject inCheckProject = bb.queryById(inCheckID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(inCheckProject);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			  
			//接收前台传过来的参数
				InCheckProject inCheckProject = new InCheckProject();
				inCheckProject.setCheckName(req.getParameter("checkName"));
				System.out.println("inCheckID:"+req.getParameter("inCheckID"));
				//inCheckProject.setCheckDate(StringUtil.StringToDate(req.getParameter("checkDate")));
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				  String sdate=req.getParameter("checkDate");
				  //System.out.println(sdate);
				  //Date date=null;
				  try {
					  inCheckProject.setCheckDate(sdf.parse(sdate));
				} catch (Exception e) {
					e.printStackTrace();
				}
				inCheckProject.setInCheckID(Integer.parseInt(req.getParameter("inCheckID")));
				inCheckProject.setCheckLeader(req.getParameter("checkLeader"));
				inCheckProject.setCheckContent(req.getParameter("checkContent"));
				inCheckProject.setCheckResult(req.getParameter("checkResult"));
				inCheckProject.setPatientID(Integer.parseInt(req.getParameter("patientID")));

			  //调用业务逻辑层中的查询方法
			  
			   bb.update(inCheckProject);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 
			//接收前台传过来的参数 
			  Integer inCheckID = Integer.parseInt(req.getParameter("inCheckID"));
		
			  //调用业务逻辑层中的查询方法
			  bb.delete(inCheckID);				  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  

			//接收前台传过来的参数
			InCheckProject inCheckProject = new InCheckProject();
			inCheckProject.setCheckName(req.getParameter("checkName"));
			//inCheckProject.setCheckDate(StringUtil.StringToDate(req.getParameter("checkDate")));
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("checkDate");
			  System.out.println(sdate);
			  //Date date=null;
			  try {
				  inCheckProject.setCheckDate(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}

			inCheckProject.setCheckLeader(req.getParameter("checkLeader"));
			inCheckProject.setCheckContent(req.getParameter("checkContent"));
			inCheckProject.setCheckResult(req.getParameter("checkResult"));
			inCheckProject.setPatientID(Integer.parseInt(req.getParameter("patientID")));
			
			//调用业务逻辑层中的查询方法
			bb.add(inCheckProject);
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}
 
 
}

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

import com.web.biz.OutRecordBiz;
import com.web.biz.impl.OutRecordBizImpl;
import com.web.entity.OutRecord;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * 出院信息的控制层
 * @author ASUS
 *
 */

@WebServlet(urlPatterns="/outRecord")
public class OutRecordController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			doPost(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("method");
		
		//实例化业务逻辑层OutRecordBizImpl 
		OutRecordBiz bb =new OutRecordBizImpl();

		  //url:http://localhost:8080/HospitalManager/outRecord?method=query
		  if("query".equals(method)){
			  //查询
			  
			  OutRecord outRecord = new OutRecord();
			  
//			//接收前台传过来的参数
			
			  Patient patient = new Patient();
			  if(StringUtil.isStrNotEmpty(req.getParameter("name"))){
			  patient.setpatientName(req.getParameter("name"));
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("ID"))){
			  patient.setID(req.getParameter("ID"));
			  }
			  outRecord.setPatient(patient);
			  
			  //调用业务逻辑层中的查询方法
			  List<OutRecord> list = bb.queryByCondition(outRecord);
			  		  
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
			  
			  Integer outID = 0;
			//接收前台传过来的参数
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("outID"))){
				  outID = (Integer.parseInt(req.getParameter("outID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  OutRecord outRecord = bb.queryById(outID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(outRecord);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			
			  //接收前台传过来的参数 
			  OutRecord outRecord = new OutRecord();
			  String OutIDs = req.getParameter("outID");
			  Integer OutID = Integer.parseInt(OutIDs);
			  outRecord.setOutID(OutID);
	    			
	    	  outRecord.setPatientID(Integer.parseInt(req.getParameter("patientID")));
	    	  outRecord.setOutSituation(req.getParameter("outSituation"));
	    	  outRecord.setOutCostClear(req.getParameter("outCostClear"));
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("outTime");
			  //Date date=null;
			  try {
				  outRecord.setOutTime(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  //调用业务逻辑层中的查询方法
			  bb.update(outRecord);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 
			//接收前台传过来的参数 
			  String outIDs = req.getParameter("outID");
			  Integer outID = Integer.parseInt(outIDs);
			  //调用业务逻辑层中的查询方法
			  bb.delete(outID);				  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  

			//接收前台传过来的参数 
			  OutRecord outRecord = new OutRecord();
	    			
	    	  outRecord.setPatientID(Integer.parseInt(req.getParameter("patientID")));
	    	  outRecord.setOutSituation(req.getParameter("outSituation"));
	    	  outRecord.setOutCostClear(req.getParameter("outCostClear"));
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("outTime");
			  //Date date=null;
			  try {
				  outRecord.setOutTime(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			 
			  //调用业务逻辑层中的查询方法
			  bb.add(outRecord);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}

	
}


 
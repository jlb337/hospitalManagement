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

import com.web.biz.CheckRecordBiz;
import com.web.biz.impl.CheckRecordBizImpl;
import com.web.entity.CheckProject;
import com.web.entity.CheckRecord;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/checkrecord")
public class CheckRecordController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		CheckRecordBiz cb = new CheckRecordBizImpl();
		
		if("query".equals(method)){
			  List<CheckRecord> list = cb.query();
			  
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
				Map<String, Object> map = new HashMap<>();
				
				CheckRecord checkRecord = new CheckRecord();
				
				String checkCharge1 = req.getParameter("checkCharge1");
				if(StringUtil.isStrNotEmpty(checkCharge1)){
					map.put("checkCharge1", Double.parseDouble(checkCharge1));
				}
				
				String checkCharge2 = req.getParameter("checkCharge2");
				if(StringUtil.isStrNotEmpty(checkCharge2)){
					map.put("checkCharge2", Double.parseDouble(checkCharge2));
				}

				String patientName = req.getParameter("patientName");
				
				
				Patient patient = new Patient();
				
				patient.setpatientName(patientName);
				
				if(StringUtil.isStrNotEmpty(patientName)){
					map.put("patientName",patientName);
				}
				
				CheckProject checkProject =new CheckProject();
				 
				String checkName=req.getParameter("checkName");

				checkProject.setCheckName(checkName);
				
				if(StringUtil.isStrNotEmpty(checkName)){
					map.put("checkName", checkName);
				}				
				
				checkRecord.setPatient(patient);
				checkRecord.setCheckProject(checkProject);
				
				List<CheckRecord> list = cb.queryByCondition(map);
			  
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
			  String checkRecordID = req.getParameter("checkRecordID");
			  
			  //调用业务逻辑层的查询方法
			  CheckRecord checkRecord  =  cb.findById(Integer.parseInt(checkRecordID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(checkRecord);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  String checkRecordID = req.getParameter("checkRecordID");			  
			  String checkID = req.getParameter("checkID");				  
			  String patientID = req.getParameter("patientID");
			  String checkDate = req.getParameter("checkDate");
			  String checkResult = req.getParameter("checkResult");
			  System.out.println("更新前后检查结果"+checkResult);

			  CheckRecord checkRecord = new CheckRecord();

			  if(StringUtil.isStrNotEmpty(checkRecordID)){
				  checkRecord.setCheckRecordID(Integer.parseInt(checkRecordID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(checkID)){
				  checkRecord.setCheckID(Integer.parseInt(checkID));
			  }
			  
			  checkRecord.setCheckResult(checkResult);
			  
			  if(StringUtil.isStrNotEmpty(patientID)){
				  checkRecord.setPatientID(Integer.parseInt(patientID));
			  }	
			  
			  if(StringUtil.isStrNotEmpty(checkDate)){
				  checkRecord.setCheckDate(StringUtil.stringToDate(checkDate));
			  }
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  cb.update(checkRecord);
			 
			 System.out.println("更新"+flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("delete".equals(method)) {
			  //删除			  
			  String checkRecordID = req.getParameter("checkRecordID");
			  
			  Integer cid = Integer.parseInt(checkRecordID);
			  
			  boolean flag =  cb.delete(cid);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("add".equals(method)) {
			  
			  String checkID = req.getParameter("checkID");
			  String patientID = req.getParameter("patientID");
			  String checkDate = req.getParameter("checkDate");
			  String checkResult = req.getParameter("checkResult");
			  
			  CheckRecord checkRecord = new CheckRecord();

			  if(StringUtil.isStrNotEmpty(checkID)){
				  checkRecord.setCheckID(Integer.parseInt(checkID)); 
			  }

			  if(StringUtil.isStrNotEmpty(patientID)){
				  checkRecord.setPatientID(Integer.parseInt(patientID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(checkDate)){
				  checkRecord.setCheckDate(StringUtil.stringToDate(checkDate));
			  }
	  
			  checkRecord.setCheckResult(checkResult);
			  
			  checkRecord.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  cb.add(checkRecord);
			 
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

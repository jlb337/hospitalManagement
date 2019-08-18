package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.OperationBiz;
import com.web.biz.impl.OperationBizImpl;
import com.web.entity.Operation;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/operation")
public class OperationController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		OperationBiz ob = new OperationBizImpl();
		
		if("query".equals(method)){
			  List<Operation> list = ob.query();
			  
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
			
			Operation operation = new Operation();
			
			String operationCost1 = req.getParameter("operationCost1");
			if(StringUtil.isStrNotEmpty(operationCost1)){
				map.put("operationCost1", Double.parseDouble(operationCost1));
			}
			
			String operationCost2 = req.getParameter("operationCost2");
			if(StringUtil.isStrNotEmpty(operationCost2)){
				map.put("operationCost2", Double.parseDouble(operationCost2));
			}

			String patientName = req.getParameter("patientName");
			
			Patient patient = new Patient();
			
			patient.setpatientName(patientName);
			
			operation.setPatient(patient);
			
			if(StringUtil.isStrNotEmpty(patientName)){
				map.put("patientName",patientName);
			}
						 
			String operationName=req.getParameter("operationName");
			if(StringUtil.isStrNotEmpty(operationName)){
				map.put("operationName", operationName);
			}				
			
			
			List<Operation> list = ob.queryByCondition(map);  
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
			  String operationID = req.getParameter("operationID");
			  
			  //调用业务逻辑层的查询方法
			  Operation operation  =  ob.findById(Integer.parseInt(operationID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(operation);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  String operationID=req.getParameter("operationID");
			  String patientID = req.getParameter("patientID");			  
			  String operationDate = req.getParameter("operationDate");	
			  String operationResult=req.getParameter("operationResult");
			  String operationCost=req.getParameter("operationCost");

			  Operation operation = new Operation();

			  if(StringUtil.isStrNotEmpty(operationID)){
				  operation.setOperationID(Integer.parseInt(operationID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(patientID)){
				  operation.setPatientID(Integer.parseInt(patientID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(operationDate)){
				  operation.setOperationDate(StringUtil.stringToDate(operationDate));
			  }
			  
			  operation.setOperationResult(operationResult);
			  
			  if(StringUtil.isStrNotEmpty(operationCost)){
				  operation.setOperationCost(Float.parseFloat(operationCost));
			  }

			  //调用业务逻辑层的修改方法
			 boolean flag =  ob.update(operation);
			 
			 System.out.println("更新"+flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("delete".equals(method)) {
			  //删除			  
			  String operationID = req.getParameter("operationID");
			  
			  Integer oid = Integer.parseInt(operationID);
			  
			  boolean flag =  ob.delete(oid);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("add".equals(method)) {
			  
			  String patientID = req.getParameter("patientID");
			  String operationName = req.getParameter("operationName");
			  String sleepMethod = req.getParameter("sleepMethod");
			  String hurtSituation = req.getParameter("hurtSituation");
			  String operationDate = req.getParameter("operationDate");
			  String operationPersistentTime = req.getParameter("operationPersistentTime");
			  String operationResult = req.getParameter("operationResult");
			  String operationCost = req.getParameter("operationCost");
			  
			  Operation operation = new Operation();

			  if(StringUtil.isStrNotEmpty(patientID)){
				  operation.setPatientID(Integer.parseInt(patientID)); 
			  }
			  
			  operation.setOperationName(operationName);
			  
			  if(StringUtil.isStrNotEmpty(sleepMethod)){
				  operation.setSleepMethod(Integer.parseInt(sleepMethod));
			  }
			  
			  operation.setHurtSituation(hurtSituation);
			  
			  if(StringUtil.isStrNotEmpty(operationDate)){
				  operation.setOperationDate(StringUtil.stringToDate(operationDate));
			  }
			  
			  if(StringUtil.isStrNotEmpty(operationPersistentTime)){
				  operation.setOperationPersistentTime(Float.parseFloat(operationPersistentTime));
			  }
			 
			  operation.setOperationResult(operationResult);
			  
			  if(StringUtil.isStrNotEmpty(operationCost)){
				  operation.setOperationCost(Float.parseFloat(operationCost));
			  }
			  
			  operation.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  ob.add(operation);
			 
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

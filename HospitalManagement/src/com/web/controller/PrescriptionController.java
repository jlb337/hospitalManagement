package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.PropertySuffix;

import com.web.biz.impl.PrescriptionBizImpl;
import com.web.biz.PrescriptionBiz;
import com.web.entity.Drug;
import com.web.entity.Patient;
import com.web.entity.Prescription;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/prescription")
public class PrescriptionController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String method = req.getParameter("method");
		  
		  //实例化业务逻辑层
		  PrescriptionBiz db = new PrescriptionBizImpl();
		  
		  if("query".equals(method)){
			  
			  

				List<Prescription> list = new ArrayList<>();

				list = db.query();
				
				String json = JsonUtil.getJson(list);

				//获取输出对象
				PrintWriter out = resp.getWriter();
				resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
				out.write(json);	//输出
				out.flush();		//刷新
				out.close();
				
				
		  }
		  
		  
		  else if("selectByCondition".equals(method)){
			  //查询
			  //接收前台传过来的参数
			  //String name = req.getParameter("name");
			  
			  Map<String, Object> map = new HashMap<>();
			  
			  String prescriptionContent;
			  String patientName; 
			  Float prescriptionCost1;
			  Float prescriptionCost2;
			  
//			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			  String prescriptionDate=req.getParameter("prescriptionDate");
//			  try {
//				  map.put("prescriptionDate", sdf.parse(prescriptionDate));
//			  } catch (Exception e) {
//				e.printStackTrace();
//			  }
			  
			  prescriptionContent = req.getParameter("prescriptionContent");
			  map.put("prescriptionContent", prescriptionContent);
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("prescriptionCost1")))
			  {
				  prescriptionCost1 = Float.parseFloat(req.getParameter("prescriptionCost1"));
				  map.put("prescriptionCost1", prescriptionCost1);
			  }
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("prescriptionCost2")))
			  {
				  prescriptionCost2 = Float.parseFloat(req.getParameter("prescriptionCost2"));
				  map.put("prescriptionCost2", prescriptionCost2);
			  }
			  
			  patientName = req.getParameter("patient.patientName");
			  Patient p = new Patient();
			  p.setpatientName(patientName);
			  
			  map.put("patient", p);
			  //situation.getPatient().setContactPersonName(name);
			  
			  //调用业务逻辑层中的查询方法
			  List<Prescription> list = db.selectByCondition(map);
			  
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
			  String prescriptionID2 = req.getParameter("prescriptionID2");
			  
			  //调用业务逻辑层的查询方法
			  Prescription prescription =  db.selectByID(Integer.parseInt(prescriptionID2));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(prescription);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  
			  String prescriptionID2 = req.getParameter("prescriptionID2");
			  String patientID = req.getParameter("patientID");
			  String prescriptionContent = req.getParameter("prescriptionContent");
			  String note = req.getParameter("note");
			  String prescriptionDate = req.getParameter("prescriptionDate");
			  String prescriptionCost = req.getParameter("prescriptionCost");
			  
			  Prescription prescription = new Prescription();

			  prescription.setIsDelete(0);
			  prescription.setPrescriptionID2(Integer.parseInt(prescriptionID2));
			  prescription.setPatientID(Integer.parseInt(patientID));
			  prescription.setPrescriptionContent(prescriptionContent);
			  prescription.setNote(note);
			  prescription.setPrescriptionCost(Float.parseFloat(prescriptionCost));
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  try {
				  prescription.setPrescriptionDate(sdf.parse(prescriptionDate));
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.update(prescription);
			 
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
			  String prescriptionID2 = req.getParameter("prescriptionID2");
			  
			  //调用业务逻辑层的查询方法
			  Prescription prescription = new Prescription();
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(prescription);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  
		  else if("Delete".equals(method)){
			  //修改
			  String prescriptionID2 = req.getParameter("prescriptionID2");
	
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.delete(Integer.parseInt(prescriptionID2));
			 
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
			  String patientID = req.getParameter("patientID");
			  String prescriptionContent = req.getParameter("prescriptionContent");
			  String note = req.getParameter("note");
			  String prescriptionDate = req.getParameter("prescriptionDate");
			  String prescriptionCost = req.getParameter("prescriptionCost");
			  
			  Prescription prescription = new Prescription();

			  prescription.setIsDelete(0);
			  prescription.setPatientID(Integer.parseInt(patientID));
			  prescription.setPrescriptionContent(prescriptionContent);
			  prescription.setNote(note);
			  prescription.setPrescriptionCost(Float.parseFloat(prescriptionCost));
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  try {
				  prescription.setPrescriptionDate(sdf.parse(prescriptionDate));
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			  
			  
			  //调用业务逻辑层中的查询方法
			  boolean flag = db.insert(prescription);
			  
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

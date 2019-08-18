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

import com.web.biz.BedBiz;
import com.web.biz.InRecordBiz;
import com.web.biz.impl.BedBizImpl;
import com.web.biz.impl.InRecordBizImpl;
import com.web.entity.Bed;
import com.web.entity.Department;
import com.web.entity.IllnessErea;
import com.web.entity.InRecord;
import com.web.entity.Patient;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * 入院信息的控制层
 * @author ASUS
 *
 */

@WebServlet(urlPatterns="/inRecord")
public class InRecordController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			doPost(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("method");
		
		//实例化业务逻辑层InRecordBizImpl 
		InRecordBiz bb =new InRecordBizImpl();

		  //url:http://localhost:8080/HospitalManager/inRecord?method=query
		  if("query".equals(method)){
			  //查询
			  
			  InRecord inRecord = new InRecord();
			  
//			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("inID"))){
				  inRecord.setInID(Integer.parseInt(req.getParameter("inID")));
				}
			
			  Patient patient = new Patient();
			  patient.setpatientName(req.getParameter("name"));
			  
			  patient.setID(req.getParameter("ID"));
			  
			  Department department = new Department();
			  department.setDepartmentName(req.getParameter("departmentName"));
			  
			  inRecord.setPatient(patient);
			  inRecord.setDepartment(department);
			  
			  //调用业务逻辑层中的查询方法
			  List<InRecord> list = bb.queryByCondition(inRecord);
			  		  
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
			  
			  Integer inID = 0;
			//接收前台传过来的参数
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("inID"))){
				  inID = (Integer.parseInt(req.getParameter("inID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  InRecord inRecord = bb.queryById(inID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(inRecord);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			
			  //接收前台传过来的参数 
			  InRecord inRecord = new InRecord();
			  String inIDs = req.getParameter("inID");
			  Integer inID = Integer.parseInt(inIDs);
			  inRecord.setInID(inID);
			  inRecord.setChangeDepartmentSituation(req.getParameter("changeDepartmentSituation"));
			  inRecord.setBedID(Integer.parseInt(req.getParameter("bedID")));
			  inRecord.setDepartmentID(Integer.parseInt(req.getParameter("departmentID")));
			  inRecord.setPatientID(Integer.parseInt(req.getParameter("patientID")));
			  inRecord.setInSituation(Integer.parseInt(req.getParameter("inSituation")));
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("inTime");
			  //Date date=null;
			  try {
				  inRecord.setInTime(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  //调用业务逻辑层中的查询方法
			  bb.update(inRecord);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 
			//接收前台传过来的参数 
			  String inIDs = req.getParameter("inID");
			  Integer inID = Integer.parseInt(inIDs);
			  //调用业务逻辑层中的查询方法
			  bb.delete(inID);				  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  

			//接收前台传过来的参数
			//接收前台传过来的参数 
			  InRecord inRecord = new InRecord();
			  inRecord.setChangeDepartmentSituation(req.getParameter("changeDepartmentSituation"));
			  inRecord.setBedID(Integer.parseInt(req.getParameter("bedID")));
			  inRecord.setDepartmentID(Integer.parseInt(req.getParameter("departmentID")));
			  inRecord.setPatientID(Integer.parseInt(req.getParameter("patientID")));
			  inRecord.setInSituation(Integer.parseInt(req.getParameter("inSituation")));
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String sdate=req.getParameter("inTime");
			  //Date date=null;
			  try {
				  inRecord.setInTime(sdf.parse(sdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			  //调用业务逻辑层中的查询方法
			  bb.add(inRecord);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}

	
}


 
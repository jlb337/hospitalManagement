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
import com.web.biz.impl.SupplierBizImpl;
import com.web.biz.ChargeProjectSituationBiz;
import com.web.biz.PatientBiz;
import com.web.biz.SupplierBiz;
import com.web.entity.ChargeProjectSituation;
import com.web.entity.Patient;
import com.web.entity.Supplier;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/supplier")
public class SupplierController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String method = req.getParameter("method");
		  
		  SupplierBiz db = new SupplierBizImpl();
		  
		  if("selectByCondition".equals(method)){
			  //查询
			  //接收前台传过来的参数
			  //String name = req.getParameter("name");
			  
			  String supplierTel;
			  String supplierReditStatus;
			  String supplierAddress;
			  
			  Supplier supplier = new Supplier();
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("supplierReditStatus")))
			  {
				  supplier.setSupplierReditStatus(Integer.parseInt(req.getParameter("supplierReditStatus")));
			  }
			  
			  supplier.setSupplierAddress(req.getParameter("supplierAddress"));
			  supplier.setSupplierTel(req.getParameter("supplierTel"));
			  
			  //调用业务逻辑层中的查询方法
			  List<Supplier> list = db.selectByCondition(supplier);
			  
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
			  String supplierID = req.getParameter("supplierID");
			  
			  //调用业务逻辑层的查询方法
			  Supplier supplier = db.selectByID(Integer.parseInt(supplierID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(supplier);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  
			  String supplierID = req.getParameter("supplierID");
			  String supplierTel = req.getParameter("supplierTel");
			  String supplierReditStatus = req.getParameter("supplierReditStatus");
			  String supplierAddress = req.getParameter("supplierAddress");
			  
			  System.out.println("******************"+supplierReditStatus);
			  
			  Supplier supplier = new Supplier();
			  
			  supplier.setSupplierID(Integer.parseInt(supplierID));
			  supplier.setSupplierTel(supplierTel);
			  supplier.setSupplierReditStatus(Integer.parseInt(supplierReditStatus));
			  supplier.setSupplierAddress(supplierAddress);

			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.update(supplier);
			 
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
			  String supplierID = req.getParameter("supplierID");
			  
			  //调用业务逻辑层的查询方法
			  Supplier supplier =  db.selectByID(Integer.parseInt(supplierID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(supplier);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  
		  else if("Delete".equals(method)){
			  //修改
			  String supplierID = req.getParameter("supplierID");
	
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.delete(Integer.parseInt(supplierID));
			 
			 System.out.println(flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
		  else if("insert".equals(method)){

			  String supplierTel = req.getParameter("supplierTel");
			  String supplierReditStatus = req.getParameter("supplierReditStatus");
			  String supplierAddress = req.getParameter("supplierAddress");
			  
			  Supplier supplier = new Supplier();
			  
			  supplier.setSupplierTel(supplierTel);
			  supplier.setSupplierReditStatus(Integer.parseInt(supplierReditStatus));
			  supplier.setSupplierAddress(supplierAddress);
			  
			  //调用业务逻辑层中的查询方法
			  boolean flag = db.insert(supplier);
			  
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

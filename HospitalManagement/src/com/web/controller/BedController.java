package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.BedBiz;
import com.web.biz.impl.BedBizImpl;
import com.web.entity.Bed;
import com.web.entity.IllnessErea;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * 床位的控制层
 * @author ASUS
 *
 */

@WebServlet(urlPatterns="/bed")
public class BedController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			doPost(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
String method = req.getParameter("method");
		
		//实例化业务逻辑层BedBizImpl
		  BedBiz bb =new BedBizImpl();

		  //url:http://localhost:8080/HospitalManager/bed?method=query
		  if("query".equals(method)){
			  //查询
			  System.out.println("bedCost1:"+req.getParameter("bedCost1"));
			  System.out.println("bedCost2:"+req.getParameter("bedCost2"));
			  Bed bed = new Bed();
			  
//			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("bedID"))){
				  bed.setBedID(Integer.parseInt(req.getParameter("bedID")));
				}
				
			  String cureResult = req.getParameter("cureResult");
			  bed.setCureResult(cureResult);
			  
			  IllnessErea illnessErea = new IllnessErea();
			  illnessErea.setIllnessEreaName(req.getParameter("illnessEreaName"));
			  bed.setIllnessErea(illnessErea);
			  
			   if(req.getParameter("bedCost1") != null ){
				  if(req.getParameter("bedCost1") != "" )
				  bed.setBedCost1(Float.parseFloat(req.getParameter("bedCost1")));
			  }
			  if(req.getParameter("bedCost2") != null){
				  if(req.getParameter("bedCost2") != "" )
				  bed.setBedCost2(Float.parseFloat(req.getParameter("bedCost2")));
			  }
			  
			  
			  //调用业务逻辑层中的查询方法
			  List<Bed> list = bb.queryByCondition(bed);
			  		  
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
			  
			  Integer bedID = 0;
			//接收前台传过来的参数
			  if(StringUtil.isStrNotEmpty(req.getParameter("bedID"))){
				  bedID = (Integer.parseInt(req.getParameter("bedID")));
				}
			
			  
			  //调用业务逻辑层中的查询方法
			  Bed bed = bb.queryById(bedID);
			  		  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(bed);
			  System.out.println(json);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("update".equals(method)){
			  
			 String bedIDs=req.getParameter("bedID");
			 System.out.println(bedIDs);
			//接收前台传过来的参数
			  Integer bedID = Integer.parseInt(bedIDs);
			  String cureResult = req.getParameter("cureResult");
			  Integer isEmpty = Integer.parseInt(req.getParameter("isEmpty"));
			  Float bedCost = Float.parseFloat(req.getParameter("bedCost"));
			  Integer illnessEreaID = Integer.parseInt(req.getParameter("illnessEreaID"));
			  
			  Bed bed = new Bed();
			  bed.setBedID(bedID);
			  bed.setCureResult(cureResult);
			  bed.setIsEmpty(isEmpty);
			  bed.setBedCost(bedCost);
			  bed.setIllnessEreaID(illnessEreaID);
			  //调用业务逻辑层中的查询方法
			  
			  System.out.println(bed);
			   bb.update(bed);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("delete".equals(method)){
			 
			//接收前台传过来的参数 
			  String bedIDs = req.getParameter("bedID");
			  Integer bedID = Integer.parseInt(bedIDs);
			  System.out.println(bedIDs);
			  //调用业务逻辑层中的查询方法
			  bb.delete(bedID);				  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }if("add".equals(method)){
			  

			//接收前台传过来的参数
			  String cureResult = req.getParameter("cureResult");
			  Integer isEmpty = Integer.parseInt(req.getParameter("isEmpty"));
			  Float bedCost = Float.parseFloat(req.getParameter("bedCost"));
			  Integer illnessEreaID = Integer.parseInt(req.getParameter("illnessEreaID"));
			  
			  Bed bed = new Bed();
			  bed.setCureResult(cureResult);
			  bed.setIsEmpty(isEmpty);
			  bed.setBedCost(bedCost);
			  bed.setIllnessEreaID(illnessEreaID);
			  //调用业务逻辑层中的查询方法
			  
			  System.out.println(bed);
			   bb.add(bed);
			  		  
			 
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write("1");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }
	}

	
}


 
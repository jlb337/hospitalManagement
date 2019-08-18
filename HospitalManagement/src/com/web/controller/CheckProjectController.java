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

import com.web.biz.CheckProjectBiz;
import com.web.biz.impl.CheckProjectBizImpl;
import com.web.entity.CheckProject;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;


@WebServlet(urlPatterns="/checkproject")
public class CheckProjectController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		CheckProjectBiz cb = new CheckProjectBizImpl();
		
		if("query".equals(method)){

		  List<CheckProject> list = cb.query();
		  
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
				
				String checkCharge1 = req.getParameter("checkCharge1");
				if(StringUtil.isStrNotEmpty(checkCharge1)){
					map.put("checkCharge1", Double.parseDouble(checkCharge1));
				}
				
				String checkCharge2 = req.getParameter("checkCharge2");
				if(StringUtil.isStrNotEmpty(checkCharge2)){
					map.put("checkCharge2", Double.parseDouble(checkCharge2));
				}

				String checkName = req.getParameter("checkName");
				
				if(StringUtil.isStrNotEmpty(checkName)){
					map.put("checkName",checkName);
				}
				
				List<CheckProject> list = cb.queryByCondition(map);
			  
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
			  String checkID = req.getParameter("checkID");
			  
			  //调用业务逻辑层的查询方法
			  CheckProject checkProject  =  cb.findById(Integer.parseInt(checkID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(checkProject);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改		  
			  String checkID = req.getParameter("checkID");				  
			  String checkName = req.getParameter("checkName");
			  String checkCharge = req.getParameter("checkCharge");

			  CheckProject checkProject = new CheckProject();

			  if(StringUtil.isStrNotEmpty(checkID)){
				  checkProject.setCheckID(Integer.parseInt(checkID));
			  }
			  
			  checkProject.setCheckName(checkName);
			  
			  if(StringUtil.isStrNotEmpty(checkCharge)){
				  checkProject.setCheckCharge(Float.parseFloat(checkCharge));
			  }	
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  cb.update(checkProject);
			 
			 System.out.println("更新"+flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("delete".equals(method)) {
			  //删除			  
			  String checkID = req.getParameter("checkID");
			  
			  Integer cid = Integer.parseInt(checkID);
			  
			  boolean flag =  cb.delete(cid);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("add".equals(method)) {

			  String checkName = req.getParameter("checkName");
			  String checkRecord = req.getParameter("checkRecord");
			  String checkAnalysis = req.getParameter("checkAnalysis");
			  String checkCharge = req.getParameter("checkCharge");
			  
			  CheckProject checkProject = new CheckProject();
			  
			  checkProject.setCheckName(checkName);
			  checkProject.setCheckRecord(checkRecord);
			  checkProject.setCheckAnalysis(checkAnalysis);

			  if(StringUtil.isStrNotEmpty(checkCharge)){
				  checkProject.setCheckCharge(Float.parseFloat(checkCharge)); 
			  }

			  checkProject.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  cb.add(checkProject);
			 
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

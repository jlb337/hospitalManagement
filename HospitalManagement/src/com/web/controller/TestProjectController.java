package com.web.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.TestProjectBiz;
import com.web.biz.impl.TestProjectBizImpl;
import com.web.entity.TestProject;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * 门诊检查项目的控制层
 * @author guokaixin
 *
 */
@WebServlet(urlPatterns="/testproject")
public class TestProjectController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		TestProjectBiz tb = new TestProjectBizImpl();
	
	  //url:http://localhost:8080/HospitalManager/testproject?method=query
	  
		if("query".equals(method)){
			List<TestProject> list = tb.query();
			  
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
			
			TestProject testProject = new TestProject();
			User user = new User();
			
			String testResult = req.getParameter("testResult");
			System.out.println("搜索结果为："+testResult);
			if(StringUtil.isStrNotEmpty(testResult)){
				map.put("testResult", testResult);
			}
			
			String testCharge1 = req.getParameter("testCharge1");
			if(StringUtil.isStrNotEmpty(testCharge1)){
				map.put("testCharge1", Double.parseDouble(testCharge1));
			}
			
			String testCharge2 = req.getParameter("testCharge2");
			if(StringUtil.isStrNotEmpty(testCharge2)){
				map.put("testCharge2", Double.parseDouble(testCharge2));
			}
			
			String userName = req.getParameter("userName");
			user.setUserName(userName);
			testProject.setUser(user);
			
			if(StringUtil.isStrNotEmpty(userName)){
				map.put("userName", userName);
			}
			
//			String patientHistoryIDs = req.getParameter("patientHistoryID");
//			if(StringUtil.isStrNotEmpty(patientHistoryIDs)){
//				Integer patientHistoryID = Integer.parseInt(patientHistoryIDs);
//				if(patientHistoryID  != 0){
//					map.put("patientHistoryID", patientHistoryID);
//				}
//			}
			
			List<TestProject> list = tb.queryByCondition(map);
		  
		  //把数据转换为json字符串
		  String json = JsonUtil.getJson(list);
		  System.out.println("哈哈哈哈"+json);
		  
		  //获取输出对象
		  PrintWriter out = resp.getWriter();
		  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
		  out.write(json);//输出
		  out.flush();//刷新
		  out.close();//关闭
	  }else if("sendUpdate".equals(method)){
		  //跳转到修改页面  （需要根据主键从数据库中查询原来的数据信息)
		  String testID = req.getParameter("testID");
		  
		  //调用业务逻辑层的查询方法
		  TestProject testProject =  tb.findById(Integer.parseInt(testID));
		  
		  //把数据转换为json字符串
		  String json = JsonUtil.getJson(testProject);
		  
		  //获取输出对象
		  PrintWriter out = resp.getWriter();
		  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
		  out.write(json);//输出
		  out.flush();//刷新
		  out.close();//关闭
	  }else if("update".equals(method)){
		  //修改
		  String testID = req.getParameter("testID");	
		  String userId = req.getParameter("userId");
		  String testDate=req.getParameter("testDate");
		  String testResult = req.getParameter("testResult");
		  String testCharge = req.getParameter("testCharge");

		  TestProject testProject = new TestProject();  

		  if(StringUtil.isStrNotEmpty(testID)){
			  testProject.setTestID(Integer.parseInt(testID));
		  }
		  
		  if(StringUtil.isStrNotEmpty(userId)){
			  testProject.setUserId(Integer.parseInt(userId));
		  }
		  
		  if(StringUtil.isStrNotEmpty(testDate)){
			  testProject.setTestDate(StringUtil.stringToDate(testDate));
		  }
		  
		  testProject.setTestResult(testResult);
		  
		  if(StringUtil.isStrNotEmpty(testCharge)){
			  testProject.setTestCharge(Float.parseFloat(testCharge));
		  }
		  
		  
		  
		  //调用业务逻辑层的修改方法
		 boolean flag =  tb.update(testProject);
		 
		 System.out.println("更新"+flag);
		 
		 //获取输出对象
		  PrintWriter out = resp.getWriter();
		  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
		  out.write(flag ? "1" : "0");//输出
		  out.flush();//刷新
		  out.close();//关闭
	  }else if ("delete".equals(method)) {
		  //删除
		  
		  String testID = req.getParameter("testID");
		  
		  Integer tid = Integer.parseInt(testID);
		  
		  boolean flag =  tb.delete(tid);
		 
		 //获取输出对象
		  PrintWriter out = resp.getWriter();
		  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
		  out.write(flag ? "1" : "0");//输出
		  out.flush();//刷新
		  out.close();//关闭
	  }else if ("add".equals(method)) {
		  
		  String userId = req.getParameter("userId");
		  String patientHistoryID = req.getParameter("patientHistoryID");
		  String testDate = req.getParameter("testDate");
		  String testAnalysis = req.getParameter("testAnalysis");
		  String testRecord = req.getParameter("testRecord");
		  String testResult = req.getParameter("testResult");
		  String testCharge = req.getParameter("testCharge");
		  System.out.println("获取新的信息的日期为："+testDate);
		
		  TestProject testProject = new TestProject();

		  if(StringUtil.isStrNotEmpty(userId)){
			  testProject.setUserId(Integer.parseInt(userId));
		  }

		  if(StringUtil.isStrNotEmpty(patientHistoryID)){
			  testProject.setPatientHistoryID(Integer.parseInt(patientHistoryID));
		  }
		  
		  if(StringUtil.isStrNotEmpty(testDate)){
			  testProject.setTestDate(StringUtil.stringToDate(testDate));
		  }
		  
		  testProject.setTestAnalysis(testAnalysis);
		  testProject.setTestRecord(testRecord);
		  testProject.setTestResult(testResult);

		  if(StringUtil.isStrNotEmpty(testCharge)){
			  testProject.setTestCharge(Float.parseFloat(testCharge)); 
		  }
		  
		  testProject.setIsDelete(0);
		  
		  //调用业务逻辑层的修改方法
		 boolean flag =  tb.add(testProject);
		 
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

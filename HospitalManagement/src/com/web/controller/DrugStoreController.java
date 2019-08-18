package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.DrugStoreBiz;
import com.web.biz.impl.DrugStoreBizImpl;
import com.web.entity.DrugStore;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * Servlet implementation class DrugStoreController
 */
@WebServlet(urlPatterns="/drugStore")
public class DrugStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugStoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		DrugStoreBiz dz=new DrugStoreBizImpl();
		 if("query".equals(method)){
			 
			 String userName=request.getParameter("user.userName");
			 String drugStoreType =request.getParameter("drugStoreType");
			 String drugStoreArea=request.getParameter("drugStoreArea");
			
			 DrugStore drugStore=new DrugStore();
			 User user=new User();
			 user.setUserName(userName);
			 drugStore.setUser(user);
			 drugStore.setDrugStoreType(drugStoreType);
			 if(drugStoreArea!=null &&drugStoreArea!="")
				 drugStore.setDrugStoreArea(Float.parseFloat(drugStoreArea));
			 List<DrugStore> list=dz.queryByCondition(drugStore);
			
			String json=JsonUtil.getJson(list);
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
			 
		 }else if("sendUpdate".equals(method)){
			 String drugStoreID=request.getParameter("drugStoreID");
			 DrugStore drugStore =dz.findById(Integer.parseInt(drugStoreID));
			 
			 String json =JsonUtil.getJson(drugStore);
				
				PrintWriter out=response.getWriter();
				response.setContentType("UTF-8");
				out.write(json);
				out.flush();
				out.close();
			 
			 
			 
		 }else if("update".equals(method)){
			 String drugStoreID=request.getParameter("drugStoreID");
			 String userId=request.getParameter("userId");
			 String drugStoreType =request.getParameter("drugStoreType");
			 String drugStoreArea=request.getParameter("drugStoreArea");
			
			 DrugStore drugStore=new DrugStore();
			 drugStore.setDrugStoreID(Integer.parseInt(drugStoreID));
			 if(StringUtil.isStrNotEmpty(userId))
				 drugStore.setUserId(Integer.parseInt(userId));
			 drugStore.setDrugStoreType(drugStoreType);
			 if(drugStoreArea!=null &&drugStoreArea!="")
				 drugStore.setDrugStoreArea(Float.parseFloat(drugStoreArea));
			 
			 boolean flag=dz.update(drugStore);
			 PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
			  
		 }else if("add".equals(method)){
			 
			
			 String userId=request.getParameter("userId");
			 String drugStoreType =request.getParameter("drugStoreType");
			 String drugStoreArea=request.getParameter("drugStoreArea");
			
			 DrugStore drugStore=new DrugStore();
			 if(StringUtil.isStrNotEmpty(userId))
				 drugStore.setUserId(Integer.parseInt(userId));
			 drugStore.setDrugStoreType(drugStoreType);
			 if(drugStoreArea!=null &&drugStoreArea!="")
				 drugStore.setDrugStoreArea(Float.parseFloat(drugStoreArea));
			 
			 boolean flag=dz.insert(drugStore);
			 PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
			  
		 }else if("delete".equals(method)){
			 String drugStoreID=request.getParameter("drugStoreID");

			 DrugStore drugStore=new DrugStore();
			 drugStore.setDrugStoreID(Integer.parseInt(drugStoreID));
			
			 
			 boolean flag=dz.delete(drugStore);
			 PrintWriter out = response.getWriter();
		  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
		  out.write(flag ? "1" : "0");//输出
		  out.flush();//刷新
		  out.close();//关闭
		 }
	}

}

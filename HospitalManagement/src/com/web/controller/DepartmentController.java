package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.DepartmentBiz;
import com.web.biz.impl.DepartmentBizImpl;
import com.web.entity.Department;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet(urlPatterns="/department")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
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
		
		DepartmentBiz db=new DepartmentBizImpl();
		if("query".equals(method))
		{
			  String departmentName = request.getParameter("departmentName");
			  String departmentAddress = request.getParameter("departmentAddress");
			  String departmentPhone = request.getParameter("departmentPhone");
			  
			 
			  Department department = new Department();
			  department.setDepartmentAddress(departmentAddress);
			  department.setDepartmentName(departmentName);
			  department.setDepartmentPhone(departmentPhone);
			  List<Department> list=db.queryByCondition(department);
			  
			
			//list转字符串
			String json=JsonUtil.getJson(list);
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
		}else if("sendUpdate".equals(method)){
			String departmentID=request.getParameter("departmentID");
			Department department=db.findById(Integer.parseInt(departmentID));
			String json =JsonUtil.getJson(department);
			
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
		}else if("update".equals(method)){
			
			 //修改
			  String departmentID = request.getParameter("departmentID");
			  String departmentName = request.getParameter("departmentName");
			  String departmentAddress = request.getParameter("departmentAddress");
			  String departmentPhone = request.getParameter("departmentPhone");
			  String userId = request.getParameter("userId");
			  System.out.println(userId);
			  
			  Department department = new Department();
			  department.setDepartmentAddress(departmentAddress);
			  if(StringUtil.isStrNotEmpty(departmentID))
				  department.setDepartmentID(Integer.parseInt(departmentID));
			  department.setDepartmentName(departmentName);
			  department.setDepartmentPhone(departmentPhone);
			  department.setIsDelete(0);
			  
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  db.update(department);
			 
			 System.out.println(flag);
			 
			 //获取输出对象
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		}else if("delete".equals(method)){
				String departmentID=request.getParameter("departmentID");
				
				Department department=new Department();
				department.setDepartmentID(Integer.parseInt(departmentID));
				boolean flag =db.delete(department);
				PrintWriter out = response.getWriter();
				response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
				out.write(flag ? "1" : "0");//输出
				out.flush();//刷新
				out.close();//关闭
				
		}else if("add".equals(method)){
			  String departmentName = request.getParameter("departmentName");
			  String departmentAddress = request.getParameter("departmentAddress");
			  String departmentPhone = request.getParameter("departmentPhone");
			  //String userId = request.getParameter("userId");
			  //System.out.println(userId);
			  Department department = new Department();
			  department.setDepartmentAddress(departmentAddress);
			  department.setDepartmentName(departmentName);
			  department.setDepartmentPhone(departmentPhone);
			  department.setIsDelete(0);
		  	  boolean flag =  db.insert(department);
			 
			  System.out.println(flag);
			 
			  //获取输出对象
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		}else if("listDepartment".equals(method)){
			List<Department> list=db.listDepartment();
			
			String json =JsonUtil.getJson(list);
			
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
		}
		
	}

}

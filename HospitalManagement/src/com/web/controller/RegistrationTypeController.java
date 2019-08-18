package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.RegistrationTypeBiz;
import com.web.biz.impl.RegistrationTypeBizImpl;
import com.web.entity.RegistrationType;
import com.web.util.JsonUtil;

/**
 * Servlet implementation class RegistrationTypeController
 */
@WebServlet(urlPatterns="/registrationType")
public class RegistrationTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationTypeController() {
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
        RegistrationTypeBiz rz=new RegistrationTypeBizImpl();
        if("query".equals(method)){
        	String registrationTypeName  =request.getParameter("registrationTypeName");
             	
        	RegistrationType registrationType=new RegistrationType();
        	registrationType.setRegistrationTypeName(registrationTypeName);
        	List<RegistrationType> list=rz.queryByCondition(registrationType);
        	
        	String json=JsonUtil.getJson(list);
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
        }else if("sendUpdate".equals(method)){
        	String registrationTypeID=request.getParameter("registrationTypeID");
        	RegistrationType registrationType =rz.findById(Integer.parseInt(registrationTypeID));
        	String json =JsonUtil.getJson(registrationType);
			
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
        }else if("update".equals(method)){
        	String registrationTypeID=request.getParameter("registrationTypeID");
        	String registrationTypeName  =request.getParameter("registrationTypeName");
        	RegistrationType registrationType=new RegistrationType();
        	registrationType.setRegistrationTypeID(Integer.parseInt(registrationTypeID));
        	registrationType.setRegistrationTypeName(registrationTypeName);
        	boolean flag=rz.update(registrationType);
        	
    	  PrintWriter out = response.getWriter();
		  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
		  out.write(flag ? "1" : "0");//输出
		  out.flush();//刷新
		  out.close();//关闭
        }else if("delete".equals(method)){
        	String registrationTypeID=request.getParameter("registrationTypeID");
        	RegistrationType registrationType=new RegistrationType();
        	registrationType.setRegistrationTypeID(Integer.parseInt(registrationTypeID));
        	boolean flag=rz.delete(registrationType);
        	PrintWriter out = response.getWriter();
			response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
        }else if("add".equals(method)){
        	String registrationTypeName  =request.getParameter("registrationTypeName");
        	RegistrationType registrationType=new RegistrationType();
        	registrationType.setRegistrationTypeName(registrationTypeName);
        	 boolean flag =rz.insert(registrationType);
        	 //获取输出对象
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
        }else if("listRegistrationType".equals(method)){
        	List<RegistrationType> list=rz.listRegistrationType();
        	String json =JsonUtil.getJson(list);
			
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
        }
	}

}

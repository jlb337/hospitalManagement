package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.RegistrationBiz;
import com.web.biz.impl.RegistrationBizImpl;
import com.web.entity.Patient;
import com.web.entity.Registration;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(urlPatterns="/registration")

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		RegistrationBiz rz=new RegistrationBizImpl();
		if("add".equals(method)){
			String patientHistoryID=request.getParameter("patientHistoryID");
			String registrationTypeID=request.getParameter("registrationType");
			String departmentID=request.getParameter("departmentID");
			String userId=request.getParameter("userId");
			String registrationFee=request.getParameter("registrationFee");
			String registrationDate=request.getParameter("registrationDate");
			String patientID=request.getParameter("patientID");
			
			Registration registration =new Registration();
			registration.setPatientHistoryID(Integer.parseInt(patientHistoryID));
			if(StringUtil.isStrNotEmpty(registrationTypeID))
			registration.setRegistrationTypeID(Integer.parseInt(registrationTypeID));
			registration.setDepartmentID(Integer.parseInt(departmentID));
			if(StringUtil.isStrNotEmpty(userId))
			registration.setUserId(Integer.parseInt(userId));
			if(StringUtil.isStrNotEmpty(registrationFee))
			registration.setRegistrationFee(Float.parseFloat(registrationFee));
			
			
			registration.setRegistrationDate(StringUtil.stringToDate(registrationDate));
			registration.setPatientID(Integer.parseInt(patientID));
			
		
			
			
			
			
			registration.setIsDelete(0);
			
			boolean flag=rz.insert(registration);
			
			 //获取输出对象
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		}else if("query".equals(method)){
			String patientHistoryID=request.getParameter("patientHistoryID");
			
			String patientID=request.getParameter("patientID");
			String patientName=request.getParameter("patient.patientName");
			System.out.println("PATIENTnAME:"+patientName);
			
			String registrationTypeID=request.getParameter("registrationTypeID");
			
			String departmentID=request.getParameter("departmentID");
			String doctorID=request.getParameter("userId");
			String userName=request.getParameter("user.userName");
			String registrationFee=request.getParameter("registrationFee");
			String registrationDate=request.getParameter("registrationDate");
			
			
			Registration registration =new Registration();
			if(StringUtil.isStrNotEmpty(patientHistoryID))
				registration.setPatientHistoryID(Integer.parseInt(patientHistoryID));
			
			if(StringUtil.isStrNotEmpty(patientID))
				registration.setPatientID(Integer.parseInt(patientID));
			Patient patient=new Patient();
			patient.setpatientName(patientName);
			registration.setPatient(patient);
			
			if(StringUtil.isStrNotEmpty(registrationTypeID))
			registration.setRegistrationTypeID(Integer.parseInt(registrationTypeID));
			
			if(StringUtil.isStrNotEmpty(departmentID))
			registration.setDepartmentID(Integer.parseInt(departmentID));
			
			if(StringUtil.isStrNotEmpty(doctorID))
			registration.setUserId(Integer.parseInt(doctorID));
			User user=new User();
			user.setUserName(userName);
			registration.setUser(user);
			
			if(StringUtil.isStrNotEmpty(registrationFee))
				registration.setRegistrationFee(Float.parseFloat(registrationFee));
			

			registration.setRegistrationDate(StringUtil.stringToDate(registrationDate));
			

			List<Registration> list=rz.queryByCondition(registration);
			
			for (Registration a : list) {
				System.out.println("*********"+a.getPatient().getpatientName());
			}
			
			//list转字符串
			String json=JsonUtil.getJson(list);
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
		}else if ("sendUpdate".equals(method)) {
			String registrationID=request.getParameter("registrationID");
			Registration registration =rz.findById(Integer.parseInt(registrationID));
			String json =JsonUtil.getJson(registration);
			
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();

		}else if ("update".equals(method)) {
			String registrationID=request.getParameter("registrationID");
			String patientHistoryID=request.getParameter("patientHistoryID");
			String registrationTypeID=request.getParameter("registrationType");
			String departmentID=request.getParameter("departmentID");
			String userId=request.getParameter("userId");
			String registrationFee=request.getParameter("registrationFee");
			String registrationDate=request.getParameter("registrationDate");
			
			
			Registration registration =new Registration();
			if(StringUtil.isStrNotEmpty(registrationID))
			registration.setRegistrationID(Integer.parseInt(registrationID));
			registration.setPatientHistoryID(Integer.parseInt(patientHistoryID));
			if(StringUtil.isStrNotEmpty(registrationTypeID))
			registration.setRegistrationTypeID(Integer.parseInt(registrationTypeID));
			registration.setDepartmentID(Integer.parseInt(departmentID));
			if(StringUtil.isStrNotEmpty(userId))
			registration.setUserId(Integer.parseInt(userId));
			if(StringUtil.isStrNotEmpty(registrationFee))
			registration.setRegistrationFee(Float.parseFloat(registrationFee));
			
			
			registration.setRegistrationDate(StringUtil.stringToDate(registrationDate));
			
			
			boolean flag=rz.update(registration);
			
			//获取输出对象
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
			
			
		}else if ("delete".equals(method)) {
			String registrationID=request.getParameter("registrationID");
			
			Registration registration =new Registration();
			registration.setRegistrationID(Integer.parseInt(registrationID));
			boolean flag=rz.delete(registration);
			
			PrintWriter out = response.getWriter();
			response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
		
		
	}

}

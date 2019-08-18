package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.PatientHistoryBiz;
import com.web.biz.impl.PatientHistoryBizImpl;
import com.web.entity.PatientHistory;
import com.web.entity.User;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * Servlet implementation class PatientHistoryController
 */
@WebServlet(urlPatterns="/patientHistory")
public class PatientHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientHistoryController() {
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
		PatientHistoryBiz pz=new PatientHistoryBizImpl();
		 if("query".equals(method)){
			 // String userId = request.getParameter("userId");
			  
			  String userName=request.getParameter("user.userName");
			  
			  //System.out.println();
			  
			  String diagnosisDate=request.getParameter("diagnosisDate");
			  String patientHistoryRecord=request.getParameter("patientHistoryRecord");
			  String historytype=request.getParameter("historytype");
			  	
			  
			  PatientHistory patientHistory=new PatientHistory();
			  User user=new User();
			  user.setUserName(userName);
			  patientHistory.setUser(user);
			  patientHistory.setDiagnosisDate(StringUtil.stringToDate(diagnosisDate));
			 patientHistory.setPatientHistoryRecord(patientHistoryRecord);
			 if(StringUtil.isStrNotEmpty(historytype))
				 patientHistory.setHistorytype(Integer.parseInt(historytype));
			 
			List<PatientHistory> list=pz.queryByCondition(patientHistory);
			String json=JsonUtil.getJson(list);
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
			  
		 }else if("sendUpdate".equals(method)){
			 String patientHistoryID =request.getParameter("patientHistoryID");
			 PatientHistory patientHistory=pz.findById(Integer.parseInt(patientHistoryID));
			 
			 String json =JsonUtil.getJson(patientHistory);
				
			PrintWriter out=response.getWriter();
			response.setContentType("UTF-8");
			out.write(json);
			out.flush();
			out.close();
			 
		 }else if("update".equals(method)){
			 String patientHistoryID =request.getParameter("patientHistoryID");
			 String userId=request.getParameter("userId");
			 String diagnosisDate=request.getParameter("diagnosisDate");
			 String patientHistoryRecord=request.getParameter("patientHistoryRecord");
			 String historytype=request.getParameter("historytype");
			 
			 PatientHistory patientHistory=new PatientHistory();
			 patientHistory.setPatientHistoryID(Integer.parseInt(patientHistoryID));
			 if(userId!=null)
				 patientHistory.setUserId(Integer.parseInt(userId));
			 
			 if(diagnosisDate!=null&&diagnosisDate!="")
			  {
				// patientHistory.setUser(user);
				  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				 try {
					patientHistory.setDiagnosisDate(sdf.parse(diagnosisDate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			 patientHistory.setPatientHistoryRecord(patientHistoryRecord);
			 if(StringUtil.isStrNotEmpty(historytype))
				 patientHistory.setHistorytype(Integer.parseInt(historytype));
			 
			 boolean flag=pz.update(patientHistory);
			 
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
			 
		 }else if("add".equals(method)){
			 String userId=request.getParameter("userId");
			 String diagnosisDate=request.getParameter("diagnosisDate");
			 String patientHistoryRecord=request.getParameter("patientHistoryRecord");
			 String historytype=request.getParameter("historytype");
			 
			 PatientHistory patientHistory=new PatientHistory();
			 if(userId!=null)
				 patientHistory.setUserId(Integer.parseInt(userId));
			 
			 if(diagnosisDate!=null&&diagnosisDate!="")
			  {
				// patientHistory.setUser(user);
				  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				 try {
					patientHistory.setDiagnosisDate(sdf.parse(diagnosisDate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			 patientHistory.setPatientHistoryRecord(patientHistoryRecord);
			 if(historytype!=null)
				 patientHistory.setHistorytype(Integer.parseInt(historytype));
			 
			 boolean flag=pz.insert(patientHistory);
			 
			 PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
			  
		 }else if("delete".equals(method)){
			 String patientHistoryID =request.getParameter("patientHistoryID");
			 String userId=request.getParameter("userId");
			 String diagnosisDate=request.getParameter("diagnosisDate");
			 String patientHistoryRecord=request.getParameter("patientHistoryRecord");
			 String historytype=request.getParameter("historytype");
			 
			 PatientHistory patientHistory=new PatientHistory();
			 patientHistory.setPatientHistoryID(Integer.parseInt(patientHistoryID));
			 if(userId!=null)
				 patientHistory.setUserId(Integer.parseInt(userId));
			 
			 if(diagnosisDate!=null&&diagnosisDate!="")
			  {
				// patientHistory.setUser(user);
				  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				 try {
					patientHistory.setDiagnosisDate(sdf.parse(diagnosisDate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			 patientHistory.setPatientHistoryRecord(patientHistoryRecord);
			 if(historytype!=null)
				 patientHistory.setHistorytype(Integer.parseInt(historytype));
			 
			 boolean flag=pz.delete(patientHistory);
			 
			  PrintWriter out = response.getWriter();
			  response.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
			 
		 }
	}

}

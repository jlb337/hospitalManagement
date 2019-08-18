/**
 * 
 */
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

import com.web.biz.DrugOrderBiz;
import com.web.biz.impl.DrugOrderBizImpl;
import com.web.entity.DrugOrder;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * @author Justin林
 *
 */
@WebServlet(urlPatterns="/drugOrder")
public class DrugOrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("drugOrder");
		String method = req.getParameter("method");
				
		DrugOrderBiz sdb = new DrugOrderBizImpl();
		if(method.equals("queryByCondition"))
		{
			System.out.println("queryByCondition");
			
			String drugOrderID=req.getParameter("drugOrderID");
			String userId=req.getParameter("userId");
			String standard=req.getParameter("standard");
			String orderDate=req.getParameter("orderDate");
			String commitDate=req.getParameter("commitDate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			DrugOrder sd=new DrugOrder();
			
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			if(StringUtil.isStrNotEmpty(userId))
			{
				sd.setUserId(Integer.parseInt(userId));				
			}
			else
			{
				System.out.println("userId为空");
			}
			
			try {
				if(StringUtil.isStrNotEmpty(orderDate))
				{
					
					sd.setOrderDate(sdf.parse(orderDate));
				}
				else
				{
					System.out.println("orderDate为空");
				}
				if(StringUtil.isStrNotEmpty(commitDate))
				{
					
					sd.setCommitDate(sdf.parse(commitDate));
				}
				else
				{
					System.out.println("commitDate为空");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
			sd.setStandard(standard);
		
			List<DrugOrder> list=sdb.queryByCondition(sd);
			

			//把数据传到页面上
			req.setAttribute("list", list);
			
			//把数据转换为json字符串
			String json = JsonUtil.getJson(list);
			  
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(json);//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
		else if(method.equals("sendUpdate"))
		{
			System.out.println("sendUpdate");
			String drugOrderID=req.getParameter("drugOrderID");
			
			DrugOrder sd=new DrugOrder();
			//			DrugOrderKey sdk=new DrugOrderKey();
			
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			
			System.out.println(drugOrderID);

			//Criteria c=new Criteria()
//			sdb.selectByExample(example);
//			DrugOrder sd=sdb.selectByPrimaryKey(sdk);
			
			List<DrugOrder> list=sdb.queryByCondition(sd);
//			System.out.println(sd);
			//把数据转换为json字符串
			String json = JsonUtil.getJson(list.get(0));
			System.out.println(json);
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(json);//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("update"))
		{
			System.out.println("update");
			//修改
			String drugOrderID=req.getParameter("drugOrderID");
			String userId=req.getParameter("userId");
			String standard=req.getParameter("standard");
			String orderDate=req.getParameter("orderDate");
			String commitDate=req.getParameter("commitDate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			DrugOrder sd=new DrugOrder();
			
			
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			if(StringUtil.isStrNotEmpty(userId))
			{
				sd.setUserId(Integer.parseInt(userId));		
			}
			else
			{
				System.out.println("userId为空");
			}
			
			
			try {
				if(StringUtil.isStrNotEmpty(orderDate))
				{
					
					sd.setOrderDate(sdf.parse(orderDate));
				}
				else
				{
					System.out.println("orderDate为空");
				}
				if(StringUtil.isStrNotEmpty(commitDate))
				{
					
					sd.setCommitDate(sdf.parse(commitDate));
				}
				else
				{
					System.out.println("commitDate为空");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
			sd.setStandard(standard);
			System.out.println(sd);
			
//			int flag1=sdb.updateByExample(sd, example);
			int flag1=sdb.updateByPrimaryKeySelective(sd);

			System.out.println(flag1);
			 
			//获取输出对象
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag1==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else if(method.equals("add"))
		{
			System.out.println("add");
			String userId=req.getParameter("userId");
			String standard=req.getParameter("standard");
			String orderDate=req.getParameter("orderDate");
			String commitDate=req.getParameter("commitDate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			DrugOrder sd=new DrugOrder();
			
			if(StringUtil.isStrNotEmpty(userId))
			{
				sd.setUserId(Integer.parseInt(userId));				
			}
			else
			{
				System.out.println("userId为空");
			}
			
			try {
				if(StringUtil.isStrNotEmpty(orderDate))
				{
					
					sd.setOrderDate(sdf.parse(orderDate));
				}
				else
				{
					System.out.println("orderDate为空");
				}
				if(StringUtil.isStrNotEmpty(commitDate))
				{
					
					sd.setCommitDate(sdf.parse(commitDate));
				}
				else
				{
					System.out.println("commitDate为空");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
			sd.setStandard(standard);
			sd.setStandard(standard);
			System.out.println(sd);
			
			
			int flag=sdb.insertSelective(sd);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
		else if(method.equals("delete"))
		{
			System.out.println("delete");
			
			String drugOrderID=req.getParameter("drugOrderID");
			
			
			DrugOrder sd=new DrugOrder();
			
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			//sd.set
			sd.setIsDelete(1);
			
			int flag=sdb.updateByPrimaryKeySelective(sd);
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag==1 ? "1" : "0");//输出
			out.flush();//刷新
			out.close();//关闭
		}
		else
		{
			System.out.println("no such method\n\n");
		}
		
	}
	
	
	

}

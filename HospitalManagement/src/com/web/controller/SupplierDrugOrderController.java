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

import com.web.biz.SupplierDrugOrderBiz;
import com.web.biz.impl.SupplierDrugOrderBizImpl;
import com.web.entity.SupplierDrugOrder;
import com.web.entity.SupplierDrugOrderExample;
import com.web.entity.SupplierDrugOrderExample.Criteria;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

/**
 * @author Justin林
 *
 */
@WebServlet(urlPatterns="/supplierDrugOrder")
public class SupplierDrugOrderController extends HttpServlet {

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
		System.out.println("SupplierDrugOrder");
		String method = req.getParameter("method");
				
		SupplierDrugOrderBiz sdb = new SupplierDrugOrderBizImpl();
		if(method.equals("queryByCondition"))
		{
			System.out.println("queryByCondition");
			
			String supplierID=req.getParameter("supplierID");
			String drugOrderID=req.getParameter("drugOrderID");
			String supplierOrderMakeDate=req.getParameter("supplierOrderMakeDate");
			String supplierOrderFinishDate=req.getParameter("supplierOrderFinishDate");
			String supplierOrderAddress=req.getParameter("supplierOrderAddress");
			String supplierOrderCount=req.getParameter("supplierOrderCount");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			SupplierDrugOrder sd=new SupplierDrugOrder();
			
			if(StringUtil.isStrNotEmpty(supplierID))
			{
				sd.setSupplierID(Integer.parseInt(supplierID));				
			}
			else
			{
				System.out.println("supplierID为空");
			}
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			if(StringUtil.isStrNotEmpty(supplierOrderCount))
			{
				sd.setSupplierOrderCount(Integer.parseInt(supplierOrderCount));				
			}
			else
			{
				System.out.println("supplierOrderCount为空");
			}
			
			try {
				if(StringUtil.isStrNotEmpty(supplierOrderMakeDate)&&StringUtil.isStrNotEmpty(supplierOrderFinishDate))
				{
					
					sd.setSupplierOrderMakeDate(sdf.parse(supplierOrderMakeDate));
					sd.setSupplierOrderFinishDate(sdf.parse(supplierOrderFinishDate));
				}
				else
				{
					System.out.println("supplierOrderMakeDate或supplierOrderFinishDate为空");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
			sd.setSupplierOrderAddress(supplierOrderAddress);
		
			List<SupplierDrugOrder> list=sdb.queryByCondition(sd);
			

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
			String supplierID=req.getParameter("supplierID");
			String drugOrderID=req.getParameter("drugOrderID");
			
			SupplierDrugOrder sd=new SupplierDrugOrder();
			//			SupplierDrugOrderKey sdk=new SupplierDrugOrderKey();
			if(StringUtil.isStrNotEmpty(supplierID))
			{
				sd.setSupplierID(Integer.parseInt(supplierID));				
			}
			else
			{
				System.out.println("supplierID为空");
			}
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			
			System.out.println(supplierID+"\t"+drugOrderID);

			//Criteria c=new Criteria()
//			sdb.selectByExample(example);
//			SupplierDrugOrder sd=sdb.selectByPrimaryKey(sdk);
			
			List<SupplierDrugOrder> list=sdb.queryByCondition(sd);
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
			String supplierID=req.getParameter("supplierID");
			String drugOrderID=req.getParameter("drugOrderID");
			String supplierOrderMakeDate=req.getParameter("supplierOrderMakeDate");
			String supplierOrderFinishDate=req.getParameter("supplierOrderFinishDate");
			String supplierOrderAddress=req.getParameter("supplierOrderAddress");
			String supplierOrderCount=req.getParameter("supplierOrderCount");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			SupplierDrugOrder sd=new SupplierDrugOrder();
			SupplierDrugOrderExample example=new SupplierDrugOrderExample();
			Criteria c=example.createCriteria();

			if(StringUtil.isStrNotEmpty(supplierID))
			{
				sd.setSupplierID(Integer.parseInt(supplierID));		
				c.andSupplierIDEqualTo(Integer.parseInt(supplierID));
			}
			else
			{
				System.out.println("supplierID为空");
			}
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));	
				c.andDrugOrderIDEqualTo(Integer.parseInt(supplierID));
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			if(StringUtil.isStrNotEmpty(supplierOrderCount))
			{
				sd.setSupplierOrderCount(Integer.parseInt(supplierOrderCount));				
			}
			else
			{
				System.out.println("supplierOrderCount为空");
			}
			
			try {
				sd.setSupplierOrderMakeDate(sdf.parse(supplierOrderMakeDate));
				sd.setSupplierOrderFinishDate(sdf.parse(supplierOrderFinishDate));
			} catch (Exception e) {
				e.printStackTrace();
			}	
			sd.setSupplierOrderAddress(supplierOrderAddress);
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
			String supplierID=req.getParameter("supplierID");
			String drugOrderID=req.getParameter("drugOrderID");
			String supplierOrderMakeDate=req.getParameter("supplierOrderMakeDate");
			String supplierOrderFinishDate=req.getParameter("supplierOrderFinishDate");
			String supplierOrderAddress=req.getParameter("supplierOrderAddress");
			String supplierOrderCount=req.getParameter("supplierOrderCount");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			SupplierDrugOrder sd=new SupplierDrugOrder();
			
			if(StringUtil.isStrNotEmpty(supplierID))
			{
				sd.setSupplierID(Integer.parseInt(supplierID));				
			}
			else
			{
				System.out.println("supplierID为空");
			}
			if(StringUtil.isStrNotEmpty(drugOrderID))
			{
				sd.setDrugOrderID(Integer.parseInt(drugOrderID));				
			}
			else
			{
				System.out.println("drugOrderID为空");
			}
			List<SupplierDrugOrder> isPrimary=sdb.queryByCondition(sd);
			if(StringUtil.isStrNotEmpty(supplierOrderCount))
			{
				sd.setSupplierOrderCount(Integer.parseInt(supplierOrderCount));				
			}
			else
			{
				System.out.println("supplierOrderCount为空");
			}
			
			try {
				sd.setSupplierOrderMakeDate(sdf.parse(supplierOrderMakeDate));
				sd.setSupplierOrderFinishDate(sdf.parse(supplierOrderFinishDate));
			} catch (Exception e) {
				e.printStackTrace();
			}	
			sd.setSupplierOrderAddress(supplierOrderAddress);
			Integer flag=0;
			if(isPrimary.size()>=1)
			{
				System.out.println("重复主键，不能添加");
				flag=2;
			}
			else
			{
				flag=sdb.insertSelective(sd);
				
			}
			PrintWriter out = resp.getWriter();
			resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			out.write(flag.toString());//输出
			out.flush();//刷新
			out.close();//关闭
			
		}
		else if(method.equals("delete"))
		{
			System.out.println("delete");
			
			String supplierID=req.getParameter("supplierID");
			String drugOrderID=req.getParameter("drugOrderID");
			
			
			SupplierDrugOrder sd=new SupplierDrugOrder();
			if(StringUtil.isStrNotEmpty(supplierID))
			{
				sd.setSupplierID(Integer.parseInt(supplierID));				
			}
			else
			{
				System.out.println("supplierID为空");
			}
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

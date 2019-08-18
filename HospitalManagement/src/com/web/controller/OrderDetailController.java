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

import com.web.biz.OrderDetailBiz;
import com.web.biz.impl.OrderDetailBizImpl;
import com.web.entity.DrugOrder;
import com.web.entity.OrderDetail;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/orderdetail")
public class OrderDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		
		OrderDetailBiz ob = new OrderDetailBizImpl();
		
		if("query".equals(method)){
			  List<OrderDetail> list = ob.query();
			  
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
			
			OrderDetail orderDetail = new OrderDetail();
			DrugOrder drugOrder = new DrugOrder();
			
			String sumCost1 = req.getParameter("sumCost1");
			if(StringUtil.isStrNotEmpty(sumCost1)){
				map.put("sumCost1", Double.parseDouble(sumCost1));
			}
			
			String sumCost2 = req.getParameter("sumCost2");
			if(StringUtil.isStrNotEmpty(sumCost2)){
				map.put("sumCost2", Double.parseDouble(sumCost2));
			}

			String batchNumber = req.getParameter("batchNumber");
			if(StringUtil.isStrNotEmpty(batchNumber)){
				map.put("batchNumber", batchNumber);
			}

			String drugOrderID = req.getParameter("drugOrderID");
			if(StringUtil.isStrNotEmpty(drugOrderID)){
				drugOrder.setDrugOrderID(Integer.parseInt(drugOrderID));
			}
			
			orderDetail.setDrugOrder(drugOrder);
			
			if(StringUtil.isStrNotEmpty(drugOrderID)){
				map.put("drugOrderID",drugOrderID);
			}
			
			
			List<OrderDetail> list = ob.queryByCondition(map);  
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
			  String detailID = req.getParameter("detailID");
			  
			  //调用业务逻辑层的查询方法
			  OrderDetail orderDetail  =  ob.findById(Integer.parseInt(detailID));
			  
			  //把数据转换为json字符串
			  String json = JsonUtil.getJson(orderDetail);
			  
			  //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(json);//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if("update".equals(method)){
			  //修改
			  String detailID=req.getParameter("detailID");
			  String drugOrderID = req.getParameter("drugOrderID");			  
			  String number = req.getParameter("number");	
			  String sumCost=req.getParameter("sumCost");
			  String batchNumber=req.getParameter("batchNumber");

			  OrderDetail orderDetail = new OrderDetail();

			  if(StringUtil.isStrNotEmpty(detailID)){
				  orderDetail.setDetailID(Integer.parseInt(detailID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(drugOrderID)){
				  orderDetail.setDrugOrderID(Integer.parseInt(drugOrderID));
			  }
			  
			  if(StringUtil.isStrNotEmpty(number)){
				  orderDetail.setNumber(Integer.parseInt(number));
			  }
			  
			  if(StringUtil.isStrNotEmpty(sumCost)){
				  orderDetail.setSumCost(Float.parseFloat(sumCost));
			  }
			  
			  orderDetail.setBatchNumber(batchNumber);

			  //调用业务逻辑层的修改方法
			 boolean flag =  ob.update(orderDetail);
			 
			 System.out.println("更新"+flag);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("delete".equals(method)) {
			  //删除			  
			  String detailID = req.getParameter("detailID");
			  
			  Integer oid = Integer.parseInt(detailID);
			  
			  boolean flag =  ob.delete(oid);
			 
			 //获取输出对象
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//把json数据的编码格式设置为UTF-8
			  out.write(flag ? "1" : "0");//输出
			  out.flush();//刷新
			  out.close();//关闭
		  }else if ("add".equals(method)) {
			  
			  String drugOrderID = req.getParameter("drugOrderID");
			  String number = req.getParameter("number");
			  String sumCost = req.getParameter("sumCost");
			  String batchNumber = req.getParameter("batchNumber");
			  
			  OrderDetail orderDetail = new OrderDetail();

			  if(StringUtil.isStrNotEmpty(drugOrderID)){
				  orderDetail.setDrugOrderID(Integer.parseInt(drugOrderID)); 
			  }
			  
			  if(StringUtil.isStrNotEmpty(number)){
				  orderDetail.setNumber(Integer.parseInt(number));
			  }
			  
			  if(StringUtil.isStrNotEmpty(sumCost)){
				  orderDetail.setSumCost(Float.parseFloat(sumCost));
			  }
			  
			  orderDetail.setBatchNumber(batchNumber);
			  
			  orderDetail.setIsDelete(0);
			  
			  //调用业务逻辑层的修改方法
			 boolean flag =  ob.add(orderDetail);
			 
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

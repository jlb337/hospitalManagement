package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.biz.impl.DrugBizImpl;
import com.web.biz.DrugBiz;
import com.web.entity.Drug;
import com.web.entity.DrugStore;
import com.web.entity.Prescription;
import com.web.util.JsonUtil;
import com.web.util.StringUtil;

@WebServlet(urlPatterns="/drug")
public class DrugController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		  String method = req.getParameter("method");
		  //瀹炰緥鍖栦笟鍔￠�昏緫灞�
		  DrugBiz db = new DrugBizImpl();
		  
		  if("query".equals(method)){
			  System.out.println("%%%%%%%%%%%%%%%");
			  
				List<Drug> list = new ArrayList<>();

				list = db.query();
				
				for (Drug drug : list) {
					System.out.println("%%%%%%%%%%%%%%%"+drug.getDrugName());
				}
				
				String json = JsonUtil.getJson(list);

				//鑾峰彇杈撳嚭瀵硅薄
				PrintWriter out = resp.getWriter();
				resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
				out.write(json);	//杈撳嚭
				out.flush();		//鍒锋柊
				out.close();
				
		  }
		  
		  else if("selectByCondition".equals(method)){
			  //鏌ヨ
			  //鎺ユ敹鍓嶅彴浼犺繃鏉ョ殑鍙傛暟
			  //String name = req.getParameter("name");

			  Map<String, Object> map = new HashMap<>();
			  
			  String drugName;
			  String drugType;
			  Float drugUnitPrice1;
			  Float drugUnitPrice2;
			  Integer drugStoreLeader;
			  
			  Drug drug = new Drug();
			  DrugStore drugstore = new DrugStore();
			  
			  if(StringUtil.isStrNotEmpty(req.getParameter("drugUnitPrice1")))
			  {
				  drugUnitPrice1 = Float.parseFloat(req.getParameter("drugUnitPrice1"));
				  map.put("drugUnitPrice1", drugUnitPrice1);
			  }

			  if(StringUtil.isStrNotEmpty(req.getParameter("drugUnitPrice2")))
			  {
				  drugUnitPrice2 = Float.parseFloat(req.getParameter("drugUnitPrice2"));
				  map.put("drugUnitPrice2", drugUnitPrice2);
			  }
			  
			  System.out.println("*********************"+req.getParameter("drugstore.drugStoreLeader"));
			  if(StringUtil.isStrNotEmpty(req.getParameter("drugstore.drugStoreLeader")))
			  {
				  drugStoreLeader = Integer.parseInt(req.getParameter("drugstore.drugStoreLeader"));
				  drugstore.setDrugStoreLeader(drugStoreLeader);
				  map.put("drugStoreLeader", drugStoreLeader);
			  }
			  
			  
			  map.put("drugName", req.getParameter("drugName"));
			  map.put("drugType", req.getParameter("drugType"));

			  
			  //璋冪敤涓氬姟閫昏緫灞備腑鐨勬煡璇㈡柟娉�
			  List<Drug> list = db.selectByCondition(map);
			  
			  //鎶婃暟鎹浆鎹负json瀛楃涓�
			  String json = JsonUtil.getJson(list);
			  System.out.println(json);
			  
			  //鑾峰彇杈撳嚭瀵硅薄
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
			  out.write(json);//杈撳嚭
			  out.flush();//鍒锋柊
			  out.close();//鍏抽棴
		  	}
		  
		  	else if("sendUpdate".equals(method)){
			  //璺宠浆鍒颁慨鏀归〉闈�  锛堥渶瑕佹牴鎹富閿粠鏁版嵁搴撲腑鏌ヨ鍘熸潵鐨勬暟鎹俊鎭�)
			  String drugID = req.getParameter("drugID");
			  
			  //璋冪敤涓氬姟閫昏緫灞傜殑鏌ヨ鏂规硶
			  Drug drug =  db.selectByID(Integer.parseInt(drugID));
			  
			  //鎶婃暟鎹浆鎹负json瀛楃涓�
			  String json = JsonUtil.getJson(drug);
			  
			  //鑾峰彇杈撳嚭瀵硅薄
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
			  out.write(json);//杈撳嚭
			  out.flush();//鍒锋柊
			  out.close();//鍏抽棴
		  }else if("update".equals(method)){
			  //淇敼
			  
			  Drug drug = new Drug();
			  
			  
			  System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+req.getParameter("drugID"));
			  String drugID = req.getParameter("drugID");
			  System.out.println(req.getParameter("drugID"));
			  //Integer prescriptionID2= Integer.parseInt(req.getParameter("prescriptionID2"));
			  Integer drugStoreID= Integer.parseInt(req.getParameter("drugStoreID"));
			  String drugName= req.getParameter("drugName");
			  String drugType= req.getParameter("drugType");
			  String drugUnit= req.getParameter("drugUnit");
			  Float drugUnitPrice= Float.parseFloat(req.getParameter("drugUnitPrice"));
			   
			  drug.setDrugID(drugID);
			  //drug.setPrescriptionID2(prescriptionID2);
			  drug.setDrugStoreID(drugStoreID);
			  drug.setDrugName(drugName);
			  drug.setDrugType(drugType);
			  drug.setDrugUnit(drugUnit);
			  drug.setDrugUnitPrice(drugUnitPrice);
			  drug.setIsDelete(0);
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String drugProductionDate=req.getParameter("drugProductionDate");
			  String drugLife= req.getParameter("drugLife");
			  try {
				  drug.setDrugProductionDate(sdf.parse(drugProductionDate));
				  drug.setDrugLife(sdf.parse(drugLife));
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			  
			  //璋冪敤涓氬姟閫昏緫灞傜殑淇敼鏂规硶
			 boolean flag =  db.update(drug);
			 
			 System.out.println(flag);
			 
			 //鑾峰彇杈撳嚭瀵硅薄
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
			  out.write(flag ? "1" : "0");//杈撳嚭
			  out.flush();//鍒锋柊
			  out.close();//鍏抽棴

		  }
		  
		  	else if("sendDelete".equals(method)){
			  //璺宠浆鍒颁慨鏀归〉闈�  锛堥渶瑕佹牴鎹富閿粠鏁版嵁搴撲腑鏌ヨ鍘熸潵鐨勬暟鎹俊鎭�)
			  String drugID = req.getParameter("drugID");
			  
			  //璋冪敤涓氬姟閫昏緫灞傜殑鏌ヨ鏂规硶
			  Drug drug =  db.selectByID(Integer.parseInt(drugID));
			  
			  //鎶婃暟鎹浆鎹负json瀛楃涓�
			  String json = JsonUtil.getJson(drug);
			  
			  //鑾峰彇杈撳嚭瀵硅薄
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
			  out.write(json);//杈撳嚭
			  out.flush();//鍒锋柊
			  out.close();//鍏抽棴
		  }
		  
		  else if("Delete".equals(method)){
			  //淇敼
			  String drugID = req.getParameter("drugID");
	
			  //璋冪敤涓氬姟閫昏緫灞傜殑淇敼鏂规硶
			 boolean flag =  db.delete(Integer.parseInt(drugID));
			 
			 System.out.println(flag);
			 
			 //鑾峰彇杈撳嚭瀵硅薄
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
			  out.write(flag ? "1" : "0");//杈撳嚭
			  out.flush();//鍒锋柊
			  out.close();//鍏抽棴
		  }
		  else if("insert".equals(method)){
			  //淇敼
			  Integer drugStoreID;
			  Float drugUnitPrice;
			  
			  Drug drug = new Drug();
			  

			  if(StringUtil.isStrNotEmpty(req.getParameter("drugStoreID")))
			  {
				  drugStoreID = Integer.parseInt(req.getParameter("drugStoreID"));
				  drug.setDrugStoreID(drugStoreID);
			  }

			  if(StringUtil.isStrNotEmpty(req.getParameter("drugUnitPrice")))
			  {
				  drugUnitPrice = Float.parseFloat(req.getParameter("drugUnitPrice"));
				  drug.setDrugUnitPrice(drugUnitPrice);
			  }
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			  String drugProductionDate=req.getParameter("drugProductionDate");
			  String drugLife= req.getParameter("drugLife");
			  try {
				  drug.setDrugProductionDate(sdf.parse(drugProductionDate));
				  drug.setDrugLife(sdf.parse(drugLife));
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			  
			  drug.setDrugName(req.getParameter("drugName"));
			  drug.setDrugType(req.getParameter("drugType"));
			  drug.setDrugUnit(req.getParameter("drugUnit"));
			  //situation.getPatient().setContactPersonName(name);
			  
			  
			  //璋冪敤涓氬姟閫昏緫灞備腑鐨勬煡璇㈡柟娉�
			  boolean flag = db.insert(drug);
			  
			  System.out.println(flag);
				 
			  //鑾峰彇杈撳嚭瀵硅薄
			  PrintWriter out = resp.getWriter();
			  resp.setContentType("UTF-8");//鎶妀son鏁版嵁鐨勭紪鐮佹牸寮忚缃负UTF-8
			  out.write(flag ? "1" : "0");//杈撳嚭
			  out.flush();//鍒锋柊
			  out.close();//鍏抽棴
		  }
		  

	}
	
}

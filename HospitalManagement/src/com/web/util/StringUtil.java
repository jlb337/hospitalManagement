package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	//字符串是否非空
	public static boolean isStrNotEmpty(String str){
		if(str==null){
			return false;
		}
		return str.length()>0?true:false;
	}
	
	//字符串转化为日期格式
	public static Date stringToDate(String str){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		//判断字符串是否非空
		if(StringUtil.isStrNotEmpty(str))
		{
			try {
				d=sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return d;
	}
	
	//日期转字符串
	public static String dateToString(Date d)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=null;
		str=sdf.format(d);
		return str;
	}
}

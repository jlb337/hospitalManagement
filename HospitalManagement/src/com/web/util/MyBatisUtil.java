package com.web.util;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	static SqlSessionFactory sqlSessionFactory=null;
	static SqlSession sqlSession=null;
	//静态代码块里接收的参数必须是静态参数
	static {
		try {
			//1.读取属性文件
			String resource = "sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//2.创建sqlSession工厂
		    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession openSession(){
		//3.创建sqlSession对象
		try {
			 sqlSession = sqlSessionFactory.openSession();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	public static void close(){
		if(sqlSession!=null)
		//关闭
			sqlSession.close();
	}
}

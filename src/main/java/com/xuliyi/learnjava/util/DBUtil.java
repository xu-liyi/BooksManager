package com.xuliyi.learnjava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.zaxxer.hikari.*;

/**
 * 数据库工具类
 * @Date: 2023年9月4日
 */
public class DBUtil {
	//数据库用户名
	public static String JDBC_USER = "root";
	//数据库密码
	public static String JDBC_PASSWORD = "root";
	//数据库链接
	public static String JDBC_URL = "jdbc:mysql://localhost:3306/books?useSSL=false&characterEncoding=utf8";
	//使用HikariConfig连接池，提升系统效率
	public static HikariConfig config = new HikariConfig();
	//JDBC连接池接口
	public static DataSource ds;
	
	//静态初始化块，所有类共用
	static {
		//检查是否有数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//配置连接池
		config.setJdbcUrl(JDBC_URL);
		config.setUsername(JDBC_USER);
		config.setPassword(JDBC_PASSWORD);
		config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
		config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
		config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
		ds = new HikariDataSource(config);
	}

	
	
	/**  
	* 获取数据库链接
	* @param      
	* @return Connection      
	* @throws  
	*/  
	public static Connection getConnectDb() {
		
		Connection conn = null;
		try {
			//conn = DriverManager.getConnection(url, username, password);
			//从连接池中提取连接
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**  
	* 关闭数据库连接
	* 使用try-with-resource改写代码，不再使用此方法
	* @param      
	* @return void      
	* @throws  
	*/  
//	public static void CloseDB(ResultSet rs, PreparedStatement stm, Connection conn) {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (stm != null) {
//			try {
//				stm.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
}

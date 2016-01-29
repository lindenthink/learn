package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * h2远程连接测试
 * @author Linden
 * 基于TCP/IP的服务器模式，这种连接方式和其他数据库类似，是基于Service的形式进行连接的，因此
 * 允许多个客户端同时连接
 */
public class H2RemoteConn {
	private static final String h2_url = "jdbc:h2:tcp://localhost/~/test";
	private static final String h2_user = "sa";
	private static final String h2_password = "123";
	private static final String h2_driver = "org.h2.Driver";
	static{
		try {
			Class.forName(h2_driver);
		} catch (ClassNotFoundException e) {
			System.out.println("加载h2驱动失败！");
			e.printStackTrace();
		}
	}
	
	public Connection getCon() throws SQLException{
		return DriverManager.getConnection(h2_url,h2_user,h2_password);
	}
	
}

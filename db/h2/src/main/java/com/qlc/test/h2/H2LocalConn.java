package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * h2本地连接测试
 * @author Linden
 * 这种连接方式默认情况下只允许有一个客户端连接到数据库，连接时
 * 数据库文件会被锁定，所以测试时WebConsole控制台中不能登录该数据库
 */
public class H2LocalConn {
	private static final String h2_url = "jdbc:h2:~/test";
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

package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * h2的内存模式
 * @author Linden
 * 
 */
public class H2MemoryConn {
	private static final String h2_url = "jdbc:h2:tcp://localhost/mem:test";
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

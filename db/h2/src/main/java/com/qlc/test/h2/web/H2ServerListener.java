package com.qlc.test.h2.web;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

/**
 * 用于启动h2服务的监听器
 * 启动项目时，h2服务业会启动，和直接运行h2启动脚本效果相同
 * @author Linden
 *
 */
public class H2ServerListener implements ServletContextListener{

	private Server server;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		if(server!= null){
			server.stop();
			this.server = null;
			System.out.println("***h2服务停止成功***");
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			System.out.println("***h2数据库正在启动***");
			server = Server.createTcpServer().start();
			System.out.println("***h2数据库启动成功***");
		} catch (SQLException e) {
			System.out.println("启动h2数据库失败：" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
		
}

package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * h2单元测试
 * @author Linden
 *
 */
public class H2Test {
	@Test
	/**
	 * 测试本地连接，实质是访问本地数据库文件，不能开启WebConsole
	 * @throws SQLException
	 */
	public void testLocalConn() throws SQLException{
		Connection conn = new H2LocalConn().getCon();
		Statement statement = conn.createStatement();
		String sql = "select * from test";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID:"+rs.getString(1)+"\tNAME:"+rs.getString(2));
		}
		statement.close();
		conn.close();
	}
	
	@Test
	/**
	 * 测试远程连接，须开启h2服务
	 * @throws SQLException
	 */
	public void testRemoteConn() throws SQLException{
		Connection conn = new H2RemoteConn().getCon();
		Statement statement = conn.createStatement();
		String sql = "select * from test";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID:"+rs.getString(1)+"\tNAME:"+rs.getString(2));
		}
		statement.close();
		conn.close();
	}
	
	@Test
	/**
	 * 测试远程连接h2内存模式，须开启h2服务
	 * @throws SQLException
	 */
	public void testMemoryConn() throws SQLException{
		Connection conn = new H2MemoryConn().getCon();
		Statement statement = conn.createStatement();
		
		String dropIfExistSql = "DROP TABLE IF EXISTS TEST;";
		String createSql = "CREATE TABLE TEST(ID INT PRIMARY KEY,NAME VARCHAR(255));";
		String insertSql1 = "INSERT INTO TEST VALUES(1, 'Hello');";
		String insertSql2 = "INSERT INTO TEST VALUES(2, 'World');";
		statement.addBatch(dropIfExistSql);
		statement.addBatch(createSql);
		statement.addBatch(insertSql1);
		statement.addBatch(insertSql2);
		statement.executeBatch();
		
		String sql = "select * from test";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID:"+rs.getString(1)+"\tNAME:"+rs.getString(2));
		}
		statement.close();
		conn.close();
	}
}

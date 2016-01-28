package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * h2µ¥Ôª²âÊÔ
 * @author Linden
 *
 */
public class H2Test {
	@Test
	public void testConn() throws SQLException{
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
}

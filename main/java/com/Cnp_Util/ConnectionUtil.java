package com.Cnp_Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;

public class ConnectionUtil {
public static Connection getConnection() {
	Connection con=null;
	try {
		InitialContext ct=new InitialContext();
		javax.sql.DataSource dt = (javax.sql.DataSource) ct.lookup("java:comp/env/product");
		con=dt.getConnection();
		
	} catch (NamingException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}
}

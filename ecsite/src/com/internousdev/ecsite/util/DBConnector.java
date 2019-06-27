package com.internousdev.ecsite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String driverName = "com.mysql.jdbc.Driver";//ドライバー名
	private static String url="jdbc:mysql://localhost/ecsite_naoshima";//mysqlURL

	private static String user="root";//mysqlユーザー
	private static String password="root";//mysqlパスワード

		public Connection getConnection(){//接続コード
			Connection con = null;

			try{
				Class.forName(driverName);
				con = (Connection) DriverManager.getConnection(url,user,password);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return con;
		}

}

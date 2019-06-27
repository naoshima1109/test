package com.internousdev.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector{
	private static String driverName="com.mysql.jdbc.Driver";//mysqlに接続
	private static String url="jdbc:mysql://localhost/logindb_naoshima";//mysqlに接続
	
	
	private static String user ="root";//ユーザーネーム
	private static String password="root";//mysqlのパスワード
	
	
	public Connection getConnection(){//mysqlを繋ぐコード
		Connection con=null;
		
		try{
			Class.forName(driverName);
			con=(Connection)DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
		}
}


package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";
	//データを登録する
	public void createUser(String loginUserId, String loginUserPassword, String userName)throws SQLException{
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);//java接続
			preparedStatement.setString(1,loginUserId);//?の１番目の箱にloginUserIdを格納
			preparedStatement.setString(2,loginUserPassword);//?の2番目の箱にloginUserPasswordを格納
			preparedStatement.setString(3,userName);//?の3番目の箱にuserNameを格納
			preparedStatement.setString(4,dateUtil.getDate());//?の4番目の箱にdateUtilを格納

			preparedStatement.execute();//実行

		}catch(Exception e){
			e.printStackTrace();//エラー文
		}finally{
			connection.close();//DBを閉じる
		}
	}

}

package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class UserCreateCompleteDAO {
	private DateUtil dateUtil =new DateUtil();

	private String sql = "INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";//データ登録

		public void createUser(String loginUserId,String loginUserPassword,String userName)throws
		SQLException{//実行
				DBConnector dbConnector = new DBConnector();//DB接続

				Connection connection = dbConnector.getConnection();//DB接続

				try{

					PreparedStatement preparedStatement = connection.prepareStatement(sql);//java接続
					preparedStatement.setString(1,loginUserId);//?の1番目の箱にloginUserIdが入る
					preparedStatement.setString(2,loginUserPassword);//?の2番目の箱にloginUserPasswordが入る
					preparedStatement.setString(3,userName);//?の3番目にuserNameが入る
					preparedStatement.setString(4,dateUtil.getDate());//?の4番目にdateUtilが入る

					preparedStatement.execute();//実行
				}catch(Exception e){//エラー文表示
					e.printStackTrace();
				}finally{//DBを閉じる
					connection.close();
				}
		}

}

package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite2.util.DBConnector;

public class UserCreateConfirmDAO {

	private com.internousdev.ecsite2.util.DBConnector dbConnector=new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public boolean isExistUser(String loginUserId) {//isExistUser(String loginUserId)クラスに格納
		//boolean:true,falseを格納できる
		String sql="SELECT COUNT(*) AS COUNT FROM login_user_transaction where login_id = ?";
		//sqlからlogin_user_transactionにあるlogin_idを探す
		boolean result = false;
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			//sqlに接続
			preparedStatement.setString(1,loginUserId);
			//箱の一番にloginIdが格納されている
			ResultSet resultSet = preparedStatement.executeQuery();
			//sqlを実行
			if(resultSet.next()) {
				if(resultSet.getInt("COUNT")>0) {
					//もし1つでも同じIDがあったら
					result = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

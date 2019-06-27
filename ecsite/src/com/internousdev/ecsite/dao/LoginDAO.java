package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){//LoginDTOから拾ってきた値をgetLoginUserInfoに格納
		String sql ="SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";//selectテーブル
		try{

			PreparedStatement preparedStatement = connection.prepareStatement(sql);//java接続

			preparedStatement.setString(1,loginUserId);//?の１番目の箱にloginUserIdを格納
			preparedStatement.setString(2,loginPassword);//?の2番目の箱にloginPasswordを格納

			ResultSet resultSet = preparedStatement.executeQuery();//実行メソッド

			if(resultSet.next()){//login_id,login_pass,user_nameをユーザーが入力したか確認
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				if(resultSet.getString("login_id")!=null){//もし実行してlogin_idが初期値の場合
					loginDTO.setLoginFlg(true);//loginDTOのLoginFlgがfalseからtrueになる
				}
			}
		}catch(Exception e){//エラー文
			e.printStackTrace();
		}
		return loginDTO;//dtoに返す
	}


}

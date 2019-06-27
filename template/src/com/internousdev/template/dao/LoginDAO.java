package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){//LoginDTOから拾ってきた値をgetLoginUserInfoに格納
		DBConnector dbConnector = new DBConnector();//DBへの接続準備
		Connection connection =dbConnector.getConnection();//DBへの接続準備
		LoginDTO loginDTO = new LoginDTO();//コピー
		String sql ="SELECT*FROM login_user_transaction where login_id =? AND login_pass=?";//mysqlのselect文
				try{
					PreparedStatement preparedStatement = connection.prepareStatement(sql);//javaで利用

					preparedStatement.setString(1,loginUserId);//１番の箱の?にActionから送られたloginUserIdが入る
					preparedStatement.setString(2,loginPassword);//2番の箱の?にActionから送られたloginPasswordが入る

					ResultSet resultSet=preparedStatement.executeQuery();//select文のSQL文を実行するメソッド

					if(resultSet.next()){//select文でDBから取得した情報をString型に変換してDTOクラスに格納LoginDTOクラスのsetterを利用
						loginDTO.setLoginId(resultSet.getString("login_id"));
						loginDTO.setLoginPassword(resultSet.getString("login_pass"));
						loginDTO.setUserName(resultSet.getString("user_name"));

						if(!(resultSet.getString("login_id").equals(null))){//もし"login_id"が初期値だったら”LoginFlg”をtrueにする
								loginDTO.setLoginFlg(true);
						}
					}
				}catch(Exception e){//エラーを表示する
					e.printStackTrace();
				}
				return loginDTO;//loginDTOに返す
	}

}

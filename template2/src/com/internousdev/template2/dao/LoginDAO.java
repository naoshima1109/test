package com.internousdev.template2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template2.dto.LoginDTO;
import com.internousdev.template2.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		DBConnector dbConnector=new DBConnector();
		Connection connection = dbConnector.getConnection();

		LoginDTO loginDTO = new LoginDTO();
		String sql="SELECT * FROM login_user_transaction where login_id =? AND login_pass=?";

		try{PreparedStatement preparedStatement =connection.prepareStatement(sql);


			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				if(resultSet.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}

			return loginDTO;
		}

		public int buyItemHistoryDelete(String item_transaction_id,String user_master_id)throws SQLException{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();

			String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id = ?";
			PreparedStatement preparedStatement;
			int result = 0;

			try{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,item_transaction_id);
				preparedStatement.setString(2,user_master_id);

				result = preparedStatement.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
			return result;
		}
	}



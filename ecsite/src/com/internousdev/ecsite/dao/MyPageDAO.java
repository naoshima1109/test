package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;


public class MyPageDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo
	(String item_transaction_id,String user_master_id)throws SQLException{
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql ="SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id= ? ORDER BY insert_date DESC";
		//selectテーブル
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);//java接続
			preparedStatement.setString(1, item_transaction_id);//?の1番目の箱にitem_transaction_idを格納
			preparedStatement.setString(2,user_master_id);//?の２番目の箱にuser_master_idを格納

			ResultSet resultSet = preparedStatement.executeQuery();//実行

			while(resultSet.next()) {//select文でDBから取得した情報をString型に変換してDTOクラスに格納LoginDTOクラスのsetterを利用
				MyPageDTO dto = new MyPageDTO();//コピー
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}
			} catch(Exception e) {//エラー文
				e.printStackTrace();
			} finally {//DBを閉じる
				connection.close();
			}
			return myPageDTO;//dtoに返す

		}

		public int buyItemHistoryDelete
			(String item_transaction_id, String user_master_id)throws SQLException {

			String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id= ? AND user_master_id = ?";
			//削除テーブル
			PreparedStatement preparedStatement;//java
			int result =0;//実行初期値
			try {
				preparedStatement = connection.prepareStatement(sql);//java接続
				preparedStatement.setString(1, item_transaction_id);//?の１番目の箱にitem_transaction_idを格納
				preparedStatement.setString(2, user_master_id);//?の2番目の箱にuser_master_id
				result = preparedStatement.executeUpdate();//実行アップデート
			}catch(SQLException e) {//エラー文
				e.printStackTrace();
			}finally {
				connection.close();//DBを閉じる
			}
			return result;//resultを返す
		}
	}


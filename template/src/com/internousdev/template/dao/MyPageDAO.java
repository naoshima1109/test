package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {
	
	public MyPageDTO getMyPageUserInfo(String item_transaction_id,String user_master_id)//MyPageUserInfoという箱にitem_transaction_id,user_master_idを格納
throws SQLException{
		DBConnector dbConnector = new DBConnector();//DB接続
		Connection connection =dbConnector.getConnection();//DB接続
		MyPageDTO myPageDTO = new MyPageDTO();//コピー
		String sql="SELECT iit.item_name, ubit.total_price, ubit.total_count, ubit.pay FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY ubit.insert_date DESC";
			//データを抽出する
		try{
			PreparedStatement preparedStatement =
connection.prepareStatement(sql);//javaで利用
			preparedStatement.setString(1,item_transaction_id);//1番目の箱とitem_transaction_idが入っている
			preparedStatement.setString(2,user_master_id);//2番目の箱とuser_master_idが入っている
			ResultSet resultSet = preparedStatement.executeQuery();//実行する

			if(resultSet.next()){
				myPageDTO.setItemName(resultSet.getString("item_name"));//myPageDTOのsetItemNameをitem_nameとする
				myPageDTO.setTotalPrice(resultSet.getString("total_price"));//myPageDTOのsetTotalPriceをtotal_priceとする
				myPageDTO.setTotalCount(resultSet.getString("total_count"));//myPageDTOのsetTotalCountをtotalcountとする
				myPageDTO.setPayment(resultSet.getString("pay"));////myPageDTOのsetPaymentをpayとする
			}
		}catch(Exception e){
			e.printStackTrace();//エラー文
		}finally{
			connection.close();//DBを閉じる
		}
		return myPageDTO;//myPageDTOを返す
	}

	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{//実行メソッド
		DBConnector dbConnector = new DBConnector();//DB接続
		Connection connection = dbConnector.getConnection();//DB接続

		String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id=?";//削除テーブル
		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement = connection.prepareStatement(sql);//javaで利用
			preparedStatement.setString(1,item_transaction_id);//1番目の箱とitem_transaction_idが入っている
			preparedStatement.setString(2,user_master_id);//2番目の箱とuser_master_idが入っている

			result = preparedStatement.executeUpdate();//実行をアップデート

		}catch(SQLException e){
			e.printStackTrace();//エラー文表示
		}finally{
			connection.close();//DB接続を切る
		}
		return result;//実行を返す

	}
}

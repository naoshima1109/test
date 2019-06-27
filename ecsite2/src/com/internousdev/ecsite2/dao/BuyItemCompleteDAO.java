package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class BuyItemCompleteDAO {

	public int buyItemeInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String pay)throws SQLException{

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

		int result = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());
			result = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return result;
	}

	public void updateItemStock(int count, String id) throws SQLException{
		DBConnector dbConnector =new DBConnector();
		Connection connection = dbConnector.getConnection();
		//DB接続
		String sql = "UPDATE item_info_transaction SET item_stock = item_stock - ? WHERE id = ?";
		//item_info_transactionのitemstockをitem_stockから購入個数を引いた値に更新
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);//sqlに接続
			preparedStatement.setInt(1,count);//箱1にcountを格納
			preparedStatement.setString(2,id);//箱2にidを格納
			preparedStatement.executeUpdate();//更新を実行
		}catch(Exception e) {
			e.printStackTrace();//エラー表示
		}finally {
			connection.close();//sqlを閉じる
		}
	}

}

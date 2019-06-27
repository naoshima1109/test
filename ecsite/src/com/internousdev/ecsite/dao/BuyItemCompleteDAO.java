package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	public void buyItemeInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String pay)throws SQLException{//実行

		DBConnector dbConnector = new DBConnector();//DB接続
		Connection connection = dbConnector.getConnection();//DB接続
		DateUtil dateUtil = new DateUtil();//コピー
		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";
		//新しくテーブルを作る
		try{

			PreparedStatement preparedStatement = connection.prepareStatement(sql);//javaを接続
			preparedStatement.setString(1, item_transaction_id);//?の１番目にitem_transaction_id
			preparedStatement.setString(2, total_price);//?の２番目の箱にtotal_price
			preparedStatement.setString(3, total_count);//?の3番目の箱にtotal_count
			preparedStatement.setString(4, user_master_id);//?の4番目の箱にuser_master_id
			preparedStatement.setString(5, pay);//?の5番目の箱にpay
			preparedStatement.setString(6, dateUtil.getDate());//?の6番目の箱にdateUtil
			preparedStatement.execute();//実行
		}catch(Exception e) {//エラー文
			e.printStackTrace();
		}finally {
			connection.close();//DBを閉じる
		}
	}

}

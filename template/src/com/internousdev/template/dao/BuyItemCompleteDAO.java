package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class BuyItemCompleteDAO {
	private DateUtil dateUtil = new DateUtil();//すでにあったらDAteUtilを新しく作る

	private String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)VALUES(?,?,?,?,?,?)";
	//テーブルを使用
	public void buyItemInfo(String item_transaction_id,String user_master_id,String total_price,//buyItemInfoの箱
			String total_count,String pay) throws SQLException{//実行メソッド
	DBConnector dbConnector = new DBConnector();//DBを接続する
	Connection connection = dbConnector.getConnection();//DBを接続する
	try{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);//javaを使用
		preparedStatement.setString(1,item_transaction_id);//1番目の箱？に入る
		preparedStatement.setString(2,total_price);//2番目の箱？に入る
		preparedStatement.setString(3,total_count);//3番目の箱？に入る
		preparedStatement.setString(4,user_master_id);//4番目の箱？に入る
		preparedStatement.setString(5,pay);//5番目の箱？に入る
		preparedStatement.setString(6,dateUtil.getDate());//6番目の箱？に入る

		preparedStatement.execute();//実行
	}catch(Exception e){
			e.printStackTrace();//エラー文
	}finally{
		connection.close();//DBを切る
	}
}
}


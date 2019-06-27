package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();//DB接続
	private Connection connection = dbConnector.getConnection();//DB接続
	private BuyItemDTO buyItemDTO = new BuyItemDTO();//コピー

	public BuyItemDTO getBuyItemInfo(){
		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";//selectテーブル

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);//javaに接続
			ResultSet resultSet = preparedStatement.executeQuery();//java実行
			if(resultSet.next()){//ユーザーの入力があってるか確認する
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e){//エラー文
			e.printStackTrace();
		}
		return buyItemDTO;//dtoに返す
	}

}

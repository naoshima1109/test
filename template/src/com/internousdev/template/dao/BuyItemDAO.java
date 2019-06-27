package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo(){
		DBConnector dbConnector = new DBConnector();//DB接続
		Connection connection = dbConnector.getConnection();//DB接続
		BuyItemDTO buyItemDTO = new BuyItemDTO();//BuyItemDTOがすでにあったら新しく作る

		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";//テーブルを使用
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);//javaを使用
			ResultSet resultSet = preparedStatement.executeQuery();//実行メソッド

			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}//id,item_name,item_priceがあるか実行
		}catch(Exception e){
			e.printStackTrace();//エラー文
		}
		return buyItemDTO;//buyItemDTOに返す
	}

}

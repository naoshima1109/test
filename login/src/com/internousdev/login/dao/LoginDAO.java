package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
	public LoginDTO select(String name,String password) throws SQLException{//LoginDTO型を戻り値にしたメソッドを作る。
		LoginDTO dto=new LoginDTO();//コピー
		DBConnector db=new DBConnector();//DBへの接続準備
		Connection con=db.getConnection();//DBへの接続準備

		String sql="select*from user where user_name=? and password=?";//userテーブルを選択
		try{
			PreparedStatement ps=con.prepareStatement(sql);//javaを使う
			ps.setString(1,name);//1番目の箱の?にActionから送られたname
			ps.setString(2,password);//2番目の箱の?にActionから送られたpassword
			ResultSet rs=ps.executeQuery();//select文のSQL文を実行するメソッド

			if(rs.next()){
				//select文でDBから取得した情報をString型に変換してDTOクラスに格納
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}
		}catch(SQLException e){//処理中にSQL関連のエラーが発生した際に実行する処理
			e.printStackTrace();
		}finally{//DB接続を終了する時に必ず書くメソッド
			con.close();
		}
		return dto;//dtoに入った値をActionクラスに渡す。
	}

}

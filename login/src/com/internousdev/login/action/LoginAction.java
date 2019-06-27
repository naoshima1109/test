package com.internousdev.login.action;
import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {//Struts2が持つActionSupportというクラスを継承

	private String name; //JSPから受け取る値
	private String password; //JSPから受け取る値

	public String execute() throws SQLException{//実行メソッド
		String ret=ERROR;

		LoginDAO dao=new LoginDAO();//コピー
		LoginDTO dto=new LoginDTO();//コピー

		dto=dao.select(name,password); //JSPから送られてきたnameとpasswordを引数としてLoginDAOクラスのselectメソッドを呼び出す。
										//そのあとDAOで取得した結果をLoginDTOに代入。
		if(name.equals(dto.getName())){//ユーザーが入力した「ログインID」(name)と「パスワード」(password)が、DTOから持ってきた値
			if(password.equals(dto.getPassword())){//(dto.getName())と(dto.getPassword())にそれぞれ一致するか確認
				ret=SUCCESS;//if文の条件を満たした場合、戻り値「ret」の内容をSUCCESSに書き換える。
			}
		}
		return ret;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}

}

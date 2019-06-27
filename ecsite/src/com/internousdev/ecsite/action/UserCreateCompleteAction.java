package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object>session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();//コピー

	public String execute() throws SQLException{//実行メソッド
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),//daoから送られたデータをsessionに格納
				session.get("loginPassword").toString(),
				session.get("userName").toString());

		String result = SUCCESS;//サクセスを実行userCreateComplete.jspに飛ぶ

		return result;//実行を返す
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}

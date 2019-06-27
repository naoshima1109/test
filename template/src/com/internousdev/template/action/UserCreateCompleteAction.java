package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{//継承

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object>session;

	public String execute() throws SQLException{//実行メソッド
		UserCreateCompleteDAO userCreateCompleteDAO =new UserCreateCompleteDAO();//UserCreateCompleteDAOがすでにある場合、新しく作る
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),//DAOからcreateUserを持ってくる
				session.get("loginPassword").toString(),//sessionに格納
				session.get("userName").toString());
				String result = SUCCESS;//SUCCESSの場合、userCreateComplete.jspに飛ぶ。
				//ID,password,userNameがsessionの箱に格納されたらサクセスを実行
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

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}

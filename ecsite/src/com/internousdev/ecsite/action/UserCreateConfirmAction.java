package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{//継承

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){//実行
		String result = SUCCESS;//サクセスを実行userCreateConfirm.jspへ飛ぶ

		if(!(loginUserId.equals(""))//ID、パスワード、ユーザーネームが全て記入されていたら実行
				&&!(loginPassword.equals(""))
				&&!(userName.equals(""))){
					session.put("loginUserId",loginUserId);
					session.put("loginPassword",loginPassword);
					session.put("userName",userName);
		}else{//もしそうでない場合、エラーメッセージで未入力の項目がありますと表示する
			setErrorMessage("未入力の項目があります。");
			result = ERROR;//エラー実行userCreate.jspに飛ぶ
		}
		return result;//resultに返す
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

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
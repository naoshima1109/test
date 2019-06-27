package com.internousdev.template.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object>session;
	private String errorMessage;

	public String execute(){//事項メソッド

		String result = SUCCESS;//サクセスの場合UserCreateConfirm.jspに飛ぶ

		if(!(loginUserId.equals(""))
			&& !(loginPassword.equals(""))
			&& !(userName.equals(""))){
				session.put("loginUserId",loginUserId);
				session.put("loginPassword",loginPassword);
				session.put("userName",userName);
				//ID、パスワード、ユーザーネームが全て記入されていたら実行
		}else{
			setErrorMessage("未入力の項目があります");
			result = ERROR;
			//もしそうじゃない場合、エラーメッセージを表示する
			//エラーの場合、userCreate.jspに飛ぶ
		}
		return result;//実行を返す
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId =loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword =loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
}

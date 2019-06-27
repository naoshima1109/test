package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{//継承
	
	public Map<String, Object>session;
	public String execute() {//実行メソッド
		session.clear();//sessionを削除
		return SUCCESS;//サクセスを実行home.jspに飛ぶ
	}
	
	@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
	}

}

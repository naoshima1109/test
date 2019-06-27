package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport{//継承
	public String execute(){//実行メソッド
		return SUCCESS;//サクセスを実行userCreate.jspに飛ぶ
	}

}

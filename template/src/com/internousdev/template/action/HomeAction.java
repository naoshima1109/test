package com.internousdev.template.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {//継承メソッド
	public String execute(){//executeメソッド
		return SUCCESS;//login.jspに飛ぶ
	}

}

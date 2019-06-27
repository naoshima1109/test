package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{//継承
	private Map<String,Object>session;
	public String execute()throws SQLException{//実行メソッド
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();//コピー
		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("buyItem_price").toString(),
				session.get("stock").toString(),
				session.get("pay").toString());
				//buyItemCompleteDAOから拾ってきた値をsessionの箱に格納
		String result=SUCCESS;//実行されたらbuyItemComplete.jspに飛ぶ
		return result;//実行を返す
	}

	public Map<String,Object>getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}

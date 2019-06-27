package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class BuyItemConfirmAction extends ActionSupport implements SessionAware {//継承
	public Map<String,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();//コピー
	public String execute() throws SQLException{//実行
		buyItemCompleteDAO.buyItemeInfo(//daoのbuyItemeInfoの中にsessionに格納
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());

		String result = SUCCESS;//サクセス実行でbuyItemComplete.jspに飛ぶ
		return result;//実行を返す
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}

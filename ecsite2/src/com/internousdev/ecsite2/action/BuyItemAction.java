package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private int count;
	private String pay;
	private String errorMessage;

	public String execute(){
		String result=SUCCESS;
		int itemStock = Integer.parseInt(session.get("item_stock").toString());
		//itemStockにInteger.parseIntが入ってる
		if(count > itemStock){
		//itemStockよりcountが多かったら
			setErrorMessage("在庫が足りません");
			//エラーメッセージを表示する
			return ERROR;
			//エラーの場合
		}
		session.put("count",count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount * intPrice);
		String payment;
		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay",payment);
		}else{
			payment = "クレジットカード";
			session.put("pay",payment);
		}

		return result;
	}

	public void setCount(int count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public Map<String,Object>getSession(){
		return this.session;
	}


}

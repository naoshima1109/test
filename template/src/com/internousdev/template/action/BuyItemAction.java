package com.internousdev.template.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{//継承

	private int stock;
	private String pay;
	public Map<String,Object> session;
	private String result;

	public String execute(){//実行メソッド
		result =SUCCESS;//処理を実行

		session.put("stock",stock);//sessionという箱に格納
		int intStock=Integer.parseInt(session.get("stock").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("buyItem_price",intStock * intPrice);//intStockとintPriceをかける
		
		String payment;

		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay",payment);
			//もし、現金払いだった場合、sessionを表示する
		}else{

			payment = "クレジットカード";
			session.put("pay",payment);
		}
		//それ以外の場合、sessionで表示される
		return result;//実行を返す
	}
	public int getStock(){
			return stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object>session){
			this.session =session;
	}
}
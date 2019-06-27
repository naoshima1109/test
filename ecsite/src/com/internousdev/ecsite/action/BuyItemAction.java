package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{//継承
	public Map<String,Object>session;
	private int count;
	private String pay;
	public String execute(){//実行メソッド
		String result = SUCCESS;//サクセスを実行
		session.put("count",count);//sessionに格納
		int intCount = Integer.parseInt(session.get("count").toString());//intCountに代入
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());//intPriceに代入
		session.put("total_price",intCount * intPrice);//sessionに格納。total_priceとintCount×intPriceを表示
		String payment;
		if(pay.equals("1")){//もし1だったら現金払いの場合payとpaymentを表示する。
			payment = "現金払い";
			session.put("pay",payment);
		}else{//クレジットの場合payとpaymentを表示する
			payment = "クレジットカード";
			session.put("pay",payment);
		}
		return result;//resultを返す
	}

	public void setCount(int count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}


}

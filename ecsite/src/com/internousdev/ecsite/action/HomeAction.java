package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{//継承
	public Map<String,Object>session;

	public String execute(){//実行
			String result = "login";//ログインを実行login.jspに飛ぶ
			if(session.containsKey("login_user_id")){//もしログインしている場合、buyItemの表示に飛ぶ
				BuyItemDAO buyItemDAO = new BuyItemDAO();//コピー
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();//BuyItemDTOから送られてきた値をbuyItemDAOに格納
				session.put("id",buyItemDTO.getId());//dtoをsessionに格納
				session.put("buyItem_name",buyItemDTO.getItemName());//dtoをsessionに格納
				session.put("buyItem_price",buyItemDTO.getItemPrice());//dtoをsessionに格納
					result = SUCCESS;//サクセスを実行buyItem.jspに飛ぶ
			}
			return result;//resultに返す
		}

		@Override
		public void setSession(Map<String,Object>session){
			this.session = session;
		}

		public Map<String,Object>getSession(){
			return this.session;
		}
	}


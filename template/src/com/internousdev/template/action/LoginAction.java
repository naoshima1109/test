package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport implements SessionAware{//継承

	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String,Object> session;

	public String execute(){
		LoginDAO loginDAO = new LoginDAO();//コピー
		LoginDTO loginDTO = new LoginDTO();//コピー
		BuyItemDAO buyItemDAO =new BuyItemDAO();//コピー


		result=ERROR;//実行結果エラー
		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);//loginDAOで習得した情報をloginDTOに代入。
		session.put("loginUser",loginDTO);//session.putという箱に格納

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){//ユーザーが入力した情報を検索する
			result = SUCCESS;//buyItem.jspに飛ぶ
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();//BuyItemDTOから取ってきた値をbuyItemDAOのgetBuyItemInfoに送る


			session.put("login_user_id",loginDTO.getLoginId());//sessionの箱にlogin_user_idとloginDTOのgetLoginIdを格納する
			session.put("id",buyItemDTO.getId());//sessionの箱にidとbuyItemDTOのgetIdを格納する
			session.put("buyItem_name",buyItemDTO.getItemName());//sessionの箱にbuyItem_nameとbuyItemDTOのgetItemNameを格納する
			session.put("buyItem_price",buyItemDTO.getItemPrice());//sessionの箱にbuyItem_priceとbuyItemDTOのgetItemPriceを格納する

			return result;//実行を返す

	}
	return result;//実行を返す
		}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}

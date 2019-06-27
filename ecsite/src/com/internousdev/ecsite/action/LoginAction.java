package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object>session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	public String execute() {//実行メソッド
		String result = ERROR;//エラーに返す
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);//dtoからdaoのgetLoginUserInfoを送られる
		session.put("loginUser",loginDTO);//sessionに格納

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){//もしログインできるなら
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();//dtoがdaoに送られる

			session.put("login_user_id",loginDTO.getLoginId());//dtoをsessionに格納
			session.put("id",buyItemDTO.getId());//sessionに格納
			session.put("buyItem_name",buyItemDTO.getItemName());//dtoをsessionに格納
			session.put("buyItem_price",buyItemDTO.getItemPrice());//dtoをsessionに格納

			return result;//resultに返す
		}
		return result;//resultに返す
	}
	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}

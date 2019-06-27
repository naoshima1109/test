package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{//実行メソッド
		if(!session.containsKey("login_user_id")){
			return ERROR;//エラーを返すhome.jspに飛ぶ
		}
		//商品履歴を削除しない場合
		if(deleteFlg == null) {
			String item_transaction_id = session.get("id").toString();//item_transaction_idにsession〜を代入
			String user_master_id = session.get("login_user_id").toString();//user_master_idにsession〜を代入
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);//myPageListにdaoを代入
		}else if(deleteFlg.equals("1")) {//それ以外の場合削除しなさい
			delete();
		}
			String result = SUCCESS;//サクセス実行myPage.jspに飛ぶ
			return result;//resultに返す
	}
	//商品履歴削除する場合
	public void delete() throws SQLException {

		String item_transaction_id = session.get("id").toString();//item_transaction_idにsession〜を代入
		String user_master_id = session.get("login_user_id").toString();//user_master_idにsession〜を代入

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);//resにdaoを代入

		if(res > 0) {//もしresが0より大きい場合商品情報を正しく削除しましたと表示する
			myPageList = null;//myPageListが初期値
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0) {//もしそれ以外resと0が等しい場合商品情報の削除に失敗しましたと表示する
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg)
	{	this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object>session)
	{	this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList()
	{	return this.myPageList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message)
	{	this.message = message;
	}
}
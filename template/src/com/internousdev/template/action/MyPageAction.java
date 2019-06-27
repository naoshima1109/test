package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{//継承メソッド
	public Map<String,Object> session;
	public String deleteFlg;
	private String result;
		public String execute() throws SQLException{//実行メソッド
			MyPageDAO myPageDAO = new MyPageDAO();//コピー
			MyPageDTO myPageDTO = new MyPageDTO();//コピー

			//商品履歴を削除しない場合
			if(deleteFlg == null){
				String item_transaction_id = session.get("id").toString();//item_transaction_idにsession〜を代入
				String user_master_id = session.get("login_user_id").toString();//user_master_idにsession〜を代入

				myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
				//myPageDTOをmyPageDAOに代入する

				session.put("buyItem_name",myPageDTO.getItemName());//myPage.jspに表示
				session.put("total_price",myPageDTO.getTotalPrice());//myPage.jspに表示
				session.put("total_count",myPageDTO.getTotalCount());//myPage.jspに表示
				session.put("total_payment",myPageDTO.getPayment());//myPage.jspに表示
				session.put("message","");//myPage.jspに表示
			//商品履歴を削除する場合
			}else if(deleteFlg.equals("1")){//もし一件でも削除できそうな場合は削除しなさい
				delete();

			}
			result = SUCCESS;//処理を実行
			return result;//実行を返す
		}
		public void delete()throws SQLException{//削除する

			MyPageDAO myPageDAO = new MyPageDAO();//コピー

			String item_transaction_id = session.get("id").toString();//item_transaction_idにsession〜を代入
			String user_master_id = session.get("login_user_id").toString();//user_master_idにsession〜を代入

			int res =myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);
			//myPageDAOのbuyItemHistoryDeleteという箱=res
			if(res>0){
			//もしresが0より大きかったら...
				session.put("message","商品情報を正しく削除しました。");
			//商品情報を正しく削除しました。と表示する
			}else if(res == 0){
			//もしresと0が等しかったら...
				session.put("message","商品情報の削除に失敗しました。");
			//商品情報の削除に失敗しました。と表示する
			}
		}
		public String getDeleteFlg(){
			return deleteFlg;
		}

		public void setDeleteFlg(String deleteFlg){
			this.deleteFlg = deleteFlg;
		}

		@Override
		public void setSession(Map<String,Object>loginSessionMap){
			this.session = loginSessionMap;
		}
	}


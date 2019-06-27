package com.internousdev.login3.action;
import java.sql.SQLException;

import com.internousdev.login3.dao.LoginDAO;
import com.internousdev.login3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String name;
	private String password;
	
	public String execute()throws SQLException{
		
		String ret=ERROR;
		
		LoginDTO dto=new LoginDTO();
		LoginDAO dao=new LoginDAO();
		
		dto=dao.select(name,password);
		
		
	}
}

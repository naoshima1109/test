package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.internousdev.webproj5.dto.InquiryDTO;
import com.internousdev.webproj5.util.DBConnector;


public class InquiryCompleteDAO {


	List<InquiryDTO>inquiryDTOList=new ArrayList<InquiryDTO>();


	public List<InquiryDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();




		String sql ="select * from inquiry";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()){
				InquiryDTO dto=new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
	}

}

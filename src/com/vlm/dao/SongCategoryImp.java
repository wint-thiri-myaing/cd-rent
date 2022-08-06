package com.vlm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vlm.cdmodal.Categorymodal;

public class SongCategoryImp implements SongCategory {
	String url = "jdbc:mysql://localhost:3306/cdrent?user=root&password=root";
	Connection conn = null;
	ResultSet rs = null;
	public List<Categorymodal> getAllCategories() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);

		List<Categorymodal> list = new ArrayList<Categorymodal>();
		
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from category");
		rs = ps.executeQuery();
		 while (rs.next()) {
			
			Categorymodal e = new Categorymodal();
			
			e.setCid(rs.getInt(1));
			e.setCategoryname(rs.getString(2));
			
			list.add(e);
		}
		conn.close();
		return list;
	}

}

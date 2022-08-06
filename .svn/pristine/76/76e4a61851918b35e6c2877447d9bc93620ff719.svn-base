package com.vlm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.vlm.cdmodal.AlbumListmodal;
import com.vlm.cdmodal.Categorymodal;

public class AlbumListImp implements AlbumList {
	String url = "jdbc:mysql://localhost:3306/cdrent?user=root&password=root";
	Connection conn = null;
	ResultSet rs = null;
	@Override
	public List<AlbumListmodal> getAlbumByCategoryId(int id) throws ClassNotFoundException, SQLException {
		
		
		List<AlbumListmodal> list = new ArrayList<AlbumListmodal>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from album where cid='"+id+"'");
			//ps.setInt(1, e.getCid());
			rs=ps.executeQuery();
			
			while(rs.next()){
				AlbumListmodal e=new AlbumListmodal();
				e.setAlbumid(rs.getInt(1));
				e.setCid(rs.getInt(2));
				e.setAlbumname(rs.getString(3));
				e.setSingetname(rs.getString(4));
				e.setPrice(rs.getInt(5));
				e.setQty(rs.getInt(6));
				list.add(e);
			}
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}finally {
			rs.close();
			conn.close();
		}
		
		return list;
	}
	

}

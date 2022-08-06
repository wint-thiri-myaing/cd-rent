package com.vlm.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vlm.cdmodal.Categorymodal;
import com.vlm.cdmodal.Usermodal;

public class CDrentImp implements Cdrent {
	String url = "jdbc:mysql://localhost:3306/cdrent?user=root&password=root";
	Connection conn = null;
	ResultSet rs = null;

	public int register(Usermodal u) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);

		int status = 0;
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("insert into users(name,password,loginflag) values(?,?,?)");
		ps.setString(1, u.getName());
		ps.setString(2, u.getPassword());
		ps.setInt(3, 0);
		

		status = ps.executeUpdate();
		return status;
	}
	public boolean isValidName(String name) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		
		boolean valid = true;
		String strSql = "select * from users where name='" + name + "'";
			PreparedStatement  ps=conn.prepareStatement(strSql);
			ResultSet rst = ps.executeQuery();
				if (rst.next()) {

					valid = false;

				}
			return valid;
	}


	public boolean validate(String name, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		
		boolean status = true;
	
		String strSql = "select * from users where name='" + name + "' and password='" + password + "'";
		PreparedStatement  ps=conn.prepareStatement(strSql);
		ResultSet rst = ps.executeQuery();

		if (rst.next()) {
			
			status = false;
		}
		return status;
	}
	public boolean isLogin(String name) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		
		boolean status = false;
		
		String strSql = "select * from users where name='" + name + "' and loginflag='1'";
		PreparedStatement  ps=conn.prepareStatement(strSql);
		ResultSet rst = ps.executeQuery();
		
		if (rst.next()) {
			
			status = true;
		}
		return status;
	}
	public void loginProcess(String name) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		
		PreparedStatement ps = conn.prepareStatement("update users set loginflag='1' where name='" + name + "'");
		
		ps.executeUpdate();
	}
	public void logoutProcess(String name) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		PreparedStatement ps = conn.prepareStatement("update users set loginflag='0' where name='" + name + "'");

		ps.executeUpdate();
	}

	public Usermodal UserId(String name) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		Usermodal usr=new Usermodal();
		int id=0;
		String strSql = "select * from users where name='" + name + "'";
			PreparedStatement  ps=conn.prepareStatement(strSql);
			ResultSet rst = ps.executeQuery();
				if (rst.next()) {

					id=rst.getInt("uid");

				}
			usr.setId(id);
			return usr;
	}


}

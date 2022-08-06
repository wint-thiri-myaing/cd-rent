package com.vlm.dao;

import java.sql.SQLException;
import java.util.List;

import com.vlm.cdmodal.Categorymodal;
import com.vlm.cdmodal.Usermodal;

public interface Cdrent {
	public  boolean validate(String name, String password) throws ClassNotFoundException, SQLException;
	public int register(Usermodal u) throws ClassNotFoundException, SQLException;
	public void loginProcess(String name) throws SQLException, ClassNotFoundException;
	public boolean isLogin(String name) throws SQLException, ClassNotFoundException;
	public void logoutProcess(String name) throws SQLException, ClassNotFoundException;
}

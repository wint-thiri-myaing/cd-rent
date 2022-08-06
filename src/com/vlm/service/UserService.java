package com.vlm.service;

import java.sql.SQLException;
import java.util.List;

import com.vlm.cdmodal.Categorymodal;
import com.vlm.cdmodal.Usermodal;
import com.vlm.dao.CDrentImp;
import com.vlm.dao.Cdrent;

public class UserService {
	
	static Cdrent cd=new CDrentImp();
	
	public int register(Usermodal u) throws ClassNotFoundException, SQLException{
		return cd.register(u);
		
	}
	public static  boolean validate(String name, String password) throws ClassNotFoundException, SQLException {
		return cd.validate(name,password);
	}
	public boolean isValidName(String name) throws SQLException, ClassNotFoundException{
		return ((CDrentImp) cd).isValidName(name);
		
	}
	public Usermodal UserId(String name) throws SQLException, ClassNotFoundException{
		return ((CDrentImp) cd).UserId(name);
		
	}
	public void loginProcess(String name) throws SQLException, ClassNotFoundException{
		cd.loginProcess(name);
	}
	public boolean isLogin(String name) throws SQLException, ClassNotFoundException{
		return cd.isLogin(name);
		
	}
	public void logoutProcess(String name) throws SQLException, ClassNotFoundException{
		cd.logoutProcess(name);
	}
}

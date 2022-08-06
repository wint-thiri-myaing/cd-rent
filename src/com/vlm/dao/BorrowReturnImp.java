package com.vlm.dao;

import java.sql.Connection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.vlm.cdmodal.BorrowDetailmodal;

public class BorrowReturnImp implements BorrowReturn {

	String url = "jdbc:mysql://localhost:3306/cdrent?user=root&password=root&zeroDateTimeBehavior=convertToNull";
	Connection conn = null;
	ResultSet rs = null;

	public void cdborrow(int uid, int id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		Statement stmt = (Statement) conn.createStatement();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String bdate = formatter.format(date);

		String strSql = "select * from bororrowdetail where uid=" + uid + " and albumid=" + id + " and bdate='" + bdate
				+ "' and flag='1'";

		rs = stmt.executeQuery(strSql);

		if (rs.next()) {
			PreparedStatement ps1 = (PreparedStatement) conn
					.prepareStatement("update bororrowdetail set qty=qty+1 where uid=" + uid + " and albumid=" + id
							+ " and bdate='" + bdate + "' and flag='1'");
			ps1.executeUpdate();
		} else {
			PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(
					"insert into bororrowdetail (uid,albumid,qty,flag,bdate,rdate) values(?,?,?,?,?,?)");
			ps2.setInt(1, uid);
			ps2.setInt(2, id);
			ps2.setInt(3, 1);
			ps2.setInt(4, 1);
			ps2.setString(5, bdate);
			ps2.setString(6, "0000-00-00");

			ps2.executeUpdate();
		}

		PreparedStatement ps3 = (PreparedStatement) conn
				.prepareStatement("update album set qty=qty-1 where albumid=" + id + "");
		ps3.executeUpdate();
		conn.close();
	}

	@Override
	public ArrayList<BorrowDetailmodal> borrowAlbumList(int uid) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);

		Statement stmt = (Statement) conn.createStatement();
		ArrayList<BorrowDetailmodal> list = new ArrayList<BorrowDetailmodal>();

		int borrowId = 0;
		String borrowDate = "";
		String currentDate = "";
		long day = 0;
		int qty = 0;
		String albumName = "";
		int price = 0;
		long netprice = 0;
		long total = 0;
		Date bdate = null;
		Date cdate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		currentDate = formatter.format(date);

		try {
			cdate = formatter.parse(currentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from bororrowdetail as b left join album as c on b.albumid=c.albumid where uid=" + uid
				+ " and flag='1'";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rst = ps.executeQuery();

		while (rst.next()) {

			BorrowDetailmodal bdmodal = new BorrowDetailmodal();

			borrowId = rst.getInt("bid");
			borrowDate = rst.getString("bdate");
			qty = rst.getInt("qty");
			albumName = rst.getString("albumname");
			price = rst.getInt("price");

			// System.out.println("ALbum name is" + albumName);

			try {
				bdate = formatter.parse(borrowDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			long diffday = cdate.getTime() - bdate.getTime();
			day = TimeUnit.DAYS.convert(diffday, TimeUnit.MILLISECONDS);

			
			if (day == 0) {
				day = 1;
			}

			netprice = qty * price * day;

			bdmodal.setId(borrowId);
			bdmodal.setCdname(albumName);
			bdmodal.setDay(day);
			bdmodal.setQty(qty);
			bdmodal.setNetprice(netprice);
			bdmodal.setTotal(total);

			list.add(bdmodal);
		}
		conn.close();
		return list;
	}

	@Override
	public void returnProcess(int uid, int bid) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		Statement stmt = (Statement) conn.createStatement();

		String returndate = ""; 
		
		int albumid = 0, qty = 0;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		returndate = formatter.format(date);

		String strSql = "select * from bororrowdetail where uid=" + uid + " and bid=" + bid + " and flag='1'";
		rs = stmt.executeQuery(strSql);

		// System.out.println("BID is" +bid);

		if (rs.next()) {
			albumid = rs.getInt("albumid");
			qty = rs.getInt("qty");

			PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(
					"update bororrowdetail set rdate='" + returndate + "',flag=0 where uid=" + uid + " and bid=" + bid);
			ps1.executeUpdate();
		} else {
			qty = 0;
		}
		PreparedStatement ps2 = (PreparedStatement) conn
				.prepareStatement("update album set qty=qty+? where albumid='" + albumid + "'");

		 ps2.setInt(1, qty);

		ps2.executeUpdate();

		conn.close();

	}

	@Override
	public boolean isBorrowHistory(int uid) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		Statement stmt = (Statement) conn.createStatement();

		boolean status = false;

		String strSql = "select * from bororrowdetail where uid='" + uid + "'";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(strSql);
		ResultSet rst = ps.executeQuery();

		if (rst.next()) {

			status = true;
		}
		return status;
	}

	public String isThisDateValid(String rDate, String dateFromat) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {

			// if not valid, it will throw ParseException
			Date date = sdf.parse(rDate);

		} catch (ParseException e) {

			e.printStackTrace();
			return "-";//return false;
		}
		return rDate;

		//return true;
	}

	public ArrayList<BorrowDetailmodal> getBorrowHistory(int uid) throws SQLException, ClassNotFoundException {
		// String url =
		// "jdbc:mysql://localhost:3306/cdrent?zeroDateTimeBehavior=convertToNull,user=root&password=root";

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		Statement stmt = (Statement) conn.createStatement();

		ArrayList<BorrowDetailmodal> borrowhistory = new ArrayList<BorrowDetailmodal>();
		String albName = null;
		String bDate = null;
		String rDate = "0000-00-00";
		int qty = 0;

		String strSql = "select * from bororrowdetail as b left join album as c on b.albumid=c.albumid where uid='"
				+ uid + "' order by bdate";
		ResultSet rst = stmt.executeQuery(strSql);

		while (rst.next()) {
			BorrowDetailmodal bhistory = new BorrowDetailmodal();

			albName = rst.getString("albumname");
			bDate = rst.getString("bdate");
			rDate = rst.getString("rdate");
			qty = rst.getInt("qty");


			if (rDate == null) {
				rDate = "-";
				
				//rDate = String.valueOf(brclass.isThisDateValid(rDate, "0000-00-00"));
				rDate=isThisDateValid(rDate, "0000-00-00");

			}

			bhistory.setCdname(albName);
			bhistory.setBorrowdate(bDate);
			bhistory.setReturndate(rDate);
			bhistory.setQty(qty);

			borrowhistory.add(bhistory);
		}

		return borrowhistory;
	}

}

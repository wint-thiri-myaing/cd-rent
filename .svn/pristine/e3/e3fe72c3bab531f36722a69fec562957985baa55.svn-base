package com.vlm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vlm.cdmodal.BorrowDetailmodal;


public interface BorrowReturn {
public void cdborrow(int uid,int id) throws ClassNotFoundException, SQLException;
public ArrayList<BorrowDetailmodal> borrowAlbumList(int uid) throws ClassNotFoundException, SQLException;
public void returnProcess(int uid, int bid) throws ClassNotFoundException, SQLException;
public boolean isBorrowHistory(int uid) throws ClassNotFoundException, SQLException;
public ArrayList<BorrowDetailmodal> getBorrowHistory(int uid) throws SQLException, ClassNotFoundException;
}

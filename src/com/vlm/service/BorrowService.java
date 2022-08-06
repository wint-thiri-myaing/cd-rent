package com.vlm.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vlm.cdmodal.BorrowDetailmodal;
import com.vlm.dao.BorrowReturn;
import com.vlm.dao.BorrowReturnImp;

public class BorrowService {
BorrowReturn br=new BorrowReturnImp();
public void cdborrow(int uid,int id) throws ClassNotFoundException, SQLException{
	br.cdborrow(uid, id);
}
public ArrayList<BorrowDetailmodal> borrowAlbumList(int uid) throws ClassNotFoundException, SQLException{
	return br.borrowAlbumList(uid);
	
}
public void returnProcess(int uid, int bid) throws ClassNotFoundException, SQLException{
	br.returnProcess(uid, bid);
}
public boolean isBorrowHistory(int uid) throws ClassNotFoundException, SQLException {
	return br.isBorrowHistory(uid);

}
public ArrayList<BorrowDetailmodal> getBorrowHistory(int uid) throws SQLException, ClassNotFoundException{
	return br.getBorrowHistory(uid);
	
}

}

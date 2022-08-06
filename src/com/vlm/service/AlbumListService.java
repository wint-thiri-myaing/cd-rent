package com.vlm.service;

import java.sql.SQLException;
import java.util.List;

import com.vlm.cdmodal.AlbumListmodal;
import com.vlm.dao.AlbumList;
import com.vlm.dao.AlbumListImp;

public class AlbumListService {
	AlbumList al=new AlbumListImp();
	public List<AlbumListmodal> getAlbumByCategoryId(int id) throws ClassNotFoundException, SQLException{
		return al.getAlbumByCategoryId(id);
	
	}
}

package com.vlm.service;

import java.sql.SQLException;
import java.util.List;

import com.vlm.cdmodal.Categorymodal;
import com.vlm.dao.SongCategory;
import com.vlm.dao.SongCategoryImp;

public class SongCategoryService {
	SongCategory sc=new SongCategoryImp();
	public List<Categorymodal> getAllCategories() throws ClassNotFoundException, SQLException{
		return sc.getAllCategories();
		
	}
}

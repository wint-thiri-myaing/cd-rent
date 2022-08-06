package com.vlm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.vlm.cdmodal.AlbumListmodal;
import com.vlm.service.AlbumListService;


@WebServlet("/ViewAlbumServlet")
public class ViewAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ViewAlbumServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		AlbumListService es = new AlbumListService();
		
		String sid=request.getParameter("cid");
		int id=Integer.parseInt(sid);
		
		List<AlbumListmodal> e=null;
		
		try {
			e=es.getAlbumByCategoryId(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(sid.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
			rd.forward(request, response);

		}else{
		RequestDispatcher rd = request.getRequestDispatcher("viewalbum.jsp");
		request.setAttribute("album", e);
		rd.forward(request, response);
		}
	}

}

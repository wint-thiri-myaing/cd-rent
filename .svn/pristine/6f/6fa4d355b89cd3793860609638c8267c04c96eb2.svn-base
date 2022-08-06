package com.vlm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vlm.cdmodal.Categorymodal;
import com.vlm.service.SongCategoryService;
import com.vlm.service.UserService;

@WebServlet("/ViewCategoryList")
public class ViewCategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCategoryList() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SongCategoryService es = new SongCategoryService();

		List<Categorymodal> list = new ArrayList<Categorymodal>();
		
		try {
			list = es.getAllCategories();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("category.jsp");

		request.setAttribute("category", list);

		rd.forward(request, response);
		
	}

}

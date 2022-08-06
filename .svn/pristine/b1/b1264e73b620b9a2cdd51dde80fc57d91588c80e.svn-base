package com.vlm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vlm.cdmodal.BorrowDetailmodal;
import com.vlm.service.BorrowService;


@WebServlet("/BackServlet")
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		BorrowService es = new BorrowService();
		ArrayList<BorrowDetailmodal> borrowalbumlist=new ArrayList<BorrowDetailmodal>();
		HttpSession session = request.getSession(false);
		
	
		int uid = 0;
		if (session != null) {
			uid = (int) session.getAttribute("uid");// login ka id ko u chin lo
			
		}
		try {
			borrowalbumlist=es.borrowAlbumList(uid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("borrowlist", borrowalbumlist);
		RequestDispatcher rd = request.getRequestDispatcher("borrow.jsp");

		rd.forward(request, response);

	}

}

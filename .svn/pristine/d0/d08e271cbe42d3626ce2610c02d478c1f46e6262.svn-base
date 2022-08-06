package com.vlm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vlm.cdmodal.BorrowDetailmodal;
import com.vlm.service.BorrowService;

@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		BorrowService es = new BorrowService();
		
		ArrayList<BorrowDetailmodal> borrowalbumlist=new ArrayList<BorrowDetailmodal>();

		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("name");
		int uid = 0;
		if (session != null) {
			uid = (int) session.getAttribute("uid");// login ka id ko u chin lo
		}

		String[] checkboxclick = request.getParameterValues("cleckreturn");//checkbox name
		int count = 0;
		int i = 0;
		if (checkboxclick != null) {
			count = checkboxclick.length;

		}
		for (int a = 0; a < count; a++) {
			int[] myIntArray = Arrays.stream(checkboxclick).mapToInt(Integer::parseInt).toArray();
			try {
				es.returnProcess(uid, myIntArray[a]);
				borrowalbumlist=es.borrowAlbumList(uid);
				//System.out.println("Hello albumid is checkby " + myIntArray[a]);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.setAttribute("message", "Successfully return.");
		request.setAttribute("borrowlist", borrowalbumlist);
		session.setAttribute("name", user);
		RequestDispatcher rd = request.getRequestDispatcher("borrow.jsp");

		rd.forward(request, response);
		
	}

	

}

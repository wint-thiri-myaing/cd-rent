package com.vlm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vlm.cdmodal.Usermodal;
import com.vlm.service.UserService;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		UserService es=new UserService();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		Usermodal u=new Usermodal();
		
		u.setName(name);
		u.setPassword(password);
		
	/*	int people=0;
		try {
			people=es.register(u);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(people>0){
			out.print("Successfully save");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.print("Sorry!");
			request.getRequestDispatcher("register.jsp").include(request, response);

		}
		out.close();
	}*/
	
	boolean valid = false;
	try {
		try {
			valid =es.isValidName(name);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(valid)
			{

				try {
					es.register(u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("errorMessage", "Successfully save!<br>Please Login in<br>");

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("name", name);
				request.setAttribute("password", password);
				request.setAttribute("errorMessage", "This username has already existed!<br><br>");

				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}

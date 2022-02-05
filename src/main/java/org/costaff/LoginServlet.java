package org.costaff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.costaff.service.EmployeeService;

public class LoginServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		if(userName!=null && userName!="" && password!=null && password!=""){
			EmployeeService service=new EmployeeService();
			boolean isValidUser=service.isValidUser(userName, password);
			if(isValidUser){
				HttpSession session=request.getSession();
				session.setAttribute("userName", userName);
				response.sendRedirect("secured/homepage.jsp");
			}else{
				request.setAttribute("message","Invalid username and password");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message","Invalid username and password");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}

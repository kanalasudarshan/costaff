package org.costaff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.costaff.dto.EmployeeDTO;
import org.costaff.service.EmployeeService;

import com.google.gson.Gson;

public class EmployeeServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		EmployeeService service=new EmployeeService();
		List<EmployeeDTO> list=service.getAllEmployees();
		
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(list));
		
	}
}

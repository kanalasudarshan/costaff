package org.costaff;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.costaff.dto.EmployeeDTO;
import org.costaff.service.EmployeeService;

import com.google.gson.Gson;

public class RegisterServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullName=request.getParameter("fullName");
		String userName=request.getParameter("userName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String phoneNumber=request.getParameter("phoneNumber");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		
		EmployeeDTO dto=new EmployeeDTO();
		dto.setFullName(fullName);
		dto.setUserName(userName);
		dto.setEmail(email);
		dto.setPhoneNumber(phoneNumber);
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setCountry(country);
		dto.setState(state);
		dto.setCity(city);
		
		EmployeeService service=new EmployeeService();
		int employeeId=service.insertEmplyee(dto);
		
		Map<String,String> result=new HashMap<>();
		if(employeeId>0){
			result.put("success", "You have registerd successfully");			
		}else{
			result.put("error", "Registraion failed");	
		}
		
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(result));
	}
}

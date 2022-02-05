package org.costaff.service;

import java.util.List;

import org.costaff.dao.EmployeeDao;
import org.costaff.dto.EmployeeDTO;

public class EmployeeService {
	
	public boolean isValidUser(String username,String password){
		EmployeeDao dao=new EmployeeDao();
		return dao.isValidUser(username, password);
	}
	
	public int insertEmplyee(EmployeeDTO dto){
		EmployeeDao dao=new EmployeeDao();
		return dao.insertEmplyee(dto);
	}

	public List<EmployeeDTO> getAllEmployees(){
		EmployeeDao dao=new EmployeeDao();
		return dao.getAllEmployees();
	}
}

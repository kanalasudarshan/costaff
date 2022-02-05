package org.costaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.costaff.dto.EmployeeDTO;
import org.costaff.util.ConnectionUtils;

public class EmployeeDao {
	
	public boolean isValidUser(String username,String password){
		try{
			Connection con=ConnectionUtils.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT count(*) as count FROM b_employee where email_address=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int count =rs.getInt("count");
				if(count>0)
					return true;
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return false;
	}
	
	public int insertEmplyee(EmployeeDTO dto){
		int employeeId=0;
		try{
			Connection con=ConnectionUtils.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO b_employee(fullname,username,email_address,phone,password,country,state,city) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, dto.getFullName());
			ps.setString(2, dto.getUserName());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPhoneNumber());
			ps.setString(5, dto.getPassword());
			ps.setString(6, dto.getCountry());
			ps.setString(7, dto.getState());
			ps.setString(8, dto.getCity());			
			
			employeeId=ps.executeUpdate();		
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return employeeId;
	}
	
	public List<EmployeeDTO> getAllEmployees(){
		List<EmployeeDTO> list=new ArrayList<>();
		try{
			Connection con=ConnectionUtils.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from b_employee");			
			while(rs.next()){
				EmployeeDTO dto=new EmployeeDTO();
				dto.setFullName(rs.getString("fullname"));
				dto.setUserName(rs.getString("username"));
				dto.setPhoneNumber(rs.getString("phone"));
				dto.setEmail(rs.getString("email_address"));
				dto.setCountry(rs.getString("country"));
				dto.setState(rs.getString("state"));
				dto.setCity(rs.getString("city"));
				
				list.add(dto);
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return list;
	}

}

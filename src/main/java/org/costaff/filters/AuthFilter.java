package org.costaff.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
			HttpServletRequest httpRequest=(HttpServletRequest)request;
			HttpServletResponse httpSesponse=(HttpServletResponse)response;
			
			HttpSession sessoin=httpRequest.getSession(false);			
			if(sessoin != null){
				httpSesponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				httpSesponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				httpSesponse.setDateHeader("Expires", 0); // Proxies.
				System.out.println(sessoin.getAttribute("userName")+" is logged In");
				chain.doFilter(request, response);
			}else{
				httpSesponse.sendRedirect("../index.jsp");
			}	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

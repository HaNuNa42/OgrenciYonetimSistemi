package com.modarcsoft.app.security;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@Order(2)
@WebFilter("/RequestResponseLoggingFilter")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RequestResponseLoggingFilter implements Filter {

	private SessionRepository<Session> sessionRepo;

	@Autowired
	public RequestResponseLoggingFilter(SessionRepository Sr) {

		this.sessionRepo = Sr;
	}

	public void recording(String type, String page, String action, int userId, String connectIp) {

	}

	public RequestResponseLoggingFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
			String key=req.getServletPath();
		System.out.println(req.getContextPath() + " () " + req.getMethod() + "   " + req.getServletPath() + "   "
				+ new Date() + "   " + req.getRemoteAddr());
		
//////////////////       herkese açık alanlar       //////////////////////
		if (key.contains("login") 
				||key.contains("logout")
				||key.contains("/css")
				||key.contains("/custom")
				||key.contains("/img")
				||key.contains("/js")
				||key.contains("/lib")
				||key.contains("/scss"))
		{
			chain.doFilter(request, response);
			return;
		}
		

		boolean kontrol = false;
		try {
			if (req.getSession().getAttribute("kullanici") == null) {
				kontrol = false; 
			} else { 
				kontrol = true;
			}
		} catch (Exception e) {
			kontrol = false;
		}

		if (kontrol) { 
			if (key.contains("home")) {
				chain.doFilter(request, response);
				return;
			}
			chain.doFilter(request, response);
			return;
			
		} else {
			res.sendRedirect("login"); 
		}
		

		chain.doFilter(request, response);
	}

	public void recording(HttpServletRequest req, String user) {
		try {

			String s[] = (" " + req.getServletPath() + " ").split("/");
			if (user != null)
				recording(req.getMethod(), s[1], s[2], Integer.parseInt(user), req.getRemoteAddr());// user eklenecek

		} catch (Exception e) {
			System.out.println("hata filter");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

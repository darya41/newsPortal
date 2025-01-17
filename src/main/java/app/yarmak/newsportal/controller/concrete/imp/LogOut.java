package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogOut implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 HttpSession session = request.getSession(false);
			 
			 if (session != null) {
		            session.invalidate();
		     }
			 
			 Cookie[] cookies = request.getCookies(); 
			 if (cookies != null) { 
				 for (Cookie cookie : cookies) { 
					 if ("remember-me".equals(cookie.getName())) { 
						 cookie.setMaxAge(0); 
						 response.addCookie(cookie); 
						 } 
					 }
				 }

		        response.sendRedirect("goController?command=go_to_index_main");
		}	
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
		
	}

}

package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogOut implements Command{

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			 HttpSession session = request.getSession(false);
			 
			 if (session != null) {
		            session.invalidate();
		     }
		        response.sendRedirect("goController?command=go_to_index_main");
		}catch(Exception e) {
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		}
		
	}

}

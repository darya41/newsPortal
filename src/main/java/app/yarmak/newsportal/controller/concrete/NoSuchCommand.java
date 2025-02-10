package app.yarmak.newsportal.controller.concrete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoSuchCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("errorMessage", "Такой страницы или команды нету."); 
		request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		
	}
	
	
	
}

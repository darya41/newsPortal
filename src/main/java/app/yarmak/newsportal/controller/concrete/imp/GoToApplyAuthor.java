package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;


import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToApplyAuthor implements Command {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		// Фильтр аутефикации проверяет права доступа к странице
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/apply_author.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
		
	}

}

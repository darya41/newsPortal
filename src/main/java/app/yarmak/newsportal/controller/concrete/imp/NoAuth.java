package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoAuth  implements Command {
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("errorMessage", "Для просмотра новостей необходимо авторизоваться или зарегестрироваться!!!");
			response.sendRedirect("goController?command=go_to_index_main");
		}
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	}

}

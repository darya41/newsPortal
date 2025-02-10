package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.net.URLEncoder;

import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoAuth  implements Command {
	@SuppressWarnings("deprecation")
	private static final String errorMessage= URLEncoder.encode("Ошибка авторизации. Войдите или зарегистрируйтесь в системе.");
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.sendRedirect("goController?command=go_to_index_main&errorMessage="+errorMessage);
		}
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	}

}

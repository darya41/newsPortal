package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToApplicationSubmit implements Command {

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/application_submit.jsp");
        dispatcher.forward(request, response);
		
	}

}

package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.controller.concrete.Command;

import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoAuth implements Command {

	private final UserService userService = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Auth auth = null;
		try {
			System.out.println("-----------1");
			auth = userService.signIn(login,password);
			System.out.println(auth);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(auth == null) {
			request.setAttribute("authError", "Неправильный логин или пароль!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_auth");
            dispatcher.forward(request, response);
            return;
		}
			HttpSession session = (HttpSession) request.getSession(true);
			session.setAttribute("user", auth);
		System.out.println("User set in session: " + session.getAttribute("user"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_index_main");
		dispatcher.forward(request, response);

		
	}

}

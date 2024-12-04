package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.AuthService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoAuth implements Command {

	private final AuthService authService = ServiceProvider.getInstance().getAuthService();

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Auth auth = null;
		try {
			System.out.println("-----------1");
			auth = authService.signIn(login,password);
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

package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.controller.concrete.Command;

import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoAuth implements Command {

	private final UserService userService = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		System.out.println("dcjbdif");
		String login = request.getParameter("login");
		System.out.println(login);
		String password = request.getParameter("password");
		System.out.println(password);
		
		User user = null;
		try {
			user = userService.signIn(login,password);
			System.out.println(user.toString());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user !=null) {
			HttpSession session = (HttpSession) request.getSession(true);
			session.setAttribute("user", user);
			
			response.sendRedirect("goController?command=go_to_index_main");
		}else {
			request.setAttribute("authError", "Неправильный логин или пароль!");
			System.out.println("authError set: " + request.getAttribute("authError"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/auth.jsp");
            dispatcher.forward(request, response);
		}
		
	}

}

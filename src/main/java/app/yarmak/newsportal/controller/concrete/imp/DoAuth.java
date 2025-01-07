package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.AuthService;
import app.yarmak.newsportal.service.ServiceProvider;
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
			auth = authService.signIn(login,password);
			if(auth == null) {
				String errorMessage = URLEncoder.encode("Неправильный логин или пароль!", 
						StandardCharsets.UTF_8.toString());
                response.sendRedirect("goController?command=go_to_auth&authError=" +
						errorMessage);
	            return;
			}
			
			HttpSession session = (HttpSession) request.getSession(true);
			session.setAttribute("user", auth);
			
			response.sendRedirect("goController?command=go_to_index_main");	
			 
		} catch (ServiceException e) {
			//logging
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		}		
	}

}

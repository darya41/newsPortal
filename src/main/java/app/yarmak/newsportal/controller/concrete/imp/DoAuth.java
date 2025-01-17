package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.AuthService;
import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.util.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/** 
  * Executes the authentication command. 
  */

public class DoAuth implements Command {

	private final AuthService authService = ServiceProvider.getInstance().getAuthService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("remember-me"); 		
		
		try {
			if (Validator.isNullOrEmpty(login)|| Validator.isNullOrEmpty(password)) { 
				String errorMessage = URLEncoder.encode("Логин и пароль должны быть заполнены.", StandardCharsets.UTF_8.toString()); 
				response.sendRedirect("goController?command=go_to_auth&authError=" + errorMessage); 
				return; 
			}
			
			Auth auth = authService.signIn(login,password);			
			if(auth==null) {
				String errorMessage = URLEncoder.encode("Неправильный логин или пароль!",				StandardCharsets.UTF_8.toString());
                response.sendRedirect("goController?command=go_to_auth&authError="+errorMessage);
	            return;
			}
			
			String token = generateToken();
						
			HttpSession session = (HttpSession) request.getSession(true);
			session.setAttribute("user", auth);
			
			if ("on".equals(rememberMe)) {
				auth.setToken(token); 
				authService.registratedToken(auth);
				Cookie tokenCookie = new Cookie("remember-me", token);
				tokenCookie.setMaxAge(60 * 60 * 24); // 1 день 
				response.addCookie(tokenCookie);
			}
								
			response.sendRedirect("goController?command=go_to_index_main");	
			 
		} catch (ServiceException e) {
			//logging
			e.printStackTrace();
			request.setAttribute("errorMessage", "Произошла ошибка в сервисном слое.");
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}	
		catch (Exception e) { 
			// logging 
			e.printStackTrace();
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	}
	
	/**
	 * Generates a secure token.
	 * @return a secure token as a string
	 */
	private String generateToken() { 
		SecureRandom random = new SecureRandom(); 
		byte[] bytes = new byte[24]; 
		random.nextBytes(bytes); 
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes); 
	}
}
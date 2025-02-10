package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.google.protobuf.ServiceException;
import com.google.protobuf.Timestamp;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.AuthService;
import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.util.Validator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Executes the registration command.
 */
public class DoRegistration implements Command{
	private final AuthService authService = ServiceProvider.getInstance().getAuthService();
	ZonedDateTime minskTime = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String confirmPassword = request.getParameter("confirm-password");
	    
	    HttpSession session = request.getSession();
		 session.setAttribute("username", username);
		 session.setAttribute("email", username);
		 		 
	    try {
	    	
	    	if (Validator.isNullOrEmpty(username) || Validator.isNullOrEmpty(email) || 
	    			Validator.isNullOrEmpty(password) || Validator.isNullOrEmpty(confirmPassword)) { 
	    		String errorMessage = "Все поля должны быть заполнены."; 
	    		response.sendRedirect("goController?command=go_to_registration&authError=" + errorMessage); 
	    		return; 
	    	}
	    	
	    	if (!Validator.isValidEmail(email)) { 
	    		String errorMessage ="Некорректный формат электронной почты."; 
	    		response.sendRedirect("goController?command=go_to_registration&authError=" + errorMessage); 
	    		return; 
	    	}
	    	
	    	
		    if (!Validator.arePasswordMatching(password, confirmPassword)) {
		    	String errorMessage = URLEncoder.encode("Пароли не совпадают!", 
						StandardCharsets.UTF_8.toString());
		        response.sendRedirect("goController?command=go_to_registration&authError=" 
						+errorMessage);
		        return;
		    }
		    
		    session.removeAttribute("username");
		    session.removeAttribute("email");
		    
		    Timestamp timestamp = Timestamp.newBuilder()
		    	    .setSeconds(minskTime.toEpochSecond())
		    	    .setNanos(minskTime.getNano()).build();
		    
		    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp( 
		    		timestamp.getSeconds() * 1000);
		    
		    Auth auth = new Auth(0,username,null,"user", email,  sqlTimestamp, "active",null);
		    	

		    if(authService.registrration(auth, password)) {
		    	RequestDispatcher dispatcher = request.getRequestDispatcher(
		    			"goController?command=go_to_auth");
		        dispatcher.forward(request, response); 
		        return;
		    }
		    request.setAttribute("authError", "Пользователь с такой электронной почтой уже есть!");
		    RequestDispatcher dispatcher = request.getRequestDispatcher(
		    		"goController?command=go_to_registration");
	        dispatcher.forward(request, response); 
			
		} catch (ServiceException e) {
			//logging
			request.setAttribute("errorMessage", "Произошла ошибка в сервисном слое.");
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}	
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	      
	}
	

}

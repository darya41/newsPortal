package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.google.protobuf.ServiceException;
import com.google.protobuf.Timestamp;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.AuthService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command{
	private final AuthService authService = ServiceProvider.getInstance().getAuthService();
	ZonedDateTime minskTime = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
	
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String confirmPassword = request.getParameter("confirm-password");
	    if (!password.equals(confirmPassword)) {
	        response.sendRedirect("goController?command=go_to_registration");
	        return;
	    }
	    Timestamp timestamp = Timestamp.newBuilder()
	    	    .setSeconds(minskTime.toEpochSecond())
	    	    .setNanos(minskTime.getNano())
	    	    .build();
	    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp( timestamp.getSeconds() * 1000);
	    Auth user = new Auth(0,username,null,"user", email,  sqlTimestamp, "active");
	    	
	    
	    try {
	    	if(authService.registrration(user, password)) {
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_auth");
	            dispatcher.forward(request, response); 
	            return;
	    	}
	    	request.setAttribute("authError", "Пользователь с такой электронной почтой уже есть!");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_registration");
            dispatcher.forward(request, response); 
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	    
	    
	}

}

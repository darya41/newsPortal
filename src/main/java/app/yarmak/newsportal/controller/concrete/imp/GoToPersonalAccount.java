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

public class GoToPersonalAccount implements Command {

	private final UserService userService = ServiceProvider.getInstance().getUserService();
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
	
		 HttpSession session = request.getSession(false);
		 Integer userId =null;
		 if (session != null) {
			 System.out.println("user Start Personal account------" + session.getAttribute("user"));
		Auth auth = (Auth) session.getAttribute("user");
			 if (auth != null) {
			     userId = auth.getId();
			     System.out.println(userId);
			 } else {
			     System.out.println("User not found in session.");
			 }

	            if (userId != null) {
	                
					try {
						auth = userService.getUserById(userId);
						request.setAttribute("user", auth);
					} catch (ServiceException e) {
						
					}
	  
	            }
		 }		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/personal_account.jsp");
		dispatcher.forward(request, response);
		
	}

}

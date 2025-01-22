package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.dao.DaoException;
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
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session = request.getSession(false);
	        Integer userId = null;
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
	                
	                User user = null;
	                try {
	                    auth = userService.getUserById(userId);
	                    request.setAttribute("user", auth);
	                    try {
	                        user = userService.getUserDetailById(userId);
	                        System.out.println("User detail/n      ------- " + user);
	                        
	                        if (user != null) {
	                            System.out.println("User detail ррррррррр/n      ------- " + user);
	                            request.setAttribute("userDetail", user);
	                            session.setAttribute("userDetail", user); // Добавляем атрибут в сессию
	                        }
	                    } catch (DaoException e) {
	                        e.printStackTrace();
	                    }
	                    
	                } catch (ServiceException e) {
	                    e.printStackTrace();
	                }
	  
	            }
	        }       
	  
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/personal_account.jsp");
	        dispatcher.forward(request, response);
		}
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
        
    }

}

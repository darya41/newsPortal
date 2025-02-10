package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.bean.AuthorApply;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.util.Validator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoApplyAuthor implements Command{
	/**
	 * Executes the author application command.
	 */

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 String password = request.getParameter("password");
		 String confirmPassword = request.getParameter("confirm-password");
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String email = request.getParameter("email");
		 String bio = request.getParameter("bio");
		 String specialization = request.getParameter("specialization");
		 String workExamples = request.getParameter("workExamples");
		 String phone = request.getParameter("phone");
		 String socialLinks = request.getParameter("socialLinks");

		 if (Validator.isNullOrEmpty(socialLinks) || Validator.isNullOrEmpty(password) 
				 || Validator.isNullOrEmpty(confirmPassword) || Validator.isNullOrEmpty(firstName) 
				 || Validator.isNullOrEmpty(lastName) || Validator.isNullOrEmpty(email)
				 || Validator.isNullOrEmpty(bio) || Validator.isNullOrEmpty(specialization) 
				 || Validator.isNullOrEmpty(workExamples) || Validator.isNullOrEmpty(phone)) {
			 request.setAttribute("authError", "Все поля должны быть заполнены."); 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_apply_author"); 
			 dispatcher.forward(request, response); 
			 return; 
		}
		 
		if (!Validator.arePasswordMatching(password, confirmPassword)) { 
			request.setAttribute("authError", "Пароль не совпадает."); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_apply_author"); 
			dispatcher.forward(request, response); 
			return; 
		}
		
		 AuthorApply authorApply = new AuthorApply(firstName,lastName,email,bio,
				 specialization,workExamples,phone,socialLinks);
		 
	        // Продолжение обработки заявки
	     
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/application_submit.jsp");
		dispatcher.forward(request, response);
	}
}
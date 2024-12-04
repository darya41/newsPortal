package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.bean.AuthorApply;
import app.yarmak.newsportal.controller.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoApplyAuthor implements Command{

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
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

		 AuthorApply authorApply = new AuthorApply(firstName,lastName,email,bio,
				 specialization,workExamples,phone,socialLinks);
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("authorApply", authorApply);


	        if (!password.equals(confirmPassword)) {
	            request.setAttribute("authError", "Пароль не совпадает!!!");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("goController?command=go_to_apply_author");
	            dispatcher.forward(request, response);
	            return;
	        }

	        session.removeAttribute("authorApply");

	        // Продолжение обработки заявки
	    }
}



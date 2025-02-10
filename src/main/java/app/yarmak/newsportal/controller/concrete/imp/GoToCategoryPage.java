package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.util.List;

import app.yarmak.newsportal.bean.Category;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.CategoryService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToCategoryPage implements Command{
	private final CategoryService categoryService = ServiceProvider.getInstance().getCategoryService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Фильтр аутефикации проверяет права доступа к странице
		try {		
			List<Category> categories = categoryService.getAllCategory();
			request.setAttribute("categories", categories);		
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/category.jsp");
			dispatcher.forward(request, response);
			
		}catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}	
	}
}
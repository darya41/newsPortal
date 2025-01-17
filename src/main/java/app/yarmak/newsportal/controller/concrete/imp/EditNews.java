package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.util.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditNews implements Command {
	private final NewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String idStr = request.getParameter("id"); 
			String title = request.getParameter("title"); 
			String brief = request.getParameter("brief"); 
			String content = request.getParameter("content"); 
			String author = request.getParameter("author"); 
			String idCategoryStr = request.getParameter("idCategory"); 
			String priorityStr =request.getParameter("priority"); 
			
			if (Validator.isNullOrEmpty(idStr) || Validator.isNullOrEmpty(title) || Validator.isNullOrEmpty(brief) ||
					Validator.isNullOrEmpty(content) || Validator.isNullOrEmpty(author) 
					|| Validator.isNullOrEmpty(idCategoryStr) || Validator.isNullOrEmpty(priorityStr)) { 
				request.setAttribute("errorMessage", "Все поля должны быть заполнены."); 
				request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
				return; 
			}
			
			if (!Validator.isValidId(idStr) || !Validator.isValidId(idCategoryStr) || !Validator.isValidId(priorityStr)) { 
				request.setAttribute("errorMessage", "Некорректный формат ID."); 
				request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
				return; 
			}
			
			int id = Integer.parseInt(idStr); 
			int idCategory = Integer.parseInt(idCategoryStr); 
			int priority = Integer.parseInt(priorityStr);
			
			News news = new News(id, title, brief, content, author, null, idCategory, 0, priority,"active"); 
			newsService.upDate(news);
			response.sendRedirect("goController?command=go_to_index_main");
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

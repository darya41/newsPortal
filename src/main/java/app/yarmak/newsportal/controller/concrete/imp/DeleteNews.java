package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.util.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteNews implements Command {
	private final NewsService newsService = ServiceProvider.getInstance().getNewsService();
	/**
	 * Executes the delete news.
	 */

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idParameter = request.getParameter("id");
			if (Validator.isNullOrEmpty(idParameter) && Validator.isValidId(idParameter)) {  
				request.setAttribute("errorMessage", "Идентификатор новости не указан."); 
				request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
				return; 
			}
			
			int id = Integer.parseInt(idParameter);
			News news = new News(id, "", "","", "", null, 0, 0, 0,"deleted"); 
			newsService.deleteNews(news);
			response.sendRedirect("goController?command=go_to_index_main");
		}
		catch (Exception e) { 
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
			
	}

}

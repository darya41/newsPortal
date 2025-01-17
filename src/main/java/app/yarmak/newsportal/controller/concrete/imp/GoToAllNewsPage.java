package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAllNewsPage implements Command{
	private final NewsService newsService = ServiceProvider.getInstance().getNewsService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1; 
		int pageSize = 7;
		
		if (request.getParameter("page") != null) { 			
			page = Integer.parseInt(request.getParameter("page")); 
		}
		try { 
			List<News> newsList = newsService.getNewsByPage(page, pageSize); 
			int totalNewsCount = newsService.getTotalNewsCount(); 
			int totalPages = (int) Math.ceil((double) totalNewsCount / pageSize); 

			request.setAttribute("newsList", newsList); 			
			request.setAttribute("currentPage", page); 
			request.setAttribute("totalPages", totalPages); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/all_news.jsp");
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

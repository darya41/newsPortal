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

public class GoToIndexMain implements Command{
	private final NewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Фильтр аутефикации проверяет права доступа к странице
		 List<News> mainNews = null;
	     List<News> latestNews = null;
	     List<News> popularNews = null;
	    
		try {
			
			if (request.getParameter("errorMessage")!=null) {
		    	request.setAttribute("errorMessage", request.getParameter("errorMessage"));	
		    }
			 
			mainNews = newsService.getMainNews();
			latestNews = newsService.getLatestNews();
			popularNews = newsService.getPopularNews();
			request.setAttribute("mainNews", mainNews);			  
	        request.setAttribute("latestNews", latestNews);	      	      			
	        request.setAttribute("popularNews", popularNews);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index_main.jsp");
	        dispatcher.forward(request, response); 
	        
		}catch (ServletException | IOException e ) {
			// logging 
			request.setAttribute("errorMessage", "Ошибка при открытии страницы."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		} catch (Exception e) { 
			
			// logging 
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	}
}
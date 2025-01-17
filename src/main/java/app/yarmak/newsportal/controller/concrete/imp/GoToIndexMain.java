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
		
		 List<News> mainNews = null;
	     List<News> latestNews = null;
	     List<News> popularNews = null;
	     
		try {
			mainNews = newsService.getMainNews();
			latestNews = newsService.getLatestNews();
			popularNews = newsService.getPopularNews();
			request.setAttribute("mainNews", mainNews);			  
	        request.setAttribute("latestNews", latestNews);	      	      			
	        request.setAttribute("popularNews", popularNews);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index_main.jsp");
	        dispatcher.forward(request, response); 
	        
		} catch (ServiceException e) {
			//logging
			e.printStackTrace();
			request.setAttribute("errorMessage", "Произошла ошибка в сервисном слое.");
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}	
		catch (Exception e) { 
			// logging 
			e.printStackTrace();
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	        
	       
			
	        
		
	}

}

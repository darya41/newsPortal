package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.util.ArrayList;
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
import jakarta.servlet.http.HttpSession;

public class GoToIndexMain implements Command{
	private final NewsService provider = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		
		List<News> newsList = new ArrayList<News>();
		
		try {
			newsList = provider.getAllNews();
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
	        
	        List<News> mainNews = null;
	        List<News> latestNews = null;
	        List<News> popularNews = null;
			try {
				mainNews = provider.getMainNews(newsList);
				latestNews = provider.getLatestNews(newsList);
				popularNews = provider.getPopularNews(newsList);
				
			}
				        catch (ServiceException e) {
				e.printStackTrace();
			}
	        request.setAttribute("mainNews", mainNews);
	  
	        request.setAttribute("latestNews", latestNews);
	      	      			
	        request.setAttribute("popularNews", popularNews);
	        HttpSession session = (HttpSession) request.getSession(true);
			System.out.println("User set in session in GoToMainIndex: " + session.getAttribute("user"));

	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index_main.jsp");
	        dispatcher.forward(request, response); 
		
	}

}

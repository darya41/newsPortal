package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToPageNews implements Command{
	private final NewsService newsService = ServiceProvider.getInstance().getNewsService();
	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		
		
		try {
			int idNews = Integer.parseInt(request.getParameter("id"));
			News news = newsService.getNewsById(idNews);
			request.setAttribute("news", news);	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/page_news.jsp");
	        dispatcher.forward(request, response); 
		} catch (ServiceException e) {
			//logging
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		}
		
		
		
	}

}

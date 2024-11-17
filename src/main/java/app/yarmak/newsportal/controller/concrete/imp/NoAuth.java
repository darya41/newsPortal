package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.util.List;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.data.NewsDataLoader;
import app.yarmak.newsportal.service.NewsService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoAuth  implements Command {
	
	private NewsDataLoader newsDataLoader = new NewsDataLoader();
	private NewsService newsService = new NewsService();

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		List<News> newsList = newsDataLoader.loadNews();
        System.out.println("list: " + newsList);
        
        List<News> mainNews = newsService.getMainNews(newsList);
        System.out.println("Main News: " + mainNews);
        request.setAttribute("mainNews", mainNews);

        List<News> latestNews = newsService.getLatestNews(newsList);
        System.out.println("last News: " + latestNews);
        request.setAttribute("latestNews", latestNews);
      
        List<News> popularNews = newsService.getPopularNews(newsList);
        System.out.println("popular News: " + popularNews);
        request.setAttribute("popularNews", popularNews);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index_main.jsp");
        dispatcher.forward(request, response);      
		
	}

}

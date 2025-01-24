package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddNews implements Command {
	
	NewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		try {
			String title = request.getParameter("title");
			String brief = request.getParameter("brief");
			String content = request.getParameter("content");
			
			HttpSession session = request.getSession(false);
			Auth auth= (Auth) session.getAttribute("user");
		
			String author = auth.getUsername()+" "+auth.getLastName();
			Timestamp publicationDate = Timestamp.from(Instant.now());
			int idCategory = Integer.parseInt(request.getParameter("idCategory"));
			String priorityStr = request.getParameter("priority");
			int priority = Integer.parseInt(priorityStr);
			
			News news = new News(0,title,brief,content,author,publicationDate,idCategory,0,priority,"active");
			newsService.addNews(news);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index_main.jsp");
	        dispatcher.forward(request, response);
			
		} catch (ServiceException e) {
			//logging
			System.out.println("-------S1");
			e.printStackTrace();
			request.setAttribute("errorMessage", "Произошла ошибка в сервисном слое.");
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
		}	
		catch (Exception e) { 
			// logging 
			e.printStackTrace();
			System.out.println("-------E1");
			request.setAttribute("errorMessage", "Произошла общая ошибка."); 
			request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response); 
		}
	}

}

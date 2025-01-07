package app.yarmak.newsportal.controller.concrete.imp;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditNews implements Command {
	private final NewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id")); 
			String title = request.getParameter("title"); 
			String brief = request.getParameter("brief"); 
			String content = request.getParameter("content"); 
			String author = request.getParameter("author"); 
			int idCategory = Integer.parseInt(request.getParameter("idCategory")); 
			int priority = Integer.parseInt(request.getParameter("priority")); 
			News news = new News(id, title, brief, content, author, null, idCategory, 0, priority,"active"); 
			newsService.upDate(news);
			response.sendRedirect("goController?command=go_to_index_main");
		} catch (ServiceException e) {
			//logging
			response.sendRedirect("WEB-INF/jsp/error.jsp");
		} 
		
		
	}

}

package app.yarmak.newsportal.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import app.yarmak.newsportal.controller.concrete.Command;
import app.yarmak.newsportal.controller.concrete.CommandProvider;
import app.yarmak.newsportal.jdbc.ConnectionPool;
import app.yarmak.newsportal.jdbc.ConnectionPoolException;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CommandProvider provider = new CommandProvider();
	
	@Override 
	public void init() throws ServletException { 
		super.init(); 
		try { 
			ConnectionPool.getInstance().initPoolData(); 
		} catch (ConnectionPoolException e) { 
			throw new ServletException("Failed to initialize connection pool", e); 
			} 
	}
	@Override
	public void destroy() { 
		super.destroy(); 
		ConnectionPool.getInstance().dispose(); 
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userCommand = request.getParameter("command");
		Command command = provider.takeCommand(userCommand);
		command.execute(response, request);
	}

}
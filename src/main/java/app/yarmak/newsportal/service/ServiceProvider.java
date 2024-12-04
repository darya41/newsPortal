package app.yarmak.newsportal.service;

import app.yarmak.newsportal.service.impl.AuthServiceImpl;
import app.yarmak.newsportal.service.impl.NewsServiceImpl;
import app.yarmak.newsportal.service.impl.UserServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private final UserService userService = new UserServiceImpl();
	private final NewsService newsService = new NewsServiceImpl();
	private final AuthService authService = new AuthServiceImpl();
	
	private ServiceProvider() {
		
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public NewsService getNewsService() {
		return newsService;
	}
	public AuthService getAuthService() {
		return authService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
	
	

}

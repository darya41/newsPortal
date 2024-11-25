package app.yarmak.newsportal.service;

import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;

public interface NewsService {
	List<News> getAllNews() throws ServiceException;
	List<News> getMainNews(List<News> newsList) throws ServiceException;
	List<News> getLatestNews(List<News> newsList) throws ServiceException;
	List<News> getPopularNews(List<News> newsList) throws ServiceException;
	

}

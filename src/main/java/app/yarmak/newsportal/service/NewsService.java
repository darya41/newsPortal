package app.yarmak.newsportal.service;

import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;

public interface NewsService {
	List<News> getAllNews() throws ServiceException;
	List<News> getMainNews() throws ServiceException;
	List<News> getLatestNews() throws ServiceException;
	List<News> getPopularNews() throws ServiceException;
	News getNewsById(int id) throws ServiceException;
	void upDate(News news) throws ServiceException;
	int getTotalNewsCount()throws ServiceException;
	List<News> getNewsByPage(int page, int pageSize) throws ServiceException;
	void deleteNews(News news) throws ServiceException;
	void AddNewView(News news) throws ServiceException;

}

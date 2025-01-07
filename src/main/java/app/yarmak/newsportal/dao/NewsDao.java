package app.yarmak.newsportal.dao;

import java.util.List;

import app.yarmak.newsportal.bean.News;

public interface NewsDao {
	
	void add(News news) throws DaoException;
	News findById(int id) throws DaoException;
	void upDate(News news) throws DaoException;
	void delete(News news) throws DaoException;
	List<News> findAll() throws DaoException;
	List<News> findMainNews () throws DaoException;
	List<News> findLatestNews () throws DaoException;
	List<News> findPopularNews () throws DaoException;
	int getTotalNewsCount() throws DaoException;
	List<News> getNewsByPage(int page, int pageSize)  throws DaoException;
	void deleteNews(News news) throws DaoException;
	void AddNewView(News news) throws DaoException;
	

}

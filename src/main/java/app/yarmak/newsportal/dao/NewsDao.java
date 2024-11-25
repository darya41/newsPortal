package app.yarmak.newsportal.dao;

import java.util.List;

import app.yarmak.newsportal.bean.News;

public interface NewsDao {
	
	void add(News news) throws DaoException;
	News findById(int id) throws DaoException;
	void upDate(News news) throws DaoException;
	void delete(News news) throws DaoException;
	List<News> findAll() throws DaoException;
	

}

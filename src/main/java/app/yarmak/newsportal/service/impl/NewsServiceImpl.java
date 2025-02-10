package app.yarmak.newsportal.service.impl;

import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.service.NewsService;

public class NewsServiceImpl implements NewsService{

	private final NewsDao newsDao = DaoProvider.getInstance().getNewsDao();
	@Override
	public List<News> getAllNews() throws ServiceException {		
		try {
			return newsDao.findAll();
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve all news",e);
		}
	}
	
	@Override
	public List<News> getMainNews() throws ServiceException {
		try {
			return newsDao.findMainNews();
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve main news",e);
		}
	}

	@Override
	public List<News> getLatestNews() throws ServiceException {
		try {
			return newsDao.findLatestNews();
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve latest news",e);
		}
	}

	@Override
	public List<News> getPopularNews() throws ServiceException {
		try {
			return newsDao.findPopularNews();
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve popular news",e);
		}
	}

	@Override
	public News getNewsById(int id) throws ServiceException {
		try {
			return newsDao.findById(id);
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news by ID",e);
		}
	}

	@Override
	public void upDate(News news) throws ServiceException {
		try {
			newsDao.upDate(news);
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to update news",e);
		}	
	}

	@Override
	public int getTotalNewsCount() throws ServiceException {
		try {
			return newsDao.getTotalNewsCount();
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve total news count",e);
		}
	}

	@Override
	public List<News> getNewsByPage(int page, int pageSize) throws ServiceException {
		try {
			return newsDao.getNewsByPage(page,pageSize);
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news by page",e);
		}
	}

	@Override
	public void deleteNews(News news) throws ServiceException {
		try {
			newsDao.deleteNews(news);
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to delete news",e);
		}	
	}

	@Override
	public void addNewView(News news) throws ServiceException {
		try {
			newsDao.AddNewView(news);
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to add new view to news",e);
		}	
	}

	@Override
	public void addNews(News news) throws ServiceException  {
		try {
			newsDao.add(news);
			
		} catch (DaoException e) {
			//logging
			throw new ServiceException("Failed to add news",e);	       
		}		
	}

	@Override
	public List<News> searchNews(String query,int page, int pageSize) throws ServiceException {
		try {
			return newsDao.searchNews(query,page, pageSize);
			
		} catch (DaoException e) {
			//logging
			throw new ServiceException("Failed to search news",e);	       
		}		
	}

	@Override
	public int getTotalSeachNewsResult(String query) throws ServiceException {
		try {
			return newsDao.getTotalSeachNewsResult(query);
			
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve total search news result",e);
		}
	}
}
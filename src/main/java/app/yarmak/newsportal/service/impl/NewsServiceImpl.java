package app.yarmak.newsportal.service.impl;

import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceExeption;

public class NewsServiceImpl implements NewsService{

	private final NewsDao newsDao = DaoProvider.getInstance().getNewsDao();
	@Override
	public List<News> getAllNews() throws ServiceException {
		
		try {
			return newsDao.findAll();
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}
	
	@Override
	public List<News> getMainNews() throws ServiceException {
		try {
			return newsDao.findMainNews();
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}

	@Override
	public List<News> getLatestNews() throws ServiceException {
		try {
			return newsDao.findLatestNews();
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}

	@Override
	public List<News> getPopularNews() throws ServiceException {
		try {
			return newsDao.findPopularNews();
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}

	@Override
	public News getNewsById(int id) throws ServiceException {
		try {
			if (id <= 0) { 
				throw new ServiceException("Invalid news ID"); 
			}
			
			return newsDao.findById(id);
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}


	@Override
	public void upDate(News news) throws ServiceException {
		try {
			if (news == null || news.getId() <= 0) { 
				throw new ServiceException("Invalid news data"); 
			}
			
			newsDao.upDate(news);
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
		
	}


	@Override
	public int getTotalNewsCount() throws ServiceException {
		try {
			return newsDao.getTotalNewsCount();
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}


	@Override
	public List<News> getNewsByPage(int page, int pageSize) throws ServiceException {
		try {
			if (page <= 0 || pageSize <= 0) { 
				throw new ServiceException("Invalid page or page size"); 
			}
			
			return newsDao.getNewsByPage(page,pageSize);
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
	}


	@Override
	public void deleteNews(News news) throws ServiceException {
		try {
			
			if (news == null || news.getId() <= 0) { 
				
				throw new ServiceException("Invalid news data"); 
				
			}
			
			newsDao.deleteNews(news);
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
		
	}


	@Override
	public void AddNewView(News news) throws ServiceException {
		try {
			
			if (news == null || news.getId() <= 0) { 
				
				
				throw new ServiceException("Invalid news data"); 
			}
			
			newsDao.AddNewView(news);
		} catch (DaoException e) {
			//logging
	        throw new ServiceException("Failed to retrieve news");
		}
		
	}

	@Override
	public void AddNews(News news) throws ServiceException  {
		try {
			System.out.println("-------A1");
			newsDao.add(news);
			System.out.println("-------A2");
		} catch (DaoException e) {
			//logging
			System.out.println("-------AExeption1");
			throw new ServiceException("Failed to retrieve news");
	       
		}
		
	}

}

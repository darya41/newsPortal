package app.yarmak.newsportal.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.service.NewsService;

public class NewsServiceImpl implements NewsService{

	private final NewsDao provider = DaoProvider.getInstance().getNewsDao();
	@Override
	public List<News> getAllNews() throws ServiceException {
		
		try {
			return provider.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
	        throw new ServiceException("Failed to retrieve news", e);
		}
	}

	@Override
	public List<News> getMainNews(List<News> newsList) throws ServiceException {
		 	Collections.sort(newsList, News.compareByMain());
	        return new ArrayList<>(newsList.subList(0, Math.min(6, newsList.size())));
	}

	@Override
	public List<News> getLatestNews(List<News> newsList) throws ServiceException {
		 Collections.sort(newsList, News.compareByDate());
	        return new ArrayList<>(newsList.subList(0, Math.min(4, newsList.size())));
	}

	@Override
	public List<News> getPopularNews(List<News> newsList) throws ServiceException {
		  Collections.sort(newsList, News.compareByViews());
	        return new ArrayList<>(newsList.subList(0, Math.min(4, newsList.size())));
	}

}

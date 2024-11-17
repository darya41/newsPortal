package app.yarmak.newsportal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.yarmak.newsportal.bean.News;

public class NewsService {
	 public List<News> getMainNews(List<News> newsList) {	       
	        Collections.sort(newsList, News.compareByMain());
	        return new ArrayList<>(newsList.subList(0, Math.min(6, newsList.size())));
	    }

	    public List<News> getLatestNews(List<News> newsList) {	       
	        Collections.sort(newsList, News.compareByDate());
	        return new ArrayList<>(newsList.subList(0, Math.min(4, newsList.size())));
	    }

	    public List<News> getPopularNews(List<News> newsList) {
	        Collections.sort(newsList, News.compareByViews());
	        return new ArrayList<>(newsList.subList(0, Math.min(4, newsList.size())));
	    }
}

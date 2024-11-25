package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.NewsDao;

public class SQLNewsDao implements NewsDao{

	@Override
	public void add(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public News findById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upDate(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void delete(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> findAll() throws DaoException {
		List<News> newsList = new ArrayList<>();
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");
		    
		    Statement st = con.createStatement();
		   
		    String query = "SELECT * FROM news;";
		    ResultSet rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    
		    while (rs.next()) {
		        int id = rs.getInt("Id");
		        String title = rs.getString("title");
		        String brief = rs.getString("brief");
		        String content = rs.getString("content");
		        String author = rs.getString("author");
		        java.sql.Timestamp publicationDate = rs.getTimestamp("publicationDate");
		        int idCategory = rs.getInt("idCategory");
		        int views = rs.getInt("views");
		        int priority = rs.getInt("priority");

		        News news = new News(id, title, brief, content, author, publicationDate, idCategory, views, priority);
		        newsList.add(news);		     
		    }		   
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			e.printStackTrace();
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return newsList;
	}

}

package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		News news = null ;
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");		    
		    Statement st = con.createStatement();
		   
		    String query = "SELECT * FROM news WHERE id = ?"; 
		    PreparedStatement ps = con.prepareStatement(query); 
		    ps.setInt(1, id); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) 
		    { news = createNewsFromResultSet(rs); }
			   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}
		return news;
	}

	@Override
	public void upDate(News news) throws DaoException {

		    
	
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");
	        String query = "UPDATE news SET title = ?, brief = ?, content = ?, author = ?, idCategory = ?, priority = ? WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, news.getTitle());
	        ps.setString(2, news.getBrief());
	        ps.setString(3, news.getContent());
	        ps.setString(4, news.getAuthor());
	        ps.setInt(5, news.getCategory());
	        ps.setInt(6, news.getPriority());
	        ps.setInt(7, news.getId());
	        ps.executeUpdate();
	    } catch (ClassNotFoundException e) {
	        // logging
	        System.out.println("MySQL Driver not found.");
	    } catch (SQLException e) {
	        // logging
	        System.out.println("Failed to update news: " + e.getMessage());
	    
	    }

	}
	

	@Override
	public void delete(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	public List<News> findMainNews () throws DaoException{
		List<News> newsList = new ArrayList<>();
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");		    
		    Statement st = con.createStatement();
		   
		    String query = "SELECT * FROM news ORDER BY priority DESC LIMIT 6;";
		    ResultSet rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return newsList;
	}
	
	public List<News> findLatestNews () throws DaoException{
		List<News> newsList = new ArrayList<>();
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");		    
		    Statement st = con.createStatement();
		   
		    String query = "SELECT * FROM news ORDER BY views DESC LIMIT 4;";
		    ResultSet rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return newsList;
	}
	
	public List<News> findPopularNews () throws DaoException{
		List<News> newsList = new ArrayList<>();
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");		    
		    Statement st = con.createStatement();
		   
		    String query = "SELECT * FROM news ORDER BY publicationDate DESC LIMIT 4;";
		    ResultSet rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return newsList;
	}
	
	private News createNewsFromResultSet(ResultSet rs) throws SQLException { 
		int id = rs.getInt("Id"); 
		String title = rs.getString("title"); 
		String brief = rs.getString("brief"); 
		String content = rs.getString("content"); 
		String author = rs.getString("author"); 
		java.sql.Timestamp publicationDate = rs.getTimestamp("publicationDate"); 
		int idCategory = rs.getInt("idCategory"); 
		int views = rs.getInt("views"); 
		int priority = rs.getInt("priority"); 
		
		return new News(id, title, brief, content, author, publicationDate, idCategory, views, priority,"active"); 
		
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

		        News news = new News(id, title, brief, content, author, publicationDate, idCategory, views, priority,"active");
		        newsList.add(news);		     
		    }		   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return newsList;
	}

	@Override
	public int getTotalNewsCount() throws DaoException {
		 int count=0;	
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");
		    
		    Statement st = con.createStatement();
		  
		    String query = "SELECT COUNT(*) FROM news";
		    ResultSet rs = st.executeQuery(query);
		    if (rs.next()) { 
		    	count = rs.getInt(1);
		    }
		    
		       
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}
		return count;
	}

	@Override
	public List<News> getNewsByPage(int page, int pageSize) throws DaoException {
		List<News> newsList = new ArrayList<>();
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234"); 
		    String query = "SELECT * FROM news ORDER BY priority DESC LIMIT ? OFFSET ?"; 
		    PreparedStatement ps = con.prepareStatement(query); 
		    ps.setInt(1, pageSize); 
		    ps.setInt(2, (page - 1) * pageSize); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return newsList;
	}

}

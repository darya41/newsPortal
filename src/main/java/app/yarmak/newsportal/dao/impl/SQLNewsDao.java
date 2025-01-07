package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.jdbc.ConnectionPool;
import app.yarmak.newsportal.jdbc.ConnectionPoolException;

public class SQLNewsDao implements NewsDao{

	ConnectionPool connectionPool = ConnectionPool.getInstance();
	@Override
	public void add(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public News findById(int id) throws DaoException {
		News news = null ;
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
		    con = connectionPool.takeConnection();
		    String query = "SELECT * FROM news WHERE id = ?"; 
		    ps = con.prepareStatement(query); 
		    ps.setInt(1, id); 
		    rs = ps.executeQuery();
		    if (rs.next()) 
		    { 
		    	news = createNewsFromResultSet(rs);
		    }
			   
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps, rs); 
		}
		return news;
	}

	@Override
	public void upDate(News news) throws DaoException {

		Connection con = null; 
		PreparedStatement ps = null; 
	
		    
	    try {
	        
	        con = connectionPool.takeConnection();
	        String query = "UPDATE news SET title = ?, brief = ?, content = ?, author = ?, idCategory = ?, priority = ? WHERE id = ?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, news.getTitle());
	        ps.setString(2, news.getBrief());
	        ps.setString(3, news.getContent());
	        ps.setString(4, news.getAuthor());
	        ps.setInt(5, news.getCategory());
	        ps.setInt(6, news.getPriority());
	        ps.setInt(7, news.getId());
	        ps.executeUpdate();
	    } catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}
	    finally {
	    	connectionPool.closeConnection(con, ps); 
	    	}
	}
	
	public void AddNewView(News news) throws DaoException {

		Connection con = null; 
		PreparedStatement ps = null; 
		    
	    try {
	        
	        con = connectionPool.takeConnection();
	        String query = "UPDATE news SET views=? WHERE id = ?";
	        ps = con.prepareStatement(query);
	        ps.setInt(1, news.getViews()+1);
	        ps.setInt(2, news.getId());
	        ps.executeUpdate();
	    } catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}
	    finally {
	    	connectionPool.closeConnection(con, ps); 
	    	}
	}
	
	public void deleteNews(News news) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
	
		    
	    try {
	        
	        con = connectionPool.takeConnection();
	        String query = "UPDATE news SET statusNews=? WHERE id = ?";
	        ps = con.prepareStatement(query);
	        ps.setString(1, news.getStatus());	       
	        ps.setInt(2, news.getId());
	        ps.executeUpdate();
	    } catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}
	    finally {
	    	connectionPool.closeConnection(con, ps); 
	    	}
		
	}
	

	@Override
	public void delete(News news) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	public List<News> findMainNews () throws DaoException{
		List<News> newsList = new ArrayList<>();
		Connection con = null; 
		Statement st = null;
		ResultSet rs = null;
		try {
		    
		    
		    	   
		    con = connectionPool.takeConnection();    
		    st = con.createStatement();
		   
		    String query = "SELECT * FROM news WHERE statusNews = 'active' ORDER BY priority DESC LIMIT 6;";

		    rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		}  catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, st, rs); 
			}

		return newsList;
	}
	
	public List<News> findLatestNews () throws DaoException{
		List<News> newsList = new ArrayList<>();
		Connection con = null; 
		Statement st = null;
		ResultSet rs = null;
		try {
		    
		    
		    con =connectionPool.takeConnection();	    
		    st = con.createStatement();
		   
		    String query = "SELECT * FROM news WHERE statusNews = 'active' ORDER BY views DESC LIMIT 4;";
		    rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, st, rs); 
			}

		return newsList;
	}
	
	public List<News> findPopularNews () throws DaoException{
		List<News> newsList = new ArrayList<>();
		Connection con = null; 
		Statement st = null;
		ResultSet rs = null;
		try {
		    	   
		    con = connectionPool.takeConnection();	    
		   st = con.createStatement();
		   
		    String query = "SELECT * FROM news WHERE statusNews = 'active' ORDER BY publicationDate DESC LIMIT 4;";
		    rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		}
		catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}
		finally { 
			connectionPool.closeConnection(con, st, rs); 
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
		Connection con = null; 
		Statement st = null;
		ResultSet rs = null;
		try {
		    
		   
		   con = connectionPool.takeConnection();
		    st = con.createStatement();
		   
		    String query = "SELECT * FROM news WHERE statusNews = 'active';";
		    rs = st.executeQuery(query);
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
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, st, rs); 
			}

		return newsList;
	}

	@Override
	public int getTotalNewsCount() throws DaoException {
		 int count=0;	
		 Connection con = null; 
		 Statement st =null;
		ResultSet rs = null;
		try {
		    
		   
		   con = connectionPool.takeConnection();
		     st = con.createStatement();
		  
		    String query = "SELECT COUNT(*) FROM news WHERE statusNews = 'active'";
		    rs = st.executeQuery(query);
		    if (rs.next()) { 
		    	count = rs.getInt(1);
		    }
		    
		       
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, st, rs); 
			}
		return count;
	}

	@Override
	public List<News> getNewsByPage(int page, int pageSize) throws DaoException {
		List<News> newsList = new ArrayList<>();
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
		    
		    	   
		    con = connectionPool.takeConnection();
		    String query = "SELECT * FROM news WHERE statusNews = 'active' ORDER BY priority DESC LIMIT ? OFFSET ?"; 
		    ps = con.prepareStatement(query); 
		    ps.setInt(1, pageSize); 
		    ps.setInt(2, (page - 1) * pageSize); 
		    rs = ps.executeQuery();
		    while (rs.next()) {
		    	
		    	News news = createNewsFromResultSet(rs);
		        newsList.add(news);		     
		    }
			   
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps, rs); 
			}

		return newsList;
	}

}

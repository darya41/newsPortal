package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import app.yarmak.newsportal.bean.News;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.dao.jdbc.ConnectionPool;
import app.yarmak.newsportal.dao.jdbc.ConnectionPoolException;

public class SQLNewsDao implements NewsDao{

	private final ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	
	private static final String QUERY_ADD_NEWS = "INSERT INTO news (title, brief, content, author,publicationDate, idCategory, views,priority, statusNews) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
	@Override
	public void add(News news) throws DaoException {
		
		//Конструкция try-with-resources, автоматически закрывает ресурсы
		
		try (Connection con =  connectionPool.takeConnection();	
				PreparedStatement ps = con.prepareStatement(QUERY_ADD_NEWS);) {

	        ps.setString(1, news.getTitle());
	        ps.setString(2, news.getBrief());
	        ps.setString(3, news.getContent());
	        ps.setString(4, news.getAuthor());
	        ps.setDate(5, new Date(news.getPublicationDate().getTime())); 
	        ps.setInt(6, news.getCategory()); 
	        ps.setInt(7, news.getViews()); 
	        ps.setInt(8, news.getPriority());
	        ps.setString(9, news.getStatus());
	      
	        ps.executeUpdate();
	        			   
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}		
	}

	private static final String QUERY_FIND_BY_ID = "SELECT * FROM news WHERE id = ?";
	
	@Override
	public News findById(int id) throws DaoException {
		
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
		    con = connectionPool.takeConnection();
		    ps = con.prepareStatement(QUERY_FIND_BY_ID);
		    
		    ps.setInt(1, id); 		
		    rs = ps.executeQuery();
		    
		    if (rs.next()) 
		    { 
		    	return createNewsFromResultSet(rs);
		    }
			   
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps, rs); 
		}
		return null;
	}

	private static final String QUERY_UPDATE = "UPDATE news SET title = ?, brief = ?, content = ?, author = ?, idCategory = ?, priority = ? WHERE id = ?";
	
	@Override
	public void upDate(News news) throws DaoException {
			    
	    try(Connection con = connectionPool.takeConnection();
	    		PreparedStatement ps =con.prepareStatement(QUERY_UPDATE); ) {	        
	        
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
	}
	
	private static final String QUERY_ADD_NEW_VIEW = "UPDATE news SET views=? WHERE id = ?";
	
	public void AddNewView(News news) throws DaoException {
		    
		 try(Connection con = connectionPool.takeConnection();
		    		PreparedStatement ps =con.prepareStatement(QUERY_ADD_NEW_VIEW); ) {	        
	       	        
	        ps.setInt(1, news.getViews()+1);
	        ps.setInt(2, news.getId());
	        
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}
	}
	
	private static final String QUERY_DELETE_NEWS = "UPDATE news SET statusNews=? WHERE id = ?";
	
	public void deleteNews(News news) throws DaoException {
			    
	    try (Connection con = connectionPool.takeConnection();
	    		PreparedStatement ps =con.prepareStatement(QUERY_DELETE_NEWS); )  {
	        	       
	        ps.setString(1, news.getStatus());	       
	        ps.setInt(2, news.getId());
	        
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}		
	}
	
	private static final String QUARY_FIND_MAIN_NEWS = "SELECT * FROM news WHERE statusNews = 'active' ORDER BY priority DESC LIMIT 6;";
	
	@Override
	public List<News> findMainNews () throws DaoException{
		return findNews(QUARY_FIND_MAIN_NEWS);
	}
	
	private static final String QUARY_FIND_LATEST_NEWS ="SELECT * FROM news WHERE statusNews = 'active' ORDER BY views DESC LIMIT 4;";
	
	@Override
	public List<News> findLatestNews () throws DaoException{
		return findNews(QUARY_FIND_LATEST_NEWS);
	}
	
	private static final String QUARY_FIND_POPULAR_NEWS ="SELECT * FROM news WHERE statusNews = 'active' ORDER BY publicationDate DESC LIMIT 4;";
	
	@Override
	public List<News> findPopularNews () throws DaoException{
		 return findNews(QUARY_FIND_POPULAR_NEWS);
	}
	
	private static final String QUARY_ALL_NEWS = "SELECT * FROM news WHERE statusNews = 'active';"; 
	
	@Override
	public List<News> findAll() throws DaoException {
		return findNews(QUARY_ALL_NEWS);
	}
	
	private List<News> findNews(String query) throws DaoException {
	    List<News> newsList = new ArrayList<>();
	    Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
	    try  {
	    	 con = connectionPool.takeConnection();	    	
		     ps = con.prepareStatement(query);
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
	
	private News createNewsFromResultSet(ResultSet rs) throws SQLException { 
		int id = rs.getInt("Id"); 
		String title = rs.getString("title"); 
		String brief = rs.getString("brief"); 
		String content = rs.getString("content"); 
		String author = rs.getString("author"); 
		Timestamp publicationDate = rs.getTimestamp("publicationDate"); 
		int idCategory = rs.getInt("idCategory"); 
		int views = rs.getInt("views"); 
		int priority = rs.getInt("priority"); 
		
		return new News(id, title, brief, content, author, publicationDate, idCategory, views, priority,"active"); 		
	}
	
	private static final String QUARY_GET_NEWS_BY_PAGE =  "SELECT * FROM news WHERE statusNews = 'active' ORDER BY priority DESC LIMIT ? OFFSET ?";

	@Override
	public List<News> getNewsByPage(int page, int pageSize) throws DaoException {
		List<News> newsList = new ArrayList<>();
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			
		    con = connectionPool.takeConnection();
		    ps = con.prepareStatement(QUARY_GET_NEWS_BY_PAGE); 
		    
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

	private static final String QUERY_GET_SEARCH_RESULTS = "SELECT * FROM news WHERE LOWER(title) LIKE ? OR LOWER(brief) LIKE ? LIMIT ? OFFSET ?;"; // Без ORDER BY
	   
	@Override
	public List<News> searchNews(String query, int page, int pageSize) throws DaoException {
	    List<News> newsList = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	    	
	        int offset = (page - 1) * pageSize;

	        con = connectionPool.takeConnection();
	        ps = con.prepareStatement(QUERY_GET_SEARCH_RESULTS);

	        String searchQuery = "%" + query.toLowerCase() + "%";
	        ps.setString(1, searchQuery);
	        ps.setString(2, searchQuery);

	        ps.setInt(3, pageSize);
	        ps.setInt(4, offset);

	        rs = ps.executeQuery();

	        while (rs.next()) {	            
	            News news = createNewsFromResultSet(rs);
	            newsList.add(news);
	        }

	    } catch (SQLException e) {	    	
	        throw new DaoException("Ошибка в работе с данными", e);	        
	    } catch (ConnectionPoolException e) {
	        throw new DaoException("Ошибка в работе с пулом соединений", e);
	    } finally {
	        connectionPool.closeConnection(con, ps, rs);
	    }

	    return newsList;
	}
	
	private static final String QUARY_GET_TOTAL_NEWS ="SELECT COUNT(*) FROM news WHERE statusNews = 'active'";
	
	@Override
	public int getTotalNewsCount() throws DaoException {
		 Connection con = null; 
		 Statement st =null;
		 ResultSet rs = null;
		 try {		    		   
			 con = connectionPool.takeConnection();
			 st = con.createStatement();		 
			 rs = st.executeQuery(QUARY_GET_TOTAL_NEWS);
		   
			 if (rs.next()) { 
				 return rs.getInt(1);
			 }
			 
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, st, rs); 
			}
		return 0;
	}	

	private static final String QUERY_GET_TOTAL_SEARCH_RESULTS = "SELECT COUNT(*) FROM news WHERE LOWER(title) LIKE ? OR LOWER(brief) LIKE ?";
	
	@Override
	public int getTotalSeachNewsResult(String query) throws DaoException {
		Connection con = null; 
	    PreparedStatement ps = null; 
	    ResultSet rs = null;
		 try {		    		   
			 con = connectionPool.takeConnection();
		        ps = con.prepareStatement(QUERY_GET_TOTAL_SEARCH_RESULTS);
		        
		        String searchQuery = "%" + query.toLowerCase() + "%";
		        ps.setString(1, searchQuery);
		        ps.setString(2, searchQuery);
		        
		        rs = ps.executeQuery(); 
		        if (rs.next()) { 
		        	return rs.getInt(1); 
		        }
			 
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con,ps, rs); 
		}
		return 0;
	}
}
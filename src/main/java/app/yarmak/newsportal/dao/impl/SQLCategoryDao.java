package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.yarmak.newsportal.bean.Category;
import app.yarmak.newsportal.dao.CategoryDao;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.jdbc.ConnectionPool;
import app.yarmak.newsportal.jdbc.ConnectionPoolException;

public class SQLCategoryDao implements CategoryDao {
	ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public List<Category> findAllCategory() throws DaoException  {
		List<Category> categoryList = new ArrayList<>();
		Connection con = null; 
		 Statement st =null;
		ResultSet rs = null;
		try {
		    	   
		    con = connectionPool.takeConnection();
		    st = con.createStatement();
		   
		    String query = "SELECT * FROM categories;";
		  rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	int id = rs.getInt("Id");    
				String title = rs.getString("title"); 
				String description = rs.getString("description"); 
				String imageUrl =null;
				Category category = new Category(id,title,description,imageUrl);
				categoryList.add(category);
				
		    }
			   
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, st, rs); 
			}
		return categoryList;
	}

}

package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.yarmak.newsportal.bean.Category;
import app.yarmak.newsportal.dao.CategoryDao;

public class SQLCategoryDao implements CategoryDao {

	@Override
	public List<Category> findAllCategory() {
		List<Category> categoryList = new ArrayList<>();
		try {
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");		    
		    Statement st = con.createStatement();
		   
		    String query = "SELECT * FROM categories;";
		    ResultSet rs = st.executeQuery(query);
		    System.out.println(rs.toString());
		    while (rs.next()) {
		    	
		    	int id = rs.getInt("Id");    
				String title = rs.getString("title"); 
				String description = rs.getString("description"); 
				String imageUrl =null;
				Category category = new Category(id,title,description,imageUrl);
				categoryList.add(category);
				
		    }
			   
		} catch (ClassNotFoundException e) {
			//logging
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			//logging
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}
		return categoryList;
	}

}

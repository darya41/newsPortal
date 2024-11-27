package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.UserDao;

public class SQLUserDao implements UserDao{

	@Override
	public User registration() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authorization(String email, String password) throws DaoException {
try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC", "root", "Daria1234");
		    
		    Statement st = con.createStatement();
		   
		    String query =  "SELECT * FROM user WHERE login='" + email + "' AND password='" + password + "'";
		    ResultSet rs = st.executeQuery(query);
		    if (rs.next()) {
				
		    	int id = rs.getInt("id");
		    	String lastName = rs.getString("lastName");
		    	String firstName = rs.getString("firstName");
		    	 System.out.println(id+"-------------");
		    	java.sql.Timestamp dateBirth = rs.getTimestamp("dateBirth");;
		    	String role =rs.getString("role");
		    	String phone =rs.getString("phone");
		    	List<Integer> bookmarkedArticles = null;
		    	List<Integer> readingHistory = null;
		    	List<Integer> commentList = null;
		    	List<Integer> likesList = null;
		    	
				return new User (id,lastName,firstName,dateBirth,role,
						email, phone, bookmarkedArticles,readingHistory,commentList,likesList);
				
			}
		    
		    	   
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		    System.out.println("MySQL Driver not found.");
		} catch (SQLException e) {
			e.printStackTrace();
		    System.out.println("Failed to retrieve news: " + e.getMessage());
		}

		return null;
	}

}

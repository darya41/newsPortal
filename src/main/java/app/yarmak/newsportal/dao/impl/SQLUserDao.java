package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.UserDao;

public class SQLUserDao implements UserDao{

	private static final String DB_URL = "jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Daria1234";
    
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean isEmailRegistered(String email) throws DaoException {
		String query = "SELECT COUNT(*) FROM users WHERE email = ?";
	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setString(1, email);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getInt(1) > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public Auth getUserById(int id) throws DaoException{
		 String query = "SELECT * FROM user WHERE id = ?";
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, id);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    
	                    
	                    String lastName =resultSet.getString("lastName");
	                    String userName =resultSet.getString("firstName");  
	                    String role = resultSet.getString("role");	
	                    String email = resultSet.getString("email");
	                    java.sql.Timestamp   registrationDate = resultSet.getTimestamp("registration_date");
	                    String status =resultSet.getString("status");

	                    Auth auth = new Auth(id, lastName, userName, role, email, registrationDate, status);
	                    return auth;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	public User getUserDetailById(int id) throws DaoException {
		String query = "SELECT * FROM newsportalbd.user_details WHERE user_id = ?;";
		System.out.println("Executing query: " + query.replace("?", String.valueOf(id)));

	    System.out.println("------- --------------------1");
	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        System.out.println("------- --------------------2     id=" + id);
	        statement.setInt(1, id);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            System.out.println("------- --------------------3" );
	            if (resultSet.next()) {
	                System.out.println("------- --------------------4 Inside if block");
	                java.sql.Timestamp dateBirth = resultSet.getTimestamp("dateBirth");
	                String phone = resultSet.getString("phone");
	                System.out.println("User Daoooo/n      ------- " + id);
	                // Пока что заглушки, в будущем будут новые таблицы
	                List<Integer> bookmarkedArticles = null;
	                List<Integer> readingHistory = null;
	                List<Integer> commentList = null;
	                List<Integer> likesList = null;

	                User user = new User(dateBirth, phone, bookmarkedArticles, readingHistory,
	                        commentList, likesList);
	                System.out.println("User DAo/n      ------- " + user);
	                return user;
	            } else {
	                System.out.println("------- --------------------4 ResultSet is empty");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("SQL Exception: " + e.getMessage());
	    }
	    return null;
	}


	
}

package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.UserDao;

public class SQLUserDao implements UserDao{

	private static final String DB_URL = "jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Daria1234";
    

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
		 String query = "SELECT * FROM users WHERE id = ?";
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, id);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    Auth auth = new Auth(id, query, query, query, query, null, query);
	                    auth.setId(resultSet.getInt("id"));
	                    auth.setLastName(resultSet.getString("lastName"));
	                    auth.setUsername(resultSet.getString("firstName"));  
	                    auth.setRole(resultSet.getString("role"));	
	                    auth.setEmail(resultSet.getString("email"));
	                    java.sql.Timestamp   registrationDate= resultSet.getTimestamp("registration_date");
	                    auth.setRegistrationDate(registrationDate);
	                    auth.setStatus(resultSet.getString("status"));

	                    return auth;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
    
	}
}

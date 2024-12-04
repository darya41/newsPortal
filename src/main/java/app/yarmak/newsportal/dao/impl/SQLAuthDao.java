package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.google.protobuf.Timestamp;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.AuthDao;
import app.yarmak.newsportal.dao.DaoException;

public class SQLAuthDao implements AuthDao {

	private static final String DB_URL = "jdbc:mysql://127.0.0.1/newsportalbd?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Daria1234";
    
	@Override
	public User registration(Auth auth, String password) throws DaoException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "INSERT INTO User (firstName,login, password, role, registration_date, status) VALUES (?, ?, ?, ?, ?, ?)";
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, auth.getUsername());
		        stmt.setString(2, auth.getEmail());
		        stmt.setString(3, password);
		        stmt.setString(4,"user");
		        java.sql.Timestamp protoTimestamp = auth.getRegistrationDate();
	            java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(protoTimestamp.getSeconds() * 1000);
	            stmt.setTimestamp(5, sqlTimestamp);

	            stmt.setString(6, auth.getStatus());
	            stmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Auth authorization(String login, String password) throws DaoException {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    	   
		    Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		    
		    Statement st = con.createStatement();
		   
		    String query =  "SELECT * FROM user WHERE login='" + login + "' AND password='" + password + "'";
		    ResultSet rs = st.executeQuery(query);
		    if (rs.next()) {
				
		    	int id = rs.getInt("id");
		    	String firstName = rs.getString("firstName");
		    	String lastName = rs.getString("lastName");
		    	 System.out.println(id+"-------------");
		    	 java.sql.Timestamp   registrationDate= rs.getTimestamp("registration_date");
		    	String role =rs.getString("role");
		    	String status = rs.getString("status");
		    	
		    	
				return new Auth (id,firstName,lastName,role,login, registrationDate,status);
				
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

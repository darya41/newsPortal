package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.AuthDao;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.jdbc.ConnectionPool;
import app.yarmak.newsportal.jdbc.ConnectionPoolException;

public class SQLAuthDao implements AuthDao {
	
	ConnectionPool connectionPool = ConnectionPool.getInstance();
    
	@Override
	public User registration(Auth auth, String password) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		String query = "INSERT INTO User (firstName,login, password, role, registration_date, status) VALUES (?, ?, ?, ?, ?, ?)";
		try{
			con = connectionPool.takeConnection();
			ps = con.prepareStatement(query); 
		    ps.setString(1, auth.getUsername());
		    ps.setString(2, auth.getEmail());
		    ps.setString(3, password);
		    ps.setString(4,"user");
		    java.sql.Timestamp protoTimestamp = auth.getRegistrationDate();
		    ps.setTimestamp(5, protoTimestamp);

		   ps.setString(6, auth.getStatus());
		   ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps); 
			}
		return null;
	}

	@Override
	public Auth authorization(String login, String password) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
		    	   
		   con = connectionPool.takeConnection();		    
		    
		    String query =  "SELECT * FROM user WHERE login='" + login + "' AND password='" + password + "'";
		    ps = con.prepareStatement(query); 
		    rs = ps.executeQuery(query);
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
		    
		    	   
		}catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps, rs); 
			}

		return null;
	}

}

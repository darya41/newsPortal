package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.AuthDao;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.jdbc.ConnectionPool;
import app.yarmak.newsportal.dao.jdbc.ConnectionPoolException;

public class SQLAuthDao implements AuthDao {
	
	private final ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	private static final String QUERY_REGISTRATION = "INSERT INTO User (firstName, login, password, role, registration_date, status) VALUES (?, ?, ?, ?, ?, ?)";
	@Override
	public User registration(Auth auth, String password) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		
		try{
			con = connectionPool.takeConnection();
			ps = con.prepareStatement(QUERY_REGISTRATION); 
			
		    ps.setString(1, auth.getUsername());
		    ps.setString(2, auth.getEmail());
		    ps.setString(3, password);
		    ps.setString(4,"user");
		    java.sql.Timestamp protoTimestamp = auth.getRegistrationDate();
		    ps.setTimestamp(5, protoTimestamp);
		    ps.setString(6, auth.getStatus());
		    ps.executeUpdate();
		    return null;
		    
		} catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps); 
		}
		
	}

	private static final String QUERY_AUTH = "SELECT * FROM user WHERE login = ? AND password = ?";
	@Override
	public Auth authorization(String login, String password) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
		    	   
		   con = connectionPool.takeConnection();		    		 
		   ps = con.prepareStatement(QUERY_AUTH);
		   
		   ps.setString(1, login); 
		   ps.setString(2, password); 
		   
		   rs = ps.executeQuery();
		   
		   if (rs.next()) {
				
		    	int id = rs.getInt("id");
		    	String firstName = rs.getString("firstName");
		    	String lastName = rs.getString("lastName");		    	
		    	java.sql.Timestamp   registrationDate= rs.getTimestamp("registration_date");
		    	String role =rs.getString("role");
		    	String status = rs.getString("status");
		    	String token = rs.getString("token");
		    	
				return new Auth (id,firstName,lastName,role,login, registrationDate,status,token);				
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
	 private static final String FIND_USER_BY_TOKEN = "SELECT * FROM users WHERE token = ?";
	@Override
	public Auth findUserByToken(String token) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		        try  {
		        	 con = connectionPool.takeConnection();		    		 
		  		   ps = con.prepareStatement( FIND_USER_BY_TOKEN);
		            ps.setString(1, token);
		            rs = ps.executeQuery();
		             
		                if (rs.next()) {
		                	
		                	int id = rs.getInt("id");
		    		    	String firstName = rs.getString("firstName");
		    		    	String lastName = rs.getString("lastName");	
		    		    	String login = rs.getString("login");
		    		    	java.sql.Timestamp   registrationDate= rs.getTimestamp("registration_date");
		    		    	String role =rs.getString("role");
		    		    	String status = rs.getString("status");
		                	return new Auth (id,firstName,lastName,role,login, registrationDate,status,token);
		                }
		            
		        } catch (SQLException e) {
		            throw new DaoException("Failed to retrieve user by token", e);
		        } catch (ConnectionPoolException e) {
		        	throw new DaoException("Failed to retrieve user by token", e);
				
				}finally { 
					connectionPool.closeConnection(con, ps, rs); 
				}
		        
		        return null;
		    
		

	}
	private static final String UPDATE_USER = "UPDATE user SET token = ? WHERE id = ?";
	@Override
	public void registratedToken(Auth auth) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		
		try { 
			con = connectionPool.takeConnection();		    		 
	  		ps = con.prepareStatement(UPDATE_USER);
			ps.setString(1, auth.getToken()); 
			ps.setInt(2, auth.getId()); 
			ps.executeUpdate(); 
		} catch (SQLException | ConnectionPoolException e) { 
			throw new DaoException("Failed to update user", e); 
		}finally { 
			connectionPool.closeConnection(con, ps); 
		}
		
	}

}

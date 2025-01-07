package app.yarmak.newsportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.UserDao;
import app.yarmak.newsportal.jdbc.ConnectionPool;
import app.yarmak.newsportal.jdbc.ConnectionPoolException;

public class SQLUserDao implements UserDao{
	
	ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean isEmailRegistered(String email) throws DaoException {
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM users WHERE email = ?";
	    try {
	    	con = connectionPool.takeConnection();
	    	 ps = con.prepareStatement(query);
	    	 ps.setString(1, email);
	    	 rs = ps.executeQuery();
	            if (rs.next()) {
	                return rs.getInt(1) > 0;
	            }
	    } catch (SQLException e) {
			throw new DaoException("Ошибка в работе с данными", e);
		} catch (ConnectionPoolException e) {
			throw new DaoException("Ошибка в работе с пулом соединений", e);
		}finally { 
			connectionPool.closeConnection(con, ps, rs); 
			}
	    return false;
	}

	public Auth getUserById(int id) throws DaoException{
		 String query = "SELECT * FROM user WHERE id = ?";
		 Connection con = null; 
			PreparedStatement ps = null; 
			ResultSet rs = null;
	        try  {
	        	con = connectionPool.takeConnection();
		    	 ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	             if (rs.next()) {
	            	 String lastName =rs.getString("lastName");
	                 String userName =rs.getString("firstName");  
	                 String role = rs.getString("role");	
	                 String email = rs.getString("email");
	                 java.sql.Timestamp   registrationDate = rs.getTimestamp("registration_date");
	                 String status =rs.getString("status");

	                 Auth auth = new Auth(id, lastName, userName, role, email, registrationDate, status);
	                 return auth;
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
	public User getUserDetailById(int id) throws DaoException {
		String query = "SELECT * FROM newsportalbd.user_details WHERE user_id = ?;";
		 Connection con = null; 
			PreparedStatement ps = null; 
			ResultSet rs = null;

	    try  {
	    	con = connectionPool.takeConnection();
	    	 ps = con.prepareStatement(query);
	      
	       ps.setInt(1, id);
	        rs = ps.executeQuery();
	           
	            if (rs.next()) {
	               
	                java.sql.Timestamp dateBirth = rs.getTimestamp("dateBirth");
	                String phone = rs.getString("phone");
	     
	                // Пока что заглушки, в будущем будут новые таблицы
	                List<Integer> bookmarkedArticles = null;
	                List<Integer> readingHistory = null;
	                List<Integer> commentList = null;
	                List<Integer> likesList = null;

	                User user = new User(dateBirth, phone, bookmarkedArticles, readingHistory,
	                        commentList, likesList);
	               
	                return user;
	            } else {
	                System.out.println("------- --------------------4 ResultSet is empty");
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


	
}

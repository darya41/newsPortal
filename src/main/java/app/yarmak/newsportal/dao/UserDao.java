package app.yarmak.newsportal.dao;
import app.yarmak.newsportal.bean.Auth;

public interface UserDao {
	
	Auth getUserById(int id) throws DaoException;
    boolean isEmailRegistered(String email) throws DaoException;
	
}

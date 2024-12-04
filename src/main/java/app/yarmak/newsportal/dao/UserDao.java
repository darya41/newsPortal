package app.yarmak.newsportal.dao;
import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;

public interface UserDao {
	
	Auth getUserById(int id) throws DaoException;
    boolean isEmailRegistered(String email) throws DaoException;
    User getUserDetailById(int id)throws DaoException;
}

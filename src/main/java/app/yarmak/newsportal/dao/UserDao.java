package app.yarmak.newsportal.dao;

import app.yarmak.newsportal.bean.User;

public interface UserDao {
	User registration() throws DaoException;
	User authorization(String login, String password) throws DaoException;
	
}

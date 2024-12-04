package app.yarmak.newsportal.dao;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;

public interface AuthDao {
	User registration(Auth auth, String password) throws DaoException;
	Auth authorization(String login, String password) throws DaoException;
}

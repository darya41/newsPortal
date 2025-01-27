package app.yarmak.newsportal.service;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.DaoException;

public interface UserService {
	User getUserDetailById(int id) throws ServiceException;
	Auth getUserById(int id)  throws ServiceException;
	Auth rememberMe(String token) throws ServiceException;
	
}

package app.yarmak.newsportal.service;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;

public interface UserService {
	Auth signIn(String login,String password) throws ServiceException;
	boolean registrration(Auth auth, String password) throws ServiceException;
	Auth getUserById(int id)  throws ServiceException;
}

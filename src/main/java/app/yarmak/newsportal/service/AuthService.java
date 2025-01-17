package app.yarmak.newsportal.service;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;

public interface AuthService {
	Auth signIn(String login,String password) throws ServiceException;
	boolean registrration(Auth auth, String password) throws ServiceException;
	void registratedToken(Auth auth) throws ServiceException;
}

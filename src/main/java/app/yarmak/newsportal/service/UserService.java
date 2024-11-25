package app.yarmak.newsportal.service;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.User;

public interface UserService {
	User signIn(String login,String password) throws ServiceException;
	void registrration() throws ServiceException;

}

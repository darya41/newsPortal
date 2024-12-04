package app.yarmak.newsportal.service.impl;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.dao.AuthDao;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.dao.UserDao;
import app.yarmak.newsportal.service.AuthService;

public class AuthServiceImpl implements AuthService{

	private final AuthDao authDao = DaoProvider.getInstance().getAuthDao();
	private final UserDao userDao = DaoProvider.getInstance().getUserDao();
	@Override
	public Auth signIn(String login, String password) throws ServiceException {
		try {
			return authDao.authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean registrration(Auth auth, String password) throws ServiceException {
		try {
			if(!userDao.isEmailRegistered(auth.getEmail())) {
				 return false;
			}
			
			authDao.registration(auth,password);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return true;
	}

}

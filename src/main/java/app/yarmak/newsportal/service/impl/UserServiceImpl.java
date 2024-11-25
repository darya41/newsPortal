package app.yarmak.newsportal.service.impl;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.dao.UserDao;
import app.yarmak.newsportal.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserDao userDao = DaoProvider.getInstance().getUserDao();
	@Override
	public User signIn(String login, String password) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return userDao.authorization(login, password);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public void registrration() throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}

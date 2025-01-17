package app.yarmak.newsportal.service.impl;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.bean.User;
import app.yarmak.newsportal.dao.AuthDao;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.dao.UserDao;
import app.yarmak.newsportal.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserDao userDao = DaoProvider.getInstance().getUserDao();
	private final AuthDao authDao = DaoProvider.getInstance().getAuthDao();

	@Override
	public Auth getUserById(int id) throws ServiceException {
		
		try {
			return userDao.getUserById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public User getUserDetailById(int id) throws DaoException {
		try {
			 System.out.println("User Service     ------- " + id);
			return userDao.getUserDetailById(id);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Auth rememberMe(String token) throws ServiceException {
		try {
			Auth auth = authDao.findUserByToken(token);
			return auth;
		}catch(DaoException e) {
			throw new ServiceException(e);
		}

	}

}

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
			throw new ServiceException("Ошибка при получении пользователя по ID: " + id, e);
		}
	}

	@Override
	public User getUserDetailById(int id) throws ServiceException {
		try {
			return userDao.getUserDetailById(id);	
			
		} catch (DaoException e) {
			throw new ServiceException("Ошибка при получении деталей пользователя по ID: " + id, e);
		}
	}


	public Auth rememberMe(String token) throws ServiceException {
		try {
			return authDao.findUserByToken(token);
			
		}catch(DaoException e) {
			throw new ServiceException("Ошибка при поиске пользователя по токену: " + token, e);
		}
	}
}

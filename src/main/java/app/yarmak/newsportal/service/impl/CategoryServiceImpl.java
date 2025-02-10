package app.yarmak.newsportal.service.impl;

import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Category;
import app.yarmak.newsportal.dao.CategoryDao;
import app.yarmak.newsportal.dao.DaoException;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao = DaoProvider.getInstance().getCategoryDao();
	@Override
	public List<Category> getAllCategory()  throws ServiceException {
		
		try {
			return categoryDao.findAllCategory();				
		} catch (DaoException e) {
			throw new ServiceException("Failed to retrieve categories", e);
		}				
	}
}
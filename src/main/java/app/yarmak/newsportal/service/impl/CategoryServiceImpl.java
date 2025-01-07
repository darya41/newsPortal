package app.yarmak.newsportal.service.impl;

import java.util.List;


import app.yarmak.newsportal.bean.Category;
import app.yarmak.newsportal.dao.CategoryDao;
import app.yarmak.newsportal.dao.DaoProvider;
import app.yarmak.newsportal.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao = DaoProvider.getInstance().getCategoryDao();
	@Override
	public List<Category> getAllCategory() {
		
			return categoryDao.findAllCategory();
		
		
	}

}

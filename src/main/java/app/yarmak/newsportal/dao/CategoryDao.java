package app.yarmak.newsportal.dao;

import java.util.List;

import app.yarmak.newsportal.bean.Category;

public interface CategoryDao {
	List<Category> findAllCategory() throws DaoException ;
}

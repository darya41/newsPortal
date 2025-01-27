package app.yarmak.newsportal.service;

import java.util.List;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Category;

public interface CategoryService {
	List<Category> getAllCategory()  throws ServiceException;

}

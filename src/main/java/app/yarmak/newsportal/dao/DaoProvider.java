package app.yarmak.newsportal.dao;

import app.yarmak.newsportal.dao.impl.SQLAuthDao;
import app.yarmak.newsportal.dao.impl.SQLCommentDao;
import app.yarmak.newsportal.dao.impl.SQLNewsDao;
import app.yarmak.newsportal.dao.impl.SQLUserDao;

public class DaoProvider {
	private static  DaoProvider instance = new DaoProvider();
	
	private DaoProvider(){
		
	}
	private final UserDao userDao = new SQLUserDao();
	private final NewsDao newsDao = new SQLNewsDao();
	private final AuthDao authDao = new SQLAuthDao();
	private final CommentDao commentDao = new SQLCommentDao();
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public NewsDao getNewsDao() {
		return newsDao;
	}
	public AuthDao getAuthDao() {
		return authDao;
	}
	
	public CommentDao getCommentDao() {
		return commentDao;
	}
	
	public static DaoProvider getInstance () {
		return instance;
	}
}

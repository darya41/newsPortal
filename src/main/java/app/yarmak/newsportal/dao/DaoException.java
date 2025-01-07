package app.yarmak.newsportal.dao;

public class DaoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(String message,Exception e) {
		super(e);
	}

}

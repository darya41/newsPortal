package app.yarmak.newsportal.logic;

import app.yarmak.newsportal.bean.AuthInfo;
import app.yarmak.newsportal.bean.User;

public class CheckAuth {
	public User CheckAuthUser(String login, String password  ) {
		if ("dasha@41.com".equals(login)) {
			System.out.println(login);
			return new User("Dasha", new AuthInfo(login,password));
		}
		return null;
	}

}

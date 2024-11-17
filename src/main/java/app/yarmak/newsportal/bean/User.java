package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private AuthInfo auth;
	
	public User() {
		
	}
	public User(String name, AuthInfo auth) {
		this.auth=auth;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthInfo getAuth() {
		return auth;
	}

	public void setAuth(AuthInfo auth) {
		this.auth = auth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, auth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Objects.equals(auth, other.auth);
	}

}

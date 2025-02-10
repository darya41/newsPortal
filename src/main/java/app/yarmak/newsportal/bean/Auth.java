package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.util.Objects;
import java.sql.*;

public class Auth implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String lastName;
	private String role;
    private String email;
    private Timestamp registrationDate;
    private String status;
    private String token;

    public Auth() {
    	
    }

    public Auth(int id,String username,String lastName,String role, 
    		String email, Timestamp registrationDate2 , 
    		String status, String token) {
        this.id=id;
    	this.username = username;
    	this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.status = status;
        this.registrationDate = registrationDate2;
        this.token = token;
    }

	public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getLastName() {
    	return lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName=lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate( Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getToken() {
        return status;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Auth auth = (Auth) obj;
        return id == auth.id &&
               username.equals(auth.username) &&
               lastName.equals(auth.lastName) &&
               email.equals(auth.email) &&
               role.equals(auth.role) &&
               status.equals(auth.status) &&
               token.equals(auth.token) &&
               registrationDate.equals(auth.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,username, lastName,email, role, status,
        		registrationDate, token);
    }
    
    @Override
    public String toString() {
        return "Auth{" +
        		"id='" + id+'\''+
                "username='" + username + '\'' +
                "lastName'"+ lastName+'\''+
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
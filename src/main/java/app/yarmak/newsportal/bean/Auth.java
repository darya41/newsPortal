package app.yarmak.newsportal.bean;

import java.util.Objects;

public class Auth {
	private int id;
	 private String username;
	 private String lastName;
	private String role;
    private String email;
 
    private  java.sql.Timestamp registrationDate;
    private String status;


    public Auth(int id,String username,String lastName,String role, String email,  java.sql.Timestamp registrationDate2 , String status) {
        this.id=id;
    	this.username = username;
    	this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.status = status;
        this.registrationDate = registrationDate2;
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

    public  java.sql.Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate( java.sql.Timestamp registrationDate) {
        this.registrationDate = registrationDate;
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
               registrationDate.equals(auth.registrationDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id,username, lastName,email, role, status, registrationDate);
    }
}
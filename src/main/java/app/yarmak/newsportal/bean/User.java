package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lastName;
	private String firstName;
	private java.sql.Timestamp dateBirth;
	private String role;
	private String email;
	private String phone;
	private List<Integer> bookmarkedArticles;
	private List<Integer> readingHistory;
	private List<Integer> commentList;
	private List<Integer> likesList;
	
	
	
	public User() {
		
	}
	
	public User(int id, String lastName, String firstName, java.sql.Timestamp dateBirth, 
			String role,String email, String phone, 
			List<Integer> bookmarkedArticles, List<Integer> readingHistory, 
			List<Integer> commentList, List<Integer> likesList) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateBirth = dateBirth;
        this.role = role;
        this.email=email;
        this.phone = phone;
        this.bookmarkedArticles = bookmarkedArticles;
        this.readingHistory = readingHistory;
        this.commentList = commentList;
        this.likesList = likesList;
    }



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public java.sql.Timestamp getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(java.sql.Timestamp dateBirth) {
        this.dateBirth = dateBirth;
    }

   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getBookmarkedArticles() {
        return bookmarkedArticles;
    }

    public void setBookmarkedArticles(List<Integer> bookmarkedArticles) {
        this.bookmarkedArticles = bookmarkedArticles;
    }

    public List<Integer> getReadingHistory() {
        return readingHistory;
    }

    public void setReadingHistory(List<Integer> readingHistory) {
        this.readingHistory = readingHistory;
    }

    public List<Integer> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Integer> commentList) {
        this.commentList = commentList;
    }

    public List<Integer> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<Integer> likesList) {
        this.likesList = likesList;
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, dateBirth, 
        		role, email, phone, bookmarkedArticles, 
        		readingHistory, commentList, likesList);
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(dateBirth, user.dateBirth) &&
                
                Objects.equals(role, user.role) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(bookmarkedArticles, user.bookmarkedArticles) &&
                Objects.equals(readingHistory, user.readingHistory) &&
                Objects.equals(commentList, user.commentList) &&
                Objects.equals(likesList, user.likesList);
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateBirth=" + dateBirth +
                
                ", role='" + role + '\'' +
                ", email=" + email +
                ", phone='" + phone + '\'' +
                ", bookmarkedArticles=" + bookmarkedArticles +
                ", readingHistory=" + readingHistory +
                ", commentList=" + commentList +
                ", likesList=" + likesList +
                '}';
    }
	
}

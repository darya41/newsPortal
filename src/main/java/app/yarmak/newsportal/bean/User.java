package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private java.sql.Timestamp dateBirth;
	private String phone;
	private List<Integer> bookmarkedArticles;
	private List<Integer> readingHistory;
	private List<Integer> commentList;
	private List<Integer> likesList;
	
	
	
	public User() {
		
	}
	
	public User(java.sql.Timestamp dateBirth, String phone, 
			List<Integer> bookmarkedArticles, List<Integer> readingHistory, 
			List<Integer> commentList, List<Integer> likesList) {
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.bookmarkedArticles = bookmarkedArticles;
        this.readingHistory = readingHistory;
        this.commentList = commentList;
        this.likesList = likesList;
    }

    public java.sql.Timestamp getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(java.sql.Timestamp dateBirth) {
        this.dateBirth = dateBirth;
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
        return Objects.hash( dateBirth,phone, bookmarkedArticles, 
        		readingHistory, commentList, likesList);
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return  Objects.equals(dateBirth, user.dateBirth) &&
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
                ", dateBirth=" + dateBirth +
                ", phone='" + phone + '\'' +
                ", bookmarkedArticles=" + bookmarkedArticles +
                ", readingHistory=" + readingHistory +
                ", commentList=" + commentList +
                ", likesList=" + likesList +
                '}';
    }
	
}

package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String commentId;
    private String userId;
    private String articleId;
    private String content;
    private LocalDateTime timestamp;
    private double rating;

    public Comment(String commentId, String userId, String articleId, String content, LocalDateTime timestamp, double rating) {
        this.commentId = commentId;
        this.userId = userId;
        this.articleId = articleId;
        this.content = content;
        this.timestamp = timestamp;
        this.rating = rating;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Comment comment = (Comment) obj;
        return Double.compare(comment.rating, rating) == 0 &&
                Objects.equals(commentId, comment.commentId) &&
                Objects.equals(userId, comment.userId) &&
                Objects.equals(articleId, comment.articleId) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(timestamp, comment.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, userId, articleId, content, timestamp, rating);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", userId='" + userId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", rating=" + rating +
                '}';
    }
}

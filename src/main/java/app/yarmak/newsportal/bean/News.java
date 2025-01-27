package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private String title;
	 private String brief;
	 private String content;
	 private String author;
	 private java.sql.Timestamp publicationDate;
	 private int idCategory;
	 private int views;
	 private int priority;
	 private String status;
	
	public News() {
	}
	
	public News(int id,String title, String brief, String content, String author, 
			java.sql.Timestamp  publicationDate,int idCategory,int views, int priority, String status) {
		super();
		this.id=id;
		this.title = title;
		this.brief = brief;
		this.content=content;
		this.author=author;
		this.publicationDate=publicationDate;
		this.idCategory=idCategory;
		this.views=views;
		this.priority = priority;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	public String getContent() {
       return content;
   }

   public void setContent(String content) {
       this.content = content;
   }

   public String getAuthor() {
       return author;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public java.sql.Timestamp  getPublicationDate() {
       return publicationDate;
   }

   public void setPublicationDate(java.sql.Timestamp  publicationDate) {
       this.publicationDate = publicationDate;
   }

   public int getCategory() {
       return idCategory;
   }

   public void setCategory(int category) {
       this.idCategory = category;
   }

   public int getViews() {
       return views;
   }

   public void setViews(int views) {
       this.views = views;
   }
   
   public int getPriority() {
       return priority;
   }

   public void setPriority(int priority) {
       this.priority = priority;
   }
   public String getStatus() {
	   return status;
   }
   public void setStatus(String status) {
	   this.status=status;
   }

	
	@Override
	public int hashCode() {
		 return Objects.hash(id, title, brief, content, author, publicationDate, idCategory, views,priority, status);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    News news = (News) obj;
	    return id == news.id &&
	            views == news.views &&
	            Objects.equals(title, news.title) &&
	            Objects.equals(brief, news.brief) &&
	            Objects.equals(content, news.content) &&
	            Objects.equals(author, news.author) &&
	            Objects.equals(publicationDate, news.publicationDate) &&
	            Objects.equals(idCategory, news.idCategory)&&
	            Objects.equals(priority, news.priority)&&
	    		Objects.equals(status, news.status);
	    
	}

	@Override
	public String toString() {
       return "News{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", summary='" + brief + '\'' +
               ", content='" + content + '\'' +
               ", author='" + author + '\'' +
               ", publicationDate=" + publicationDate +
               ", category='" + idCategory + '\'' +
               ", views=" + views +
                ", views=" + views +
                 ", views=" + views +
               '}';
   }	
}

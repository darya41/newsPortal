package app.yarmak.newsportal.bean;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private String title;
	 private String brief;
	 private String content;
	 private String author;
	 private ZonedDateTime  publicationDate;
	 private Category category;
	 private int views;
	 private int priority;
	
	public News() {
	}
	
	public News(int id,String title, String brief, String content, String author, 
			ZonedDateTime  publicationDate,Category category,int views, int priority) {
		super();
		this.id=id;
		this.title = title;
		this.brief = brief;
		this.content=content;
		this.author=author;
		this.publicationDate=publicationDate;
		this.category=category;
		this.views=views;
		this.priority = priority;
		
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

   public ZonedDateTime  getPublicationDate() {
       return publicationDate;
   }

   public void setPublicationDate(ZonedDateTime  publicationDate) {
       this.publicationDate = publicationDate;
   }

   public Category getCategory() {
       return category;
   }

   public void setCategory(Category category) {
       this.category = category;
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

	
	@Override
	public int hashCode() {
		 return Objects.hash(id, title, brief, content, author, publicationDate, category, views);
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
	            Objects.equals(category, news.category)&&
	            Objects.equals(priority, news.priority);
	    
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
               ", category='" + category + '\'' +
               ", views=" + views +
               '}';
   }	
	
	public static Comparator<News> compareByDate() {
       return Comparator.comparing(News::getPublicationDate).reversed();
   }

   public static Comparator<News> compareByViews() {
       return Comparator.comparingInt(News::getViews).reversed();
   }

   public static Comparator<News> compareByMain() {
       return Comparator.comparing(News::getPriority) 
                        .thenComparing(News::getPublicationDate) 
                        .thenComparingInt(News::getViews) 
                        .reversed();
   }


}

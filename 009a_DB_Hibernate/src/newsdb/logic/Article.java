package newsdb.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    private long id;
    private String title;
    private String description;
    private String keywords;
    private String content;
 
    public Article() {
    }
 
    public Article(String title, String description, String keywords,
            String content) {
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.content = content;
    }
 
    @Id
    @Column(name = "article_id")
    public long getId() {
        return id;
    }
    
    @Column(name = "title")
	public String getTitle() {
		return title;
	}
    
    @Column(name = "description")
	public String getDescription() {
		return description;
	}
    @Column(name = "keywords")
	public String getKeywords() {
		return keywords;
	}
    
    @Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setContent(String content) {
		this.content = content;
	}
 
   
}

package newsdb.logic;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	private long id;
    private String name; 
    private Set<Article> articles;
 
    public Category() {
    }
 
    public Category(String name) {
        this.name = name;
    }
 
    @Id
    @Column(name = "category_id")
    public long getId() {
        return id;
    }
 
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_article",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    public Set<Article> getArticles() {
        return articles;
    }
    
    @Column(name = "name")
    public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
    
    
}

package blog_app.blog_app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private int id;
    private String blogCreator;
    private String blogName;
    private String content;
    private String dateCreated;

    public Blog() {
    }

    public Blog(int id, String blogCreator, String blogName, String content, String dateCreated) {
        this.id = id;
        this.blogCreator = blogCreator;
        this.blogName = blogName;
        this.content = content;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogCreator() {
        return blogCreator;
    }

    public void setBlogCreator(String blogCreator) {
        this.blogCreator = blogCreator;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}

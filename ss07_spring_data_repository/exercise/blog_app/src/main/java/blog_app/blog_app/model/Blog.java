package blog_app.blog_app.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String blogCreator;
    private String blogName;
    private String content;
    @Column(columnDefinition = "Date")
    private String dateCreated;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String blogCreator, String blogName, String content, String dateCreated) {
        this.id = id;
        this.blogCreator = blogCreator;
        this.blogName = blogName;
        this.content = content;
        this.dateCreated = dateCreated;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

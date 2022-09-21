package com.example_blog.model;

import javax.persistence.*;

@Entity
public class Blogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String creatorBlog;
    private String nameBlog;
    @Column(columnDefinition = "Date")
    private String dateCreated;
    private String content;
    private String linkBlog;

    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id")
//  /  @Column(columnDefinition = "not category")
    private Category category;

    public Blogs() {
    }

    public Blogs(int id, String creatorBlog, String nameBlog, String dateCreated, String content, String linkBlog) {
        this.id = id;
        this.creatorBlog = creatorBlog;
        this.nameBlog = nameBlog;
        this.dateCreated = dateCreated;
        this.content = content;
        this.linkBlog = linkBlog;
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

    public String getCreatorBlog() {
        return creatorBlog;
    }

    public void setCreatorBlog(String creatorBlog) {
        this.creatorBlog = creatorBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkBlog() {
        return linkBlog;
    }

    public void setLinkBlog(String linkBlog) {
        this.linkBlog = linkBlog;
    }
}

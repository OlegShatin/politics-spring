package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.SortedSet;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
public class Article {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String headline;
    @Column
    private String content;
    @Column
    private OffsetDateTime publicationDateTime;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "article")
    @SortNatural
    private SortedSet<Comment> comments;

    public void setId(int id) {
        this.id = id;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublicationDateTime(OffsetDateTime publicationDateTime) {
        this.publicationDateTime = publicationDateTime;
    }

    public SortedSet<Comment> getComments() {
        return comments;
    }

    public void setComments(SortedSet<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getContent() {
        return content;
    }

    public OffsetDateTime getPublicationDateTime() {
        return publicationDateTime;
    }

    public Article(){};
    public Article(int id, String headline, String content, OffsetDateTime publicationDateTime) {
        this.id = id;
        this.headline = headline;
        this.content = content;
        this.publicationDateTime = publicationDateTime;
    }
}

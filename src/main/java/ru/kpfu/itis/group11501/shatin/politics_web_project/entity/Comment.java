package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.SortedSet;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
@Table(name = "comments")
public class Comment implements Comparable<Comment> {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Comment parentComment;
    @ManyToOne
    private Article article;
    @ManyToOne
    private User user;
    @Column
    private String text;
    @Column
    private int rating;
    @Column
    private OffsetDateTime publicationDateTime;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "parentComment")
    @SortNatural
    private SortedSet<Comment> childrenComments;

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPublicationDateTime(OffsetDateTime publicationDateTime) {
        this.publicationDateTime = publicationDateTime;
    }

    public SortedSet<Comment> getChildrenComments() {
        return childrenComments;
    }

    public void setChildrenComments(SortedSet<Comment> childrenComments) {
        this.childrenComments = childrenComments;
    }

    public Comment(){};
    public Comment(Comment parentComment, Article article, User user, String text) {
        this.id = null;
        this.parentComment = parentComment;
        this.article = article;
        this.user = user;
        this.text = text;
    }

    public Comment(Comment parentComment, Article article, User user, String text, OffsetDateTime publicationDateTime) {
        this(parentComment, article, user, text);
        this.publicationDateTime = publicationDateTime;
    }

    public Comment(int id, Comment parentComment, Article article, User user, String text, OffsetDateTime publicationDateTime, int rating) {
        this(parentComment, article, user, text, publicationDateTime);
        this.id = id;
        this.rating = rating;
    }



    public OffsetDateTime getPublicationDateTime() {
        return publicationDateTime;
    }
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", parentCommentID=" + parentComment.getId() +
                ", article=" + article.getId() +
                ", user=" + user.getId() +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", publicationDateTime=" + publicationDateTime +
                '}';
    }


    @Override
    public int compareTo(Comment o) {
        if(o == null)
            return 1;

        return publicationDateTime.compareTo(o.getPublicationDateTime());
    }
}

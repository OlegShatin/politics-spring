package ru.kpfu.itis.group11501.shatin.politics_web_project.service;

import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Article;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Comment;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Comment;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;

import java.util.List;

/**
 * @author Oleg Shatin
 *         11-501
 */
public interface NewsService {
    Article getArticle(long articleID, User user);

    Comment addComment(Comment newComment);

    List<Comment> getCommentsOfArticleForUser(Article article, User user);

    List<Article> getArticlesForUser(User user, String search, boolean headlinesOnly);

    Comment getCommentById(long commentId, User user);

    void upRatingForComment(Comment comment);

    void downRatingForComment(Comment comment);
}

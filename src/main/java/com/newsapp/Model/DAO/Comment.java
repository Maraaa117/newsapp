package com.newsapp.Model.DAO;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int id_comment;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_news")
    private News news;

    @Column(name = "comment")
    private String comment;

    public Comment() {

    }

    public Comment(int id_comment, User user, News news, String comment) {
        this.id_comment = id_comment;
        this.user = user;
        this.news = news;
        this.comment = comment;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id_comment=" + id_comment +
                ", user=" + user +
                ", news=" + news +
                ", comment='" + comment + '\'' +
                '}';
    }
}

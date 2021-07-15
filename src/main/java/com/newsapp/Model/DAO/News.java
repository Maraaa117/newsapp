package com.newsapp.Model.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_news")
    private int id_news;

    @Column(name = "likes")
    private int likes;

    @Column(name = "readingTime")
    private int readingTime;

    @Column(name = "author")
    private String author;

    @Column(name = "URL")
    private String URL;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "news", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> commentsList;


    public News() {

    }

    public News(int id_news, int likes, int readingTime, String author, String URL, String type, List<Comment> commentsList) {
        this.id_news = id_news;
        this.likes = likes;
        this.readingTime = readingTime;
        this.author = author;
        this.URL = URL;
        this.type = type;
        this.commentsList = commentsList;
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(int readingTime) {
        this.readingTime = readingTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "News{" +
                "id_news=" + id_news +
                ", likes=" + likes +
                ", readingTime=" + readingTime +
                ", author='" + author + '\'' +
                ", URL='" + URL + '\'' +
                ", type='" + type + '\'' +
                ", commentsList=" + commentsList +
                '}';
    }
}

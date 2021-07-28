package com.newsapp.Service;

import com.newsapp.Model.DAO.Comment;
import com.newsapp.Model.DAO.News;
import com.newsapp.Model.DAO.User;
import com.newsapp.Repository.CommentRepository;
import com.newsapp.Repository.NewsRepository;
import com.newsapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    public String saveComment(Comment comment, int newsId, int userId) {

        News news = this.newsRepository.findById(newsId).get();
        User user = this.userRepository.findById(userId).get();

        comment.setNews(news);
        comment.setUser(user);

        this.commentRepository.save(comment);
        return "Comment added successsfully";
    }

    public List<Comment> getComments() {
        return this.commentRepository.findAll();
    }

    public String updateComment(Comment comment, int id) {
        Comment oldComment = commentRepository.findById(id).get();

        oldComment.setComment(comment.getComment());

        this.commentRepository.save(oldComment);
        return "Comment updated successfully";
    }

    public String deleteCommentById(int id) {
        this.commentRepository.deleteById(id);
        return "Comment deleted successfully";
    }
}

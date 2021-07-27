package com.newsapp.Service;

import com.newsapp.Model.DAO.Comment;
import com.newsapp.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public String saveComment(Comment comment) {
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

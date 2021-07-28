package com.newsapp.Controller;

import com.newsapp.Model.DAO.Comment;
import com.newsapp.Repository.CommentRepository;
import com.newsapp.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/saveComment/{idNews}/{idUser}", method = RequestMethod.POST)
    public String saveComment(@RequestBody Comment comment, @PathVariable int idNews, @PathVariable int idUser) {
        return commentService.saveComment(comment, idNews, idUser);
    }

    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @RequestMapping(value = "/updateComment/{id}", method = RequestMethod.PUT)
    public String updateComment(@RequestBody Comment comment, @PathVariable int id) {
        return commentService.updateComment(comment, id);
    }

    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.DELETE)
    public String deleteComment(@PathVariable int id) {
        return commentService.deleteCommentById(id);
    }
}

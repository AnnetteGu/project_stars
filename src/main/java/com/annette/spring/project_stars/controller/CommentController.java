package com.annette.spring.project_stars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annette.spring.project_stars.entity.Comment;
import com.annette.spring.project_stars.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/star/comments/{id}")
    public List<Comment> getAllStarComments(@PathVariable(name = "id") int id) {

        return commentService.getAllStarComments(id);
        
    }

    @GetMapping("/user/comments/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public List<Comment> getAllUserComments(@PathVariable(name = "id") int id) {

        return commentService.getAllUserComments(id);

    }

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable(name = "id") int id) {

        return commentService.getComment(id);

    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {

        commentService.saveComment(comment);

        return comment;

    }

    @PutMapping("/comments")
    public Comment updateComment(@RequestBody Comment comment) {

        commentService.saveComment(comment);

        return comment;

    }

    @DeleteMapping("/comments/{id}")
    public String deleteComment(@PathVariable int id) {

        commentService.deleteComment(id);

        return "Comment with id = " + id + " was deleted";

    }

}

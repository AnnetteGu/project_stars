package com.annette.spring.project_stars.service;

import java.util.List;

import com.annette.spring.project_stars.entity.Comment;

public interface CommentService {

    public List<Comment> getAllStarComments(int id);

    public List<Comment> getAllUserComments(int id);

    public Comment getComment(int id);

    public Comment saveComment(Comment comment);

    public void deleteComment(int id);

}

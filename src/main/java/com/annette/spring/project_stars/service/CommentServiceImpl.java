package com.annette.spring.project_stars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annette.spring.project_stars.dao.CommentDAO;
import com.annette.spring.project_stars.entity.Comment;

import jakarta.transaction.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDAO commentDAO;

    @Override
    @Transactional
    public List<Comment> getAllStarComments(int id) {

        return commentDAO.getAllStarComments(id);
  
    }

    @Override
    @Transactional
    public List<Comment> getAllUserComments(int id) {

        return commentDAO.getAllUserComments(id);
      
    }

    @Override
    @Transactional
    public Comment getComment(int id) {

        return commentDAO.getComment(id);

    }

    @Override
    @Transactional
    public Comment saveComment(Comment comment) {

        commentDAO.saveComment(comment);

        return comment;

    }

    @Override
    @Transactional
    public void deleteComment(int id) {

        commentDAO.deleteComment(id);

    }

}

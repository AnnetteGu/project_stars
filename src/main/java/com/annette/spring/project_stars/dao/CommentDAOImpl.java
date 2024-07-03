package com.annette.spring.project_stars.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.Comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Comment> getAllStarComments(int id) {
        
        Query query = entityManager
            .createQuery("from Comment where starId =:starId");

        query.setParameter("starId", id);

        @SuppressWarnings("unchecked")
        List<Comment> starComments = query.getResultList();

        return starComments;

    }

    @Override
    public List<Comment> getAllUserComments(int id) {

        Query query = entityManager
            .createQuery("from Comment where userId =:userId");
        
        query.setParameter("userId", id);

        @SuppressWarnings("unchecked")
        List<Comment> userComments = query.getResultList();

        return userComments;

    }

    @Override
    public Comment getComment(int id) {

        return entityManager.find(Comment.class, id);

    }

    @Override
    public Comment saveComment(Comment comment) {

        Comment newComment = entityManager.merge(comment);

        comment.setId(newComment.getId());

        return comment;

    }

    @Override
    public void deleteComment(int id) {

        Comment comment = entityManager.find(Comment.class, id);

        entityManager.remove(comment);

    }

}

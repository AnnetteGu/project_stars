package com.annette.spring.project_stars.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.Star;

import jakarta.persistence.EntityManager;

@Repository
public class StarDAOImpl implements StarDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Star> getAllStars() {

        List<Star> stars = entityManager.createQuery("from Star", Star.class)
            .getResultList();

        return stars;

    }

    @Override
    public Star getStar(int id) {

        Star star = entityManager.find(Star.class, id);

        return star;

    }

    @Override
    public Star saveStar(Star star) {

        Star newStar = entityManager.merge(star);

        star.setId(newStar.getId());

        return star;

    }

    @Override
    public void deleteStar(int id) {

        Star star = entityManager.find(Star.class, id);

        entityManager.remove(star);

    }

}

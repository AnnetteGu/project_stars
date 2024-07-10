package com.annette.spring.project_stars.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.ConstellationInf;
import com.annette.spring.project_stars.entity.Star;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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

    @SuppressWarnings("unchecked")
    @Override
    public Star searchStar(String name) {

        // штука для парса json-a
        ObjectMapper objectMapper = new ObjectMapper();

        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        try {
            // 
            resultMap = objectMapper.readValue(name, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String starName = resultMap.get("name");

        Query query = entityManager
            .createQuery("from Star where name =:starName");

        query.setParameter("starName", starName);

        return (Star) query.getSingleResult();

    }

    @Override
    public Star getStar(int id) {

        Star star = entityManager.find(Star.class, id);

        return star;

    }

    @Override
    public ConstellationInf getStarConstInf(int id) {

        Star star = entityManager.find(Star.class, id);

        ConstellationInf constInf = star.getStarConstInf();

        int constInfId = constInf.getId();

        return entityManager.find(ConstellationInf.class, constInfId);

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

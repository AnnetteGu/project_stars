package com.annette.spring.project_stars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annette.spring.project_stars.dao.StarDAO;
import com.annette.spring.project_stars.entity.ConstellationInf;
import com.annette.spring.project_stars.entity.Star;

import jakarta.transaction.Transactional;

@Service
public class StarServiceImpl implements StarService {

    @Autowired
    StarDAO starDAO;

    @Override
    @Transactional
    public List<Star> getAllStars() {

        return starDAO.getAllStars();

    }

    @Override
    @Transactional
    public Star getStar(int id) {

        return starDAO.getStar(id);
      
    }

    @Override
    @Transactional
    public ConstellationInf getStarConstInf(int id) {

        return starDAO.getStarConstInf(id);

    }

    @Override
    @Transactional
    public Star saveStar(Star star) {

        starDAO.saveStar(star);

        return star;

    }

    @Override
    @Transactional
    public void deleteStar(int id) {

        starDAO.deleteStar(id);

    }

}

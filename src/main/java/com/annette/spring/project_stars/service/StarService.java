package com.annette.spring.project_stars.service;

import java.util.List;

import com.annette.spring.project_stars.entity.ConstellationInf;
import com.annette.spring.project_stars.entity.Star;

public interface StarService {

    public List<Star> getAllStars();

    public Star searchStar(String name);

    public Star getStar(int id);

    public ConstellationInf getStarConstInf(int id);

    public Star saveStar(Star star);

    public void deleteStar(int id);

}

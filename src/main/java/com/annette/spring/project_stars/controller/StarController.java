package com.annette.spring.project_stars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annette.spring.project_stars.entity.ConstellationInf;
import com.annette.spring.project_stars.entity.Star;
import com.annette.spring.project_stars.service.StarService;

@RestController
@RequestMapping("/api")
public class StarController {

    @Autowired
    StarService starService;

    @GetMapping("/stars")
    public List<Star> getAllStars() {

        return starService.getAllStars();

    }

    @GetMapping("/stars/{id}")
    public Star getStar(@PathVariable(name = "id") int id) {

        return starService.getStar(id);

    }

    @GetMapping("/stars/const-inf/{id}")
    public ConstellationInf getStarConstInf(@PathVariable(name = "id") int id) {

        return starService.getStarConstInf(id);

    }

    @PostMapping("/stars")
    public Star addStar(@RequestBody Star star) {

        starService.saveStar(star);

        return star;

    }

    @PutMapping("/stars")
    public Star updateStar(@RequestBody Star star) {

        starService.saveStar(star);

        return star;

    }

    @DeleteMapping("/stars/{id}")
    public String deleteStar(@PathVariable(name = "id") int id) {

        starService.deleteStar(id);

        return "Star with id = " + id + " was deleted";

    }

}

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

import com.annette.spring.project_stars.entity.Constellation;
import com.annette.spring.project_stars.service.ConstellationService;

@RestController
@RequestMapping("/api")
public class ConstController {

    @Autowired
    ConstellationService constService;

    @GetMapping("/consts")
    public List<Constellation> getAllConsts() {

        return constService.getAllConsts();

    }

    @PostMapping("/consts/search")
    public Constellation searchConst(@RequestBody String name) {

        return constService.searchConst(name);

    }

    @GetMapping("/consts/{id}")
    public Constellation getConst(@PathVariable(name = "id") int id) {

        return constService.getConst(id);

    }

    @PostMapping("/consts")
    public Constellation addConst(@RequestBody Constellation constellation) {

        constService.saveConst(constellation);

        return constellation;

    }

    @PutMapping("/consts")
    public Constellation updateConst(@RequestBody Constellation constellation) {

        constService.saveConst(constellation);

        return constellation;

    }

    @DeleteMapping("/consts/{id}")
    public String deleteConst(@PathVariable(name = "id") int id) {

        constService.deleteConst(id);

        return "Constellation with id = " + id + " was deleted.";

    }

}

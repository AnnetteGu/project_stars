package com.annette.spring.project_stars.service;

import java.util.List;

import com.annette.spring.project_stars.entity.Constellation;

public interface ConstellationService {

    public List<Constellation> getAllConsts();

    public Constellation searchConst(String name);

    public Constellation getConst(int id);

    public Constellation saveConst(Constellation constellation);

    public void deleteConst(int id);

}

package com.annette.spring.project_stars.dao;

import java.util.List;

import com.annette.spring.project_stars.entity.Constellation;

public interface ConstellationDAO {

    public List<Constellation> getAllConsts();

    public Constellation getConst(int id);

    public Constellation saveConst(Constellation constellation);

    public void deleteConst(int id);

}

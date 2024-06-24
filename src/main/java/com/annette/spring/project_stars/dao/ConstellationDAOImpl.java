package com.annette.spring.project_stars.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.Constellation;

import jakarta.persistence.EntityManager;

@Repository
public class ConstellationDAOImpl implements ConstellationDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Constellation> getAllConsts() {

        List<Constellation> consts = entityManager.createQuery("from Constellation", 
            Constellation.class).getResultList();

        return consts;

    }

    @Override
    public Constellation getConst(int id) {
 
        return entityManager.find(Constellation.class, id);

    }

    @Override
    public Constellation saveConst(Constellation constellation) {

        Constellation newConst = entityManager.merge(constellation);

        constellation.setId(newConst.getId());

        return constellation;

    }

    @Override
    public void deleteConst(int id) {

        Constellation constellation = entityManager.find(Constellation.class, id);

        entityManager.remove(constellation);

    }

}

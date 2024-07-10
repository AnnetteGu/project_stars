package com.annette.spring.project_stars.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.Constellation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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

    @SuppressWarnings("unchecked")
    @Override
    public Constellation searchConst(String name) {
        
        ObjectMapper objectMapper = new ObjectMapper();

        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        try {
            resultMap = objectMapper.readValue(name, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String constName = resultMap.get("name");

        Query query = entityManager
            .createQuery("from Constellation where name =:constName");
        
        query.setParameter("constName", constName);

        return (Constellation) query.getSingleResult();

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

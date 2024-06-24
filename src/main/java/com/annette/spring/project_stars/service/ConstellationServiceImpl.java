package com.annette.spring.project_stars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annette.spring.project_stars.dao.ConstellationDAO;
import com.annette.spring.project_stars.entity.Constellation;

import jakarta.transaction.Transactional;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    @Autowired
    ConstellationDAO constDAO;

    @Override
    @Transactional
    public List<Constellation> getAllConsts() {

        return constDAO.getAllConsts();

    }

    @Override
    @Transactional
    public Constellation getConst(int id) {

        return constDAO.getConst(id);

    }

    @Override
    @Transactional
    public Constellation saveConst(Constellation constellation) {

        constDAO.saveConst(constellation);

        return constellation;

    }

    @Override
    @Transactional
    public void deleteConst(int id) {

        constDAO.deleteConst(id);

    }

}

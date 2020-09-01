package com.softserve.edu.greencity.ui.jdbc.dao;

import java.sql.Statement;
import java.util.List;

import com.softserve.edu.greencity.ui.jdbc.entity.EcoNewsEntity;

public class EcoNewsDao {

    public void insert(EcoNewsEntity ecoNewsEntity) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
    }

    public EcoNewsEntity selectById(long id) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
        return null;
    }

    public EcoNewsEntity selectByAuthorId(long id) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
        return null;
    }

    public List<EcoNewsEntity> selectByField(String field, String value) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
        return null;
    }

    public void update(EcoNewsEntity ecoNewsEntity) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
    }

    public void delete(EcoNewsEntity ecoNewsEntity) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
    }

    public void deleteById(long id) {
        Statement statement = ManagerDao.get().getStatement();
        //
        ManagerDao.closeStatement(statement);
    }
}

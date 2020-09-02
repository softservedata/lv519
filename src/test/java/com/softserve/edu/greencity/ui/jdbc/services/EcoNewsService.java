package com.softserve.edu.greencity.ui.jdbc.services;

import java.util.List;

import com.softserve.edu.greencity.ui.jdbc.dao.EcoNewsDao;
import com.softserve.edu.greencity.ui.jdbc.dao.EcoNewsTagsDao;
import com.softserve.edu.greencity.ui.jdbc.entity.EcoNewsEntity;
import com.softserve.edu.greencity.ui.jdbc.entity.EcoNewsTagsEntity;

public class EcoNewsService {
    private EcoNewsDao ecoNewsDao;
    private EcoNewsTagsDao ecoNewsTagsDao;
    
    public EcoNewsService() {
        ecoNewsDao = new EcoNewsDao();
        ecoNewsTagsDao = new EcoNewsTagsDao();
    }
    
    public int getNewsCount() {
        return getAllNews().size();
    }
    
    public List<EcoNewsEntity> getAllNews() {
        return ecoNewsDao.selectAll();
    }
    
    public List<EcoNewsEntity> getNewsByTitle(String title) {
        return ecoNewsDao.selectByTitle(title);
    }
    
    public EcoNewsEntity getNewsById(long id) {
        return ecoNewsDao.selectById(id);
    }
    
    public List<EcoNewsTagsEntity> getNewsTagsByEcoNewsId(long ecoNewsId) {
        return ecoNewsTagsDao.selectByEcoNewsId(ecoNewsId);
    }
    
    public void deleteNewsTagsEntityByEcoNewsId(long ecoNewsId) {
        for (EcoNewsTagsEntity ecoNewsTagsEntity : ecoNewsTagsDao.selectByEcoNewsId(ecoNewsId)) {
            ecoNewsTagsDao.delete(ecoNewsTagsEntity);
        }
    }
    
    public void deleteNewsByTitle(String title) {
        for (EcoNewsEntity ecoNewsEntity : ecoNewsDao.selectByTitle(title)) {
            deleteNewsTagsEntityByEcoNewsId(ecoNewsEntity.getId());
            ecoNewsDao.delete(ecoNewsEntity);
        }
    }
    
}

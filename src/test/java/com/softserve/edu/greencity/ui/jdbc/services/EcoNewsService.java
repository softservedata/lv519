package com.softserve.edu.greencity.ui.jdbc.services;

import com.softserve.edu.greencity.ui.jdbc.dao.EcoNewsDao;

public class EcoNewsService {
    private EcoNewsDao ecoNewsDao;
    
    public EcoNewsService() {
        ecoNewsDao = new EcoNewsDao();
    }
    
    public void deleteByTitle(String title) {
    }
}

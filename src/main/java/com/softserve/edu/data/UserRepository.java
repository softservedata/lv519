package com.softserve.edu.data;

import java.util.List;

public final class UserRepository {

    private static UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser dafault() {
        return customer();
    }

    public IUser customer() {
        return User.get()
                .setFirstname("firstname7")
                .setLastname("lastname7")
                .setLogin("login7")
                .setPassword("password7")
                .setEmail("email7")
                .build();
    }

    public List<IUser> db() {
        return null;
    }
    
    public List<IUser> csv() {
        return null;
    }
    
    public List<IUser> excel() {
        return null;
    }
}

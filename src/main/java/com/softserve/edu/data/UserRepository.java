package com.softserve.edu.data;

import java.util.List;

import com.softserve.edu.tool.CSVReader;
import com.softserve.edu.tool.ExcelReader;

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
    
    public List<IUser> fromCsv(String filename) {
        return User.createUsers(new CSVReader(filename).getAllCells());
    }

    public List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }

    public List<IUser> fromExcel(String filename) {
        return User.createUsers(new ExcelReader(filename).getAllCells());
    }

    public List<IUser> fromExcel() {
        return fromExcel("users.xlsx");
    }
}

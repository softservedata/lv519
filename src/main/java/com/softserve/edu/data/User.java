package com.softserve.edu.data;

import java.util.ArrayList;
import java.util.List;

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    ILogin setLastname(String lastname);
}

interface ILogin {
    IPassword setLogin(String login);
}

interface IPassword {
    IBuildUser setPassword(String password);
}

interface IBuildUser {
    IBuildUser setEmail(String email);
    // 5. Add Builder
    //User build();
    // 6. Add Dependency Inversion
    IUser build();
}

// 5. Add Builder
// 6. Add Dependency Inversion
public class User implements IFirstname, ILastname,
                        ILogin, IPassword, IBuildUser, IUser {

    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email; // Optional

    // 1. Classic. User Constructor
//    public User(String firstname, String lastname, String login, String password, String email) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.login = login;
//        this.password = password;
//        this.email = email;
//    }

    // 2. Use setters
    // public User() {
    private User() {
     // 5. Add Builder
//        firstname = "";
//        lastname = "";
//        login = "";
//        password = "";
        email = ""; // Optional
    }

    // 4. Add Static Factory
    // public static User get() {
    // 5. Add Builder
    public static IFirstname get() {
        return new User();
    }

    // setter

    // 2. Use setters
    // public void setFirstname(String firstname) {
    // 3. Add Fluent Interface
    // public User setFirstname(String firstname) {
    // 5. Add Builder
    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ILogin setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public IBuildUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public IBuildUser setEmail(String email) {
        this.email = email;
        return this;
    }

    // 5. Add Builder
    //public User build() {
    // 6. Add Dependency Inversion
    public IUser build() {
        return this;
    }

    // getters

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // Add equals, hashCode, toString, copareTo
    
    public static IUser createUser(List<String> row) {
        return null;
    }
    
    public static List<IUser> createUsers(List<List<String>> rows) {
        List<IUser> result = new ArrayList<>();
        for (List<String> row : rows) {
            result.add(createUser(row));
        }
        return result;
    }
}

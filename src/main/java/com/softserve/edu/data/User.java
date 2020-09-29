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

enum UserColumns {
    FIRST_NAME(0),
    LAST_NAME(1),
    LOGIN(2),
    PASSWORD(3),
    EMAIL(4);
    //
    private int index;

    private UserColumns(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

// 5. Add Builder
// 6. Add Dependency Inversion
public class User implements IFirstname, ILastname,
                        ILogin, IPassword, IBuildUser, IUser {
    private final static String EMAIL_SEPARATOR = "@";
    private final static String EMPTY_STRING = new String();
    //
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
    
    @Override
    public String toString() {
        return "\nUser [firstname=" + firstname
                + ", lastname=" + lastname
                + ", login=" + login
                + ", password=" + password
                + ", email=" + email
                + "]";
    }
    
    public static IUser createUser(List<String> row) {
        List<String> userData = new ArrayList<>(row);
        for (int i = userData.size(); i < UserColumns.values().length; i++) {
            userData.add(EMPTY_STRING);
        }
        return User.get()
                .setFirstname(userData.get(UserColumns.FIRST_NAME.getIndex()))
                .setLastname(userData.get(UserColumns.LAST_NAME.getIndex()))
                .setLogin(userData.get(UserColumns.LOGIN.getIndex()))
                .setPassword(userData.get(UserColumns.PASSWORD.getIndex()))
                .setEmail(userData.get(UserColumns.EMAIL.getIndex()))
                .build();
    }
    
    public static List<IUser> createUsers(List<List<String>> rows) {
        List<IUser> result = new ArrayList<>();
        String email = rows.get(0).get(UserColumns.EMAIL.getIndex());
        if ((email != null)
                && (!email.contains(EMAIL_SEPARATOR))) {
            rows.remove(0);
        }
        for (List<String> row : rows) {
            result.add(createUser(row));
        }
        return result;
    }
}

package com.softserve.edu.data;

import java.util.List;

public class Appl {
    public static void main(String[] args) {
        // 1. Classic. User Constructor
//        User user = new User("firstname1", "lastname1",
//                "login1", "password1", "email1");
//        System.out.println("user.getLogin() = " + user.getLogin());
        //
        // 2. Use setters
//        User user = new User();
//        user.setFirstname("firstname2");
//        user.setLastname("lastname2");
//        user.setLogin("login2");
//        user.setPassword("password2");
//        user.setEmail("email2");
//        System.out.println("user.getLogin() = " + user.getLogin());
        //
        // 3. Add Fluent Interface
//        User user = new User()
//            .setFirstname("firstname3")
//            .setLastname("lastname3")
//            .setLogin("login3")
//            .setPassword("password3")
//            .setEmail("email3");
//        System.out.println("user.getLogin() = " + user.getLogin());
        //
        // 4. Add Static Factory
//        User user = User.get()
//                .setFirstname("firstname4")
//                .setLastname("lastname4")
//                .setLogin("login4")
//                .setPassword("password4")
//                .setEmail("email4");
//            System.out.println("user.getLogin() = " + user.getLogin());
        //
        // 5. Add Builder
//        User user = User.get()
//                .setFirstname("firstname5")
//                .setLastname("lastname5")
//                .setLogin("login5")
//                .setPassword("password5")
//                .setEmail("email2")
//                .build();
//        System.out.println("user.getLogin() = " + user.setLogin("hahaha")); // Error. Object Update
//        System.out.println("user.getLogin() = " + user.getLogin());
        //
        // 6. Add Dependency Inversion
//        IUser user = User.get()
//                .setFirstname("firstname6")
//                .setLastname("lastname6")
//                .setLogin("login6")
//                .setPassword("password6")
//                .setEmail("email6")
//                .build();
        //System.out.println("user.getLogin() = " + user.setLogin("hahaha")); // Compile Error
        //System.out.println("user.getLogin() = " + ((User) user).setLogin("hahaha")); // Code Smell
//        System.out.println("user.getLogin() = " + user.getLogin());
        //
        // 7.8. Add Singleton; Repository
//        IUser user = UserRepository.get().customer();
//        System.out.println("user.getLogin() = " + user.getLogin());
        // 9. Read from CSV
        List<IUser> users = UserRepository.get().fromExcel();
        System.out.println(users);
    }

}

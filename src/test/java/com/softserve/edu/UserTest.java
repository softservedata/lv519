package com.softserve.edu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.data.IUser;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.tool.ListUtils;

public class UserTest {

//    @DataProvider
//    public Object[][] users() {
//        return new Object[][] { { UserRepository.get().temporary() } };
//    }

    @DataProvider
    public Object[][] users() {
        return ListUtils.toMultiArray(UserRepository.get().fromCsv());
    }
    
    @Test(dataProvider = "users")
    public void checkLogin(IUser user) {
        System.out.println(user);
    }
}

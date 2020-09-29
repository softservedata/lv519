package com.softserve.edu.service;

import com.softserve.edu.dao.IUserDao;
import com.softserve.edu.dao.UserDao;

public class UserService {

	private IUserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}
	
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public String getLastDigits() {
		String origin = getUserDao().getIPAddress();
		return origin.substring(origin.lastIndexOf(".") + 1);
	}

	public String getLastDigits(String text) {
		String origin = getUserDao().getIPAddress(text);
		return origin.substring(origin.lastIndexOf(".") + 1);
	}

}

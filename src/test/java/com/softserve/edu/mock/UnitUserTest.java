package com.softserve.edu.mock;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import com.softserve.edu.dao.IUserDao;
import com.softserve.edu.dao.UserDao;
import com.softserve.edu.service.UserService;

@PrepareForTest(UserService.class)
public class UnitUserTest {

	@ObjectFactory
	public IObjectFactory setObjectFactory() {
		return new PowerMockObjectFactory();
	}
	
	//@Test
	public void checkLastDigits() {
		IUserDao userDao = Mockito.mock(IUserDao.class);
		// IUserDao userDao = Mockito.spy(new UserDao());
		//
		Mockito.when(userDao.getIPAddress()).thenReturn(".1234");
		// Mockito.doCallRealMethod().when(userDao).getIPAddress("");
		UserService userService = new UserService(userDao);
		String actual;
		String expected;
		//
		expected = "1234";
		actual = userService.getLastDigits();
		// actual = userService.getLastDigits("");
		//
		Assert.assertEquals(actual, expected, "LastDigits ERROR");
	}

	//@Test
	public void checkLastDigits1() {
		// IUserDao userDao = Mockito.mock(IUserDao.class);
		IUserDao userDao = Mockito.spy(new UserDao());
		//
		Mockito.when(userDao.getIPAddress()).thenReturn(".1234");
		Mockito.doCallRealMethod().when(userDao).getIPAddress("");
		UserService userService = new UserService(userDao);
		String actual;
		String expected;
		//
		expected = "1234";
		actual = userService.getLastDigits();
		System.out.println("actual = " + actual);
		Assert.assertEquals(actual, expected, "Mock LastDigits ERROR");
		//
		expected = "181";
		actual = userService.getLastDigits("");
		//
		Assert.assertEquals(actual, expected, "LastDigits ERROR");
	}

	@Test
	public void checkLastDigits2() throws Exception {
		UserDao userDao = PowerMockito.mock(UserDao.class);
		//
		PowerMockito.when(userDao.getIPAddress()).thenReturn(".12345");
		PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
		//
		UserService userService = new UserService();
		String actual;
		String expected;
		//
		expected = "12345";
		actual = userService.getLastDigits();
		System.out.println("actual = " + actual);
		Assert.assertEquals(actual, expected, "Mock LastDigits ERROR");
	}
	
	//@Test
	public void checkOutDot() {
		IUserDao userDao = Mockito.mock(IUserDao.class);
		Mockito.when(userDao.getIPAddress()).thenReturn("aaa181");
		UserService userService = new UserService(userDao);
		String actual;
		String expected;
		//
		expected = "aaa181";
		actual = userService.getLastDigits();
		//
		Assert.assertEquals(actual, expected, "LastDigits ERROR");
	}

	// @Test
	public void checkLastDot() {
		IUserDao userDao = Mockito.mock(IUserDao.class);
		Mockito.when(userDao.getIPAddress()).thenReturn("aaa181.");
		UserService userService = new UserService(userDao);
		String actual;
		String expected;
		//
		expected = "";
		actual = userService.getLastDigits();
		//
		Assert.assertEquals(actual, expected, "LastDigits ERROR");
	}

}

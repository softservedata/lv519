package com.softserve.edu;

public class UserRepository {
	private UserRepository() {
	}

	public static User getSignUpValidUser() {
		return new User("testiryna6@gmail.com", "Iryna Polihas", "IrynaPolihas%151091", "IrynaPolihas%151091");
	}

	public static User getSignINValidUser() {
		return new User("testiryna6@gmail.com", "", "IrynaPolihas%151091", "");
	}

	public static User getSignUpInValidUser_WithoutEmail() {
		return new User("", "Iryna Polihas", "IrynaPolihas@151091", "IrynaPolihas%151091");
	}

	public static User getSignUpInValidPassword_WithSpaces() {
		return new User("kushnir.iruna@gmail.com", "Iryna Polihas", "123 Iryna@", "123 Iryna@");
	}

	public static User getSignUpInValidPassword_WithoutUpperCase() {
		return new User("kushnir.iruna@gmail.com", "Iryna Polihas", "aaaaaaa1%", "aaaaaaa1%");
	}

	public static User getSignUpInValidPassword_WithoutLowerCase() {
		return new User("kushnir.iruna@gmail.com", "Iryna Polihas", "WWWWWWW1%", "WWWWWWW1%");
	}

	public static User getSignUpInValidPassword_WithoutDigit() {
		return new User("kushnir.iruna@gmail.com", "Iryna Polihas", "aaaaaaaW!", "aaaaaaaW!");
	}

	public static User getSignUpInValidPassword_WithoutSpecChar() {
		return new User("kushnir.iruna@gmail.com", "Iryna Polihas", "WWWWWWW1u", "WWWWWWW1u");
	}

	public static User getSignUpValidUserGenerated() {
		return new User("kushnir.iruna+" + generateThreeNumber() + "@gmail.com", "Iryna Polihas", "IrynaPolihas%151091",
				"IrynaPolihas%151091");
	}

	public static int generateThreeNumber() {
		int min = 110;
		int max = 115;
		int randomNumber = (int) ((Math.random() * ((max - min) + 1)) + min);
		return randomNumber;

	}
}

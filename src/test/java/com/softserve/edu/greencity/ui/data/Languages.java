package com.softserve.edu.greencity.ui.data;

public enum Languages {
	UKRAINIAN("Uk"),
	RUSSIAN("Ru"),
	ENGLISH("En");
	//
	private String name;

	private Languages(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}

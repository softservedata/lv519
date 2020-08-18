package com.softserve.edu.greencity.ui.pages.habits;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.about.AboutPage;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class MyHabitsPage extends TopPart {

    public MyHabitsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public MyHabitsPage switchLanguage(Languages language) {
        chooseLanguage(language);
        return new MyHabitsPage(driver);
    }

}

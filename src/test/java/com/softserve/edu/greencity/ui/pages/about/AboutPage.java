package com.softserve.edu.greencity.ui.pages.about;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class AboutPage extends TopPart {

    public AboutPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public AboutPage switchLanguage(Languages language) {
        chooseLanguage(language);
        return new AboutPage(driver);
    }

}

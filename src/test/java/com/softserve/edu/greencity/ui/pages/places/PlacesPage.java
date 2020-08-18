package com.softserve.edu.greencity.ui.pages.places;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.about.AboutPage;
import com.softserve.edu.greencity.ui.pages.common.TopPart;

public class PlacesPage extends TopPart {

    public PlacesPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

    public PlacesPage switchLanguage(Languages language) {
        chooseLanguage(language);
        return new PlacesPage(driver);
    }

}

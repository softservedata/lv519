package com.softserve.edu.greencity.ui.pages.tipstricks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.openqa.selenium.WebElement;

public class TipsTricksPage extends TopPart {
    private By tipsTricksLabel;

    public TipsTricksPage(WebDriver driver) {
        super(driver);
        checkElements();
    }

    private void checkElements() {
        //checkElements
        tipsTricksLabel = By.cssSelector("#swiper-wrapper>h2");
    }

    // Page Object
    //tipsTricksLabel
    public WebElement getTipsTricksLabel() {
        return driver.findElement(tipsTricksLabel);
    }

    public String getTipsTricksLabelText() {
        return getTipsTricksLabel().getText();
    }


    // Page Object

    // Functional

    // Business Logic

    public TipsTricksPage switchLanguage(Languages language) {
        chooseLanguage(language);
        return new TipsTricksPage(driver);
    }
}

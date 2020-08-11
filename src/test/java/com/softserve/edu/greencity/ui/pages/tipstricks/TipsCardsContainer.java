package com.softserve.edu.greencity.ui.pages.tipstricks;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TipsCardsContainer extends TipsTricksPage {
    // private WebDriver driver;
    private By nextButton;
    private By prevButton;
    private By tipCards;

    public TipsCardsContainer(WebDriver driver) {
        super(driver);
        checkElements();
    }

    private void checkElements() {
        //checkElements
        nextButton = By.cssSelector("button.button-next");
        prevButton = By.cssSelector("button.button-prev");
        tipCards = By.xpath("//app-tips-card[contains(@class, 'swiper-slide')]");
    }

    //NextButton
    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }

    public void clickNextButton() {
        getNextButton().click();
    }

    public boolean NextButtonIsDisplayed() {
        return getNextButton().isDisplayed();
    }

    //PrevButton
    public WebElement getPrevButton() {
        return driver.findElement(prevButton);
    }

    public void clickPrevButton() {
        getPrevButton().click();
    }

    public boolean prevButtonIsDisplayed() {
        return getPrevButton().isDisplayed();
    }

    //tipCardsContainer
    public List<WebElement> getTipCards() {
        return driver.findElements(tipCards);
    }

    // Functional
    public int getTipCardsSize() {
        return getTipCards().size();
    }

    // Business Logic
    public WebElement getTipCard(int index) {
       if (index>getTipCardsSize()){System.out.println("Error");}
       return getTipCards().get(index);
    }

    public TipsTricksPage tipCardIsDisplayed(WebElement tipCard) {
        boolean isDisplayed = true;
        while (isDisplayed) {
            if (tipCard.isDisplayed()) {
                isDisplayed = false;
            } else clickNextButton();
        }
        return new TipsTricksPage(driver);
    }
}


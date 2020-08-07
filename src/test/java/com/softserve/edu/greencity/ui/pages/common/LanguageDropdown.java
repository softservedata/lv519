package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguageDropdown {
    //
    private WebDriver driver;
    //
    private WebElement enLanguage;
    private WebElement ukLanguage;
    private WebElement ruLanguage;

    public LanguageDropdown(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        enLanguage = driver.findElement(By.xpath("//div[@class='switcher-wrapper']//li[contains(text(),'En')]"));
        ukLanguage = driver.findElement(By.xpath("//div[@class='switcher-wrapper']//li[contains(text(),'Uk')]"));
        ruLanguage = driver.findElement(By.xpath("//div[@class='switcher-wrapper']//li[contains(text(),'Ru')]"));
    }

    // Page Object

    // enLanguage
    public WebElement getEnLanguage() {
        return enLanguage;
    }

    public String getEnLanguageText() {
        return getEnLanguage().getText().trim();
    }

    public void clickEnLanguage() {
        getEnLanguage().click();
    }

    // ukLanguage
    public WebElement getUkLanguage() {
        return ukLanguage;
    }

    public String getUkLanguageText() {
        return getUkLanguage().getText().trim();
    }

    public void clickUkLanguage() {
        getUkLanguage().click();
    }

    // ruLanguage
    public WebElement getRuLanguage() {
        return ruLanguage;
    }

    public String getRuLanguageText() {
        return getRuLanguage().getText().trim();
    }

    public void clickRuLanguage() {
        getRuLanguage().click();
    }

    // Functional

    // Business Logic

}

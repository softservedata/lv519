package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.tools.StableWebElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuDropdown implements StableWebElementSearch {

    private WebDriver driver;
    protected WebDriverWait wait;

    private By naviconButton = By.cssSelector("div.menu-icon");

    private By menuEcoNews = By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/news']");
    private By menuTipsTricks = By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/tips']");
    private By menuMap = By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/map']");
    private By menuAbout = By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/about']");
    private By menuMyHabits = By.cssSelector(".navigation-menu-left > ul > li > a[href*='/profile']");

    private By footerEcoNews = By.cssSelector("app-footer a[href*='/news']");
    private By footerTipsTricks = By.xpath("//div[@class = 'links']//a[contains(text(),'Tips & Tricks')]");
    private By footerPlaces = By.cssSelector("app-footer a[href*='/map']");
    private By footerMyHabits = By.cssSelector("app-footer a[href*='/profile']");
    private By footerAbout = By.cssSelector("app-footer a[href*='/about']");

    public MainMenuDropdown(WebDriver driver) {
        this.driver = driver;
        checkElements();
    }

    private void checkElements() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getMenuEcoNews()));
    }

    public WebElement getNaviconButton() {
        return SearchElementByCss(naviconButton);
    }

    public String getNaviconButtonText() {
        return getNaviconButton().getText();
    }

    public void clickNaviconButton() {
        if (isDisplayedNaviconButton()) {
            getNaviconButton().click();
        }
    }

    public boolean isDisplayedNaviconButton() {
        return getNaviconButton().isDisplayed();
    }

    public WebElement getMenuEcoNews() {
        return SearchElementByCss(menuEcoNews);
    }

    public String getMenuEcoNewsText() {
        return getMenuEcoNews().getText();
    }

    public void clickMenuEcoNews() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/news']")));
        getMenuEcoNews().click();
    }

    public boolean isDisplayedMenuEcoNews() {
        return getMenuEcoNews().isDisplayed();
    }

    public WebElement getMenuTipsTricks() {
        return SearchElementByCss(menuTipsTricks);
    }

    public String getMenuTipsTricksText() {
        return getMenuTipsTricks().getText();
    }

    public void clickMenuTipsTricks() {

        getMenuTipsTricks().click();
    }

    public boolean isDisplayedMenuTipsTricks() {
        return getMenuTipsTricks().isDisplayed();
    }

    public WebElement getMenuMap() {
        return SearchElementByCss(menuMap);
    }

    public String getMenuMapText() {
        return getMenuMap().getText();
    }

    public void clickMenuMap() {
        getMenuMap().click();
    }

    public boolean isDisplayedMenuMap() {
        return getMenuMap().isDisplayed();
    }

    public WebElement getMenuMyHabits() {
        if (!isDisplayedMenuMyCabinet()) {
            clickNaviconButton();
        }
        return SearchElementByCss(menuMyHabits);
    }

    public String getMenuMyCabinetText() {
        return getMenuMyHabits().getText();
    }

    public void clickMenuMyCabinet() {
        getMenuMyHabits().click();
    }

    public boolean isDisplayedMenuMyCabinet() {
        return getMenuMyHabits().isDisplayed();
    }

    public WebElement getMenuAbout() {
        return SearchElementByCss(menuAbout);
    }

    public String getMenuAboutText() {
        return getMenuAbout().getText();
    }

    public void clickMenuAbout() {
        getMenuAbout().click();
    }

    public boolean isDisplayedMenuAbout() {
        return getMenuAbout().isDisplayed();
    }

    public WebElement getFooterEcoNews() {
        return SearchElementByCss(footerEcoNews);
    }

    public String getFooterEcoNewsText() {
        return getFooterEcoNews().getText();
    }

    public void clickFooterEcoNews() {
        getFooterEcoNews().click();
    }

    public WebElement getFooterTipsTricks() {
        return SearchElementByXpath(footerTipsTricks);
    }

    public String getFooterTipsTricksText() {
        return getFooterTipsTricks().getText();
    }

    public void clickFooterTipsTricks() {
        getFooterTipsTricks().click();
    }

    public WebElement getFooterPlaces() {
        return SearchElementByCss(footerPlaces);
    }

    public String getFooterPlacesText() {
        return getFooterPlaces().getText();
    }

    public void clickFooterPlaces() {
        getFooterPlaces().click();
    }

    public WebElement getFooterMyHabits() {
        return SearchElementByCss(footerMyHabits);
    }

    public String getFooterMyCabinetText() {
        return getFooterMyHabits().getText();
    }

    public void clickFooterMyCabinet() {
        getFooterMyHabits().click();
    }

    public WebElement getFooterAbout() {
        return SearchElementByCss(footerAbout);
    }

    public String getFooterAboutText() {
        return getFooterAbout().getText();
    }

    public void clickFooterAbout() {
        getFooterAbout().click();
    }

    public void closeNaviconButton() {
        if (isDisplayedNaviconButton()
                && (isDisplayedMenuEcoNews() || isDisplayedMenuTipsTricks())) {
            clickNaviconButton();
        }
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }

}

package com.softserve.edu.greencity.ui.pages.econews;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage.ArticleFields.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EcoNewsPage extends TopPart {

    public EcoNewsPage(WebDriver driver) {
        super(driver);
        initElements();

    }

    @Getter
    private By header = By.cssSelector("H1");
    @Getter
    private By tagsFilterBlock = By.cssSelector("app-filter-news");
    @Getter
    private By tagsFilterLabel = By.cssSelector("app-filter-news>div.wrapper>span");
    @Getter
    private By tags = By.cssSelector("app-filter-news>div.wrapper>ul>a");
    @Getter
    private By activeTags = By.cssSelector("app-filter-news>div.wrapper>ul>a>li.clicked-filter-button");
    @Getter
    private By uncheckTagButtons = By.cssSelector("app-filter-news>div.wrapper>ul>a>li>div.close");
    @Getter
    private By articleFoundCounter = By.cssSelector("app-remaining-count>p");
    @Getter
    private By displayedArticles = By.cssSelector("ul.list.gallery-view-active > li.gallery-view-li-active");
    @Getter
    private By articleImage = By.cssSelector(" div.list-image>img");
    @Getter
    private By articleEcoButton = By.cssSelector("div.filter-tag>div.ul-eco-buttons");
    @Getter
    private By articleTitle = By.cssSelector("div.added-data>div.title-list>p");
    @Getter
    private By articleText = By.cssSelector(" div.added-data>div.list-text>p");
    @Getter
    private By articleCreationDate = By.cssSelector("div.user-data-added-news>p:first-child");
    @Getter
    private By articleAuthorName = By.cssSelector("div.user-data-added-news>p:last-child");
    @Getter
    private By galleryViewButton = By.cssSelector("div.gallery-view");
    @Getter
    private By listViewButton = By.cssSelector("div.list-view");
    @Getter
    private int articleExistCount;
    @Getter
    private int articleDisplayedCount;

    // Functional
    @Step("Verification of page condition")
    public void pageExistQuickTest() {
        waiting(findElement(header));
        waiting(findElement(tagsFilterBlock));
        waiting(findElement(tagsFilterLabel));
        waiting(findElements(tags));
        waiting(findElement(articleFoundCounter));
        waiting(findElements(displayedArticles));
        waiting(findElement(listViewButton));
        waiting(findElement(galleryViewButton));
    }

    @Step("find element By css")
    public WebElement findElement(By cssSelector) {
        return driver.findElement(cssSelector);
    }

    @Step("Get list of elements by css")
    public List<WebElement> findElements(By cssSelector) {
        return driver.findElements(cssSelector);
    }

    @Step("get content from chosen article in Map format")
    public Map<ArticleFields, WebElement> getContentFromArticle(WebElement element) {
        Map<ArticleFields, WebElement> content = new HashMap<>();
        content.put(IMAGE, element.findElement(articleImage));
        content.put(ECO_BUTTON, element.findElement(articleEcoButton));
        content.put(TITLE, element.findElement(articleTitle));
        content.put(TEXT, element.findElement(articleText));
        content.put(CREATION_DATE, element.findElement(articleCreationDate));
        content.put(AUTHOR_NAME, element.findElement(articleAuthorName));
        return content;
    }

    @Step("Set actual information from page to articleExistCount")
    public EcoNewsPage updateArticlesExistCount() {
        waiting(findElements(displayedArticles));
        articleExistCount = (int) Integer.parseInt(findElement(articleFoundCounter).getText().split(" ")[0]);
        return this;
    }

    @Step("Scroll under end of page")
    public EcoNewsPage scrollDown() {
        waiting(driver.findElement(By.cssSelector("body")));
        while (articleExistCount != articleDisplayedCount) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            articleDisplayedCount = findElements(displayedArticles).size();
        }
        waiting(findElements(displayedArticles));
        return this;
    }

    @Step("switch article sort to gallery format and reassign css")
    public EcoNewsPage swishToGalleryView() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(galleryViewButton).click();
        displayedArticles = By.cssSelector("ul.list.gallery-view-active > li.gallery-view-li-active");
        articleImage = By.cssSelector(" div.list-image>img");
        articleEcoButton = By.cssSelector("div.filter-tag>div.ul-eco-buttons");
        articleTitle = By.cssSelector("div.added-data>div.title-list>p");
        articleText = By.cssSelector(" div.added-data>div.list-text>p");
        articleCreationDate = By.cssSelector("div.user-data-added-news>p:first-child");
        articleAuthorName = By.cssSelector("div.user-data-added-news>p:last-child");
        return this;
    }

    @Step("switch article sort to list format and reassign css")
    public EcoNewsPage swishToListView() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(listViewButton).click();
        displayedArticles = By.cssSelector("ul.list > li.list-view-li-active>app-news-list-list-view>div#list-gallery-content");
        articleImage = By.cssSelector("div.list-image>.list-image-content");
        articleEcoButton = By.cssSelector("div.news-content>div.added-data>div.filter-tag>div.ul-eco-buttons");
        articleTitle = By.cssSelector("div.news-content>div.added-data>div.title-list>p");
        articleText = By.cssSelector("div.news-content>div.added-data>div.list-text>p");
        articleCreationDate = By.cssSelector("div.news-content>div.user-data-added-news>p:first-child");
        articleAuthorName = By.cssSelector("div.news-content>div.user-data-added-news>p:last-child");
        return this;
    }

    @Step("hz")
    private void initElements() {
        // init elements
    }

    //Verifications
    @Step("short explicit wait visibility Of element")
    public EcoNewsPage waiting(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    @Step("short explicit wait visibility Of elements list")
    public EcoNewsPage waiting(List<WebElement> elements) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(elements));
        return this;
    }

    @Step("Verification that all content in the chosen article displayed")
    public boolean isArticleContentDisplayed(WebElement element) {
        return (
                element.findElement(articleImage).isDisplayed() &&
                        element.findElement(articleEcoButton).isDisplayed() &&
                        element.findElement(articleTitle).isDisplayed() &&
                        element.findElement(articleText).isDisplayed() &&
                        element.findElement(articleCreationDate).isDisplayed() &&
                        element.findElement(articleAuthorName).isDisplayed());
    }

    @Step("Verification that all text content in the chosen article displayed")
    public boolean isArticleTextContentDisplayed(WebElement element) {
        return (
                element.findElement(articleTitle).isDisplayed() &&
                        element.findElement(articleText).isDisplayed() &&
                        element.findElement(articleCreationDate).isDisplayed() &&
                        element.findElement(articleAuthorName).isDisplayed());
    }

    @Step("Verification that all content in the list of articles displayed")
    public void isArticleContentDisplayed(List<WebElement> elements) {
        elements.forEach(this::isArticleContentDisplayed);
    }

    @Step("Verification that all text content in the list of articles displayed")
    public void isArticleTextContentDisplayed(List<WebElement> elements) {
        elements.forEach(this::isArticleTextContentDisplayed);
    }


    // Page Object

    public enum ArticleFields {
        IMAGE,
        ECO_BUTTON,
        TITLE,
        TEXT,
        CREATION_DATE,
        AUTHOR_NAME;
    }
}

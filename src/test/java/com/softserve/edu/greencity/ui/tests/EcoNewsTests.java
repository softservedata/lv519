package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage.ArticleFields.TEXT;

public class EcoNewsTests extends GreencityTestRunner {

    @Test
    public void contentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.findElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.findElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleContentDisplayed(elements.get(1));
    }
    @Test
    public void textContentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.findElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.findElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleTextContentDisplayed(elements.get(3));
    }

    @Test
    public void allContentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.findElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.findElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleContentDisplayed(elements);
    }

    @Test
    public void allTextContentDisplayedTest(){
        EcoNewsPage econewsPage = loadApplication().navigateMenuEconews();
        econewsPage.updateArticlesExistCount().scrollDown();
        econewsPage.waiting(econewsPage.findElements(econewsPage.getDisplayedArticles()));
        List<WebElement> elements = econewsPage.findElements(econewsPage.getDisplayedArticles());
        econewsPage.isArticleTextContentDisplayed(elements);
    }
}

package com.softserve.edu.greencity.ui.tests;

import java.util.List;

import com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage;
import com.softserve.edu.greencity.ui.pages.econews.SingleNewsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.econews.NewsData;
import com.softserve.edu.greencity.ui.data.econews.NewsDataRepository;
import com.softserve.edu.greencity.ui.data.econews.Tag;
import com.softserve.edu.greencity.ui.pages.common.WelcomePage;

/**
 * Test cases to test EcoNewsPage
 *
 * @author lv-493
 */
public class EcoNewsPageTest extends GreenCityTestRunner {

    @DataProvider
    public Object[][] newsTags() {
        return new Object[][]{
                {NewsDataRepository.getNewsByTags()}
        };
    }

    @DataProvider
    public Object[][] newsData() {
        return new Object[][]{
                {NewsDataRepository.getExistingNews()}
        };
    }

    //    @Test(dataProvider = "newsData")
    public void ecoNewsSmokeTest(NewsData news) {
        logger.info("ecoNewsSmokeTest starts with parameters: " + news.toString());

        WelcomePage page = loadApplication();
        page.navigateMenuEcoNews()
                .switchToSingleNewsPageByParameters(news)
                .switchToNextSingleNewsPage()
                .switchToEcoNewsPageBack();
    }

    //	@Test(dataProvider = "newsData")
    public void openNewsTest(NewsData news) {
        logger.info("openNewsTest starts with parameters: " + news.toString());

        SingleNewsPage findedeconewspage = loadApplication()
                .navigateMenuEcoNews()
                .switchToSingleNewsPageByParameters(news);

        Assert.assertEquals(news.getTitle(), findedeconewspage.getTitleText(),
                "titles of news does not match:");

    }

    //	@Test(dataProvider = "newsTags")
    public void chooseTags(List<Tag> tags) {
        logger.info("chooseTags starts with parameters: " + tags.toString());

        EcoNewsPage page = loadApplication().navigateMenuEcoNews().selectFilters(tags);

        Assert.assertEquals(page.getItemsContainer().getItemComponentsCount(),
                page.getNumberOfItemComponent(),
                "Number of news items does not match to required:");

    }

//    @Test(dataProvider = "newsTags")
    public void deselectTags(List<Tag> tags) {
        logger.info("deselectTags starts with parameters: " + tags.toString());

        EcoNewsPage page = loadApplication()
                .navigateMenuEcoNews()
                .selectFilters(tags)
                .deselectFilters(tags);

        Assert.assertEquals(page.getItemsContainer().getItemComponentsCount(),
                page.getNumberOfItemComponent(),
                "Number of news items does not match to required:");
    }

    @Test
    public void selectListView() {
        logger.info("selectListView starts");

        EcoNewsPage page = loadApplication()
                .navigateMenuEcoNews()
                .switchToListView();

        Assert.assertTrue(page.isActiveListView(), "List view is not active:");
    }

    @Test
    public void selectGridView() {
        logger.info("selectListView starts");

        EcoNewsPage page = loadApplication()
                .navigateMenuEcoNews()
                .switchToListView()
                .switchToGridView();

        Assert.assertTrue(page.isActiveGridView(), "Grid view is not active:");
    }
}

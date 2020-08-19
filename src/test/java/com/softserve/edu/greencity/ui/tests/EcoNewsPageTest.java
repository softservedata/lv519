package com.softserve.edu.greencity.ui.tests;

import java.util.List;

import com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.econews.NewsData;
import com.softserve.edu.greencity.ui.data.econews.NewsDataRepository;
import com.softserve.edu.greencity.ui.data.econews.Tag;
import com.softserve.edu.greencity.ui.pages.common.WelcomePage;
import com.softserve.edu.greencity.ui.pages.econews.OneNewsPage;

/**
 * Test cases to test EcoNewsPage
 * @author lv-493
 */
public class EcoNewsPageTest extends GreenCityTestRunner {

	@DataProvider
	public Object[][] newsTags() {
		return new Object[][] {
				 {  NewsDataRepository.getNewsByTags() }
			 };
	}

	@DataProvider
	public Object[][] newsData() {
		return new Object[][] {
				 {  NewsDataRepository.getExistingNews() }
			 };
	}

	@Test(dataProvider = "newsData")
	public void ecoNewsSmokeTest(NewsData news) {

		logger.info("ecoNewsSmokeTest starts with parameters: " + news.toString());
		// go to EcoNewsPage -> OneNewsPage -> next OneNewsPage -> return to EcoNewsPage

        WelcomePage page = loadApplication();
        page.navigateMenuEcoNews()
                .switchToSingleNewsPageByParameters(news)
                .switchToNextOneNewsPage()
                .switchToEconewsPageBack();

	}

//    @Test(dataProvider = "newsData")
//    public void ecoNewsSmokeTest(NewsData news) {
//
//        logger.info("ecoNewsSmokeTest starts with parameters: " + news.toString());
//        // go to EcoNewsPage -> OneNewsPage -> next OneNewsPage -> return to EcoNewsPage
//
//        WelcomePage page = loadApplication();
//        page.clickEcoNewsButton()
//                .switchToSingleNewsPageByParameters(news)
//                .switchToNextOneNewsPage()
//                .switchToEconewsPageBack();
//    }

	@Test(dataProvider = "newsData")
	public void openNewsTest(NewsData news) {

		logger.info("openNewsTest starts with parameters: " + news.toString());

		//open onenewspage

		OneNewsPage findedeconewspage = loadApplication()
				.navigateMenuEcoNews()
				.switchToSingleNewsPageByParameters(news);

		// check if is appropriate page

		Assert.assertEquals(news.getTitle(), findedeconewspage.getTitleText(),
				"titles of news does not match:");

	}

	@Test(dataProvider = "newsTags")
	public void chooseTags(List<Tag> tags) {

		logger.info("chooseTags starts with parameters: " + tags.toString());


		//open onenewspage

		EcoNewsPage page = loadApplication().navigateMenuEcoNews().selectFilters(tags);

		// check if is appropriate numbers of news items

		Assert.assertEquals(page.getItemsContainer().getItemComponentsCount(),
				page.getNumberOfItemComponent(),
				"Number of news items does not match to required:");

	}

	@Test(dataProvider = "newsTags")
	public void deselectTags(List<Tag> tags) {

		logger.info("deselectTags starts with parameters: " + tags.toString());

		//open onenewspage

		EcoNewsPage page = loadApplication()
				.navigateMenuEcoNews()
				.selectFilters(tags)
				.deselectFilters(tags);

		// check if is appropriate numbers of news items

		Assert.assertEquals(page.getItemsContainer().getItemComponentsCount(),
				page.getNumberOfItemComponent(),
				"Number of news items does not match to required:");

	}

	@Test
	public void selectListView() {

		logger.info("selectListView starts");
		// open onenewspage

		EcoNewsPage page = loadApplication()
				.navigateMenuEcoNews()
				.switchToListView();

		// check if it  is appropriate view

		Assert.assertTrue(page.isActiveListView(), "List view is not active:");

	}

	@Test
	public void selectGridView() {

		logger.info("selectListView starts");
		// open onenewspage

		EcoNewsPage page = loadApplication()
				.navigateMenuEcoNews()
				.switchToListView()
				.switchToGridView();

		// check if it  is appropriate view

		Assert.assertTrue(page.isActiveGridView(), "Grid view is not active:");

	}

}

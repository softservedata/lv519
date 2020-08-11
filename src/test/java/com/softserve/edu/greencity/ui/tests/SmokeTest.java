package com.softserve.edu.greencity.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.econews.EconewsPage;
import com.softserve.edu.greencity.ui.pages.habits.MyHabitsPage;

public class SmokeTest extends GreencityTestRunner {

    // @Test
    public void checkApp() {
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        Assert.assertTrue(true);
    }

    //@Test
    public void checkLinks() {
        // Check main menu
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateMenuEconews()
                .navigateMenuTipsTricks()
                .navigateMenuPlaces()
                .navigateMenuAbout()
                .navigateMenuMyHabits();
        presentationSleep();
     // Check footer menu
        myHabitsPage
                .footerMenuEconews()
                .footerMenuTipsTricks()
                .footerMenuPlaces()
                .footerMenuAbout()
                .footerMenuMyHabits();
        presentationSleep();
    }

    @DataProvider
    public Object[][] languages() {
        return new Object[][] {
            { Languages.UKRAINIAN },
            { Languages.RUSSIAN }
            };
    }
    //відкрити метод
  /*  //@Test(dataProvider = "languages")
    public void checkLanguage(Languages language) {
        // Check main menu
        EconewsPage EconewsPage = loadApplication()
                .navigateMenuEconews()
                .switchLanguage(language);
        presentationSleep();
        Assert.assertEquals(EconewsPage.getLanguageButtonText(),
                language.toString());
        presentationSleep();
    }*/
    //*******************************************************
    
    /*-
    @DataProvider
    public Object[][] languages() {
        return new Object[][] {
            //{ SearchItemRepository.getMacItem(), SearchRefineRepository.getPriceDescUsd() },
            { Languages.UKRAINIAN }
            };
    }
    
    //@Test(dataProvider = "languages")
    public void checkElements(Languages languages) {
        // Steps
        TipsTricksPage tipstrickspage = loadApplication()
                .switchLanguage(languages);
        presentationSleep();
        //
       // /*-
        System.out.println("is menu Home text: " 
                + homepage.getMainMenuDropdown().getMenuHomeText());
        //
        System.out.println("is menu Home: " 
                + homepage.getMainMenuDropdown().isDisplayedMenuHome());
        System.out.println("is menu EcoNews: " 
                + homepage.getMainMenuDropdown().isDisplayedMenuEcoNews());
        System.out.println("is menu NaviconButton: " 
                + homepage.getMainMenuDropdown().isDisplayedNaviconButton());
      //  * /
        //
        tipstrickspage = tipstrickspage
                .navigateMenuEconews()
                .navigateMenuTipsTricks()
                .navigateMenuMap()
                .navigateMenuMyCabinet()
                .navigateMenuAbout()
                .navigateMenuTipsTricks();
        //
    //      TopPart tp = tipstrickspage;
    //      tp = tp.navigateMenuEconews();
    //      presentationSleep(2);
    //      tp = tp.navigateMenuTipsTricks();
    //      presentationSleep(2);
    //      tp = tp.navigateMenuMyCabinet();
    //      presentationSleep(2);
    //      tp = tp.navigateMenuMap();
        //
        // Check
    //      Assert.assertEquals(tipstrickspage.getLanguageSwitcherText(),
    //              Languages.UKRAINIAN.toString());
        //
        // Return to Previous State
        presentationSleep();
    }
    
    @DataProvider
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.get().temporary() }
            };
    }
    
    //@Test(dataProvider = "users")
    public void checkLogin(User user) {
        TipsTricksPage tipstrickspage = loadApplication()
                .signin()
                .successfullyLogin(user);
        System.out.println("name = " + tipstrickspage.getTopUserName());
        Assert.assertEquals(tipstrickspage.getTopUserName(),
                TopPart.PROFILE_NAME);
                //user.getFirstname());
        tipstrickspage.signout();
    }
    
    //    @Test(dataProvider = "users")
    public void checkCabinet(User user) {
        MyCabinetPage myCabinetPage = loadApplication()
                .navigateMenuMyCabinet(user);
        presentationSleep();
        //
        Assert.assertEquals(myCabinetPage.getTopUserName(), TopPart.PROFILE_NAME);
        // user.getFirstname());
        presentationSleep();
        //
        myCabinetPage = myCabinetPage
                .navigateMenuTipsTricks()
                .navigateMenuEconews()
                .navigateMenuMyCabinet();
        presentationSleep();
        //
        TipsTricksPage tipstrickspage = myCabinetPage
                .signout();
        presentationSleep();
        LoginPage loginPage = tipstrickspage
                .navigateMenuMyCabinetGuest();
        presentationSleep(4);
    }
       */
}

package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.greencity.ui.data.Languages;
import com.softserve.edu.greencity.ui.pages.about.AboutPage;
import com.softserve.edu.greencity.ui.pages.econews.EcoNewsPage;
import com.softserve.edu.greencity.ui.pages.habits.MyHabitsPage;
import com.softserve.edu.greencity.ui.pages.places.PlacesPage;
import com.softserve.edu.greencity.ui.pages.tipstricks.TipsTricksPage;

/**
 * Base Abstract Class of Header and Footer.
 * 
 * @author Lv-519.Taqc/Java
 */
public abstract class TopPart {

//     TODO to delete
//    public static final String PROFILE_NAME = "Nadiia Steblivets";
    //
//    private final int WINDOW_WIDTH_TO_SCROLL = 1024;
//    private final int WINDOW_HEIGHT_TO_CLICK_FOOTER = 480;
    //
    protected final String OPTION_NULL_MESSAGE = "DropdownComponent is null";
    // protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in
    // %s";
    // protected final String PAGE_DO_NOT_EXIST="Page do not exist!!!";
    //
    // protected final String TAG_ATTRIBUTE_VALUE = "value";
    // protected final String TAG_ATTRIBUTE_SRC = "src";
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;
    //
    private WebElement languageButton;
    //private LanguageDropdown languageDropdown;
    private WebElement copyright;
    //
    private MainMenuDropdown mainMenuDropdown;
    private TopGuestComponent topGuestComponent;
    private TopUserComponent topUserComponent;
    //
    // private LoginDropdown loginDropdown;
    // private RegisterDropdown registerDropdown;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        initElements();
        // initComponents();
    }

    private void initElements() {
        languageButton = driver.findElement(By.cssSelector("div.switcher-wrapper ul li"));
        // languageDropdown = new LanguageDropdown(driver);
        mainMenuDropdown = new MainMenuDropdown(driver);
        copyright = driver.findElement(By.cssSelector("div.bottom-part"));
    }

    // Page Object

    // languageButton

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public String getLanguageButtonText() {
        return getLanguageButton().getText().trim();
    }

//    protected void setLanguageSwitcher(String text) {
//        getLanguageSwitcher().selectByVisibleText(text);
//    }

    protected void clickLanguageButton() {
        getLanguageButton().click();
    }

    // copyright
    public WebElement getCopyright() {
        return copyright;
    }

    public String getCopyrightText() {
        return getCopyright().getText();
    }

    public void clickCopyright() {
        getCopyright().click();
    }

    // mainMenuDropdown
    public MainMenuDropdown getMainMenuDropdown() {
        return mainMenuDropdown;
    }

    // Functional

    // topGuestComponent;
    protected TopGuestComponent getTopGuestComponent() {
        if (topGuestComponent == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return topGuestComponent;
    }
    
    protected TopGuestComponent createTopGuestComponent() {
        topGuestComponent = new TopGuestComponent(driver);
        return getTopGuestComponent();
    }
    
    protected void clickTopGuestSignin() {
        getTopGuestComponent().clickSigninLink();
        // topGuestComponent = null;
    }
    
    protected void clickTopGuestSignup() {
        getTopGuestComponent().clickSignupLink();
        // topGuestComponent = null;
    }
    
    protected void closeTopGuestComponent() {
        // clickSearchTopField();
        topGuestComponent = null;
    }
    
    // topUserComponent
    protected TopUserComponent getTopUserComponent() {
        if (topUserComponent == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return topUserComponent;
    }
    
    protected TopUserComponent createTopUserComponent() {
        topUserComponent = new TopUserComponent(driver);
        return getTopUserComponent();
    }
    
    public String getTopUserName() {
        // TODO
        // getTopUserComponent().getUserNameButtonText();
        return createTopUserComponent().getUserNameButtonText();
    }
    
    /*-
    protected void clickTopUserFavoritePlaces() {
        getTopUserComponent().clickProfileDropdownFavoritePlaces();
        // topGuestComponent = null;
    }
    */
    
    protected void clickTopUserSettings() {
        getTopUserComponent().clickProfileDropdownUserSettings();
        // topGuestComponent = null;
    }
    
    // TODO
    protected void clickTopUserSignout() {
        getTopUserComponent().clickProfileDropdownSignout();
        // topGuestComponent = null;
    }
    
    protected void closeTopUserComponent() {
        // clickSearchTopField();
        topUserComponent = null;
    }

    // language
    protected void chooseLanguage(Languages language) {
        clickLanguageButton();
        LanguageDropdown languageDropdown = new LanguageDropdown(driver);
        languageDropdown.chooseByLanguage(language);
    }

    /*-
    protected void scrollDown() {
        // System.out.println("driver.manage().window().getSize()" +
        // driver.manage().window().getSize());
        if (driver.manage().window().getSize().width < WINDOW_WIDTH_TO_SCROLL) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", getCopyright());
        }
    }
    
    protected boolean isMenuClickable() {
        return driver.manage().window().getSize().height > WINDOW_HEIGHT_TO_CLICK_FOOTER;
    }
    */

    // Business Logic

    public EcoNewsPage navigateMenuEconews() {
        getMainMenuDropdown().clickMenuEcoNews();
        return new EcoNewsPage(driver);
    }

    public TipsTricksPage navigateMenuTipsTricks() {
        getMainMenuDropdown().clickMenuTipsTricks();
        return new TipsTricksPage(driver);
    }

    public PlacesPage navigateMenuPlaces() {
        getMainMenuDropdown().clickMenuPlaces();
        return new PlacesPage(driver);
    }

    public AboutPage navigateMenuAbout() {
        getMainMenuDropdown().clickMenuAbout();
        return new AboutPage(driver);
    }

    public MyHabitsPage navigateMenuMyHabits() {
        getMainMenuDropdown().clickMenuMyHabits();
        return new MyHabitsPage(driver);
    }

    public EcoNewsPage footerMenuEconews() {
        getMainMenuDropdown().clickFooterEcoNews();
        return new EcoNewsPage(driver);
    }

    public TipsTricksPage footerMenuTipsTricks() {
        getMainMenuDropdown().clickFooterTipsTricks();
        return new TipsTricksPage(driver);
    }

    public PlacesPage footerMenuPlaces() {
        getMainMenuDropdown().clickFooterPlaces();
        return new PlacesPage(driver);
    }

    public AboutPage footerMenuAbout() {
        getMainMenuDropdown().clickFooterAbout();
        return new AboutPage(driver);
    }

    public MyHabitsPage footerMenuMyHabits() {
        getMainMenuDropdown().clickFooterMyHabits();
        return new MyHabitsPage(driver);
    }

}

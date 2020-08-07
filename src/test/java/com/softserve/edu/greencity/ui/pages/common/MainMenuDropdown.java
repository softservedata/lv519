package com.softserve.edu.greencity.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainMenuDropdown {

	private WebDriver driver;
	//
	private WebElement naviconButton;
	//
	private WebElement menuEcoNews;
	private WebElement menuTipsTricks;
	private WebElement menuPlaces;
    private WebElement menuAbout;
	private WebElement menuMyHabits;
	//
	private WebElement footerEcoNews;
	private WebElement footerTipsTricks;
	private WebElement footerPlaces;
	private WebElement footerMyHabits;
	private WebElement footerAbout;
	
	public MainMenuDropdown(WebDriver driver) {
		this.driver = driver;
		initElements();
        //checkElements();
	}

	private void initElements() {
		// init elements
		naviconButton = driver.findElement(By.cssSelector("div.menu-icon"));
		menuEcoNews = driver.findElement(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/news']"));
		menuTipsTricks = driver.findElement(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/tips']"));
		menuPlaces = driver.findElement(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/map']"));
        menuAbout = driver.findElement(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/about']"));
		//menuMyHabits = driver.findElement(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/welcome']"));
        menuMyHabits = driver.findElement(By.cssSelector("div.navigation-menu-left > ul > li > a[href*='/map']"));
		//
		footerEcoNews = driver.findElement(By.cssSelector("div.app-footer a[href*='/news']"));
		footerTipsTricks = driver.findElement(By.xpath("//div[@class='app-footer']//a[contains(@href, '/news')]/../following-sibling::li/a[@href='']"));
		footerPlaces = driver.findElement(By.cssSelector("div.app-footer a[href*='/map']"));
        footerAbout = driver.findElement(By.cssSelector("div.app-footer a[href*='/about']"));
		//footerMyHabits = driver.findElement(By.cssSelector("div.app-footer li a[href*='/welcome']"));
        footerMyHabits = driver.findElement(By.cssSelector("div.app-footer li a[href*='/news']"));
	}

	// Page Object
	
	// naviconButton
	public WebElement getNaviconButton() {
		//return driver.findElement(By.cssSelector("div.menu-icon"));
                // return search.find(byNaviconButton) // byNaviconButton = By.cssSelector("div.menu-icon")
        return naviconButton;
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
    
    
    // menuEcoNews
    public WebElement getMenuEcoNews() {
    	if (!isDisplayedMenuEcoNews()) {
    		clickNaviconButton();
    	}
        return menuEcoNews;
    }

    public String getMenuEcoNewsText() {
        return getMenuEcoNews().getText();
    }

    public void clickMenuEcoNews() {
    	getMenuEcoNews().click();
    }

    public boolean isDisplayedMenuEcoNews() {
        //return getMenuEcoNews().isDisplayed();
    	return menuEcoNews.isDisplayed();
    }
    
    // menuTipsTricks
    public WebElement getMenuTipsTricks() {
    	if (!isDisplayedMenuTipsTricks()) {
    		clickNaviconButton();
    	}
        return menuTipsTricks;
    }

    public String getMenuTipsTricksText() {
        return getMenuTipsTricks().getText();
    }

    public void clickMenuTipsTricks() {
    	getMenuTipsTricks().click();
    }

    public boolean isDisplayedMenuTipsTricks() {
        //return getMenuTipsTricks().isDisplayed();
    	return menuTipsTricks.isDisplayed();
    }

    // menuPlaces
    public WebElement getMenuPlaces() {
    	if (!isDisplayedMenuPlaces()) {
    		clickNaviconButton();
    	}
        return menuPlaces;
    }

    public String getMenuPlacesText() {
        return getMenuPlaces().getText();
    }

    public void clickMenuPlaces() {
    	getMenuPlaces().click();
    }

    public boolean isDisplayedMenuPlaces() {
        //return getMenuMap().isDisplayed();
    	return menuPlaces.isDisplayed();
    }

    // menuMyHabits
    public WebElement getMenuMyHabits() {
    	//System.out.println("isDisplayedMenuMyCabinet() = " + isDisplayedMenuMyCabinet());
    	if (!isDisplayedMenuMyHabits()) {
    		clickNaviconButton();
    		//System.out.println("clickNaviconButton() DONE");
    	}
    	//System.out.println("isDisplayedMenuMyCabinet() = " + isDisplayedMenuMyCabinet());
        return menuMyHabits;
    }

    public String getMenuMyHabitsText() {
        return getMenuMyHabits().getText();
    }

    public void clickMenuMyHabits() {
    	getMenuMyHabits().click();
    }

    public boolean isDisplayedMenuMyHabits() {
        //return getMenuMycabinet().isDisplayed();
    	return menuMyHabits.isDisplayed();
    }

    // menuAbout
    public WebElement getMenuAbout() {
    	if (!isDisplayedMenuAbout()) {
    		clickNaviconButton();
    	}
        return menuAbout;
    }

    public String getMenuAboutText() {
        return getMenuAbout().getText();
    }

    public void clickMenuAbout() {
    	getMenuAbout().click();
    }

    public boolean isDisplayedMenuAbout() {
        //return getMenuAbout().isDisplayed();
    	return menuAbout.isDisplayed();
    }

    // footerEcoNews
	public WebElement getFooterEcoNews() {
		return footerEcoNews;
	}

	public String getFooterEcoNewsText() {
		return getFooterEcoNews().getText();
	}

	public void clickFooterEcoNews() {
		getFooterEcoNews().click();
	}
     
    // footerTipsTricks
	public WebElement getFooterTipsTricks() {
		return footerTipsTricks;
	}

	public String getFooterTipsTricksText() {
		return getFooterTipsTricks().getText();
	}

	public void clickFooterTipsTricks() {
		getFooterTipsTricks().click();
	}
         
    // footerMap
	public WebElement getFooterPlaces() {
		return footerPlaces;
	}

	public String getFooterPlacesText() {
		return getFooterPlaces().getText();
	}

	public void clickFooterPlaces() {
		getFooterPlaces().click();
	}
             
    // footerMyCabinet
	public WebElement getFooterMyHabits() {
		return footerMyHabits;
	}

	public String getFooterMyHabitsText() {
		return getFooterMyHabits().getText();
	}

	public void clickFooterMyHabits() {
		getFooterMyHabits().click();
	}                
    
    // footerAbout
	public WebElement getFooterAbout() {
		return footerAbout;
	}

	public String getFooterAboutText() {
		return getFooterAbout().getText();
	}

	public void clickFooterAbout() {
		getFooterAbout().click();
	}                     
    
    // Functional
	
	public void closeNaviconButton() {
		if (isDisplayedNaviconButton() 
				&& (isDisplayedMenuEcoNews() || isDisplayedMenuTipsTricks())) {
			clickNaviconButton();
		}
	}

	// Business Logic
}

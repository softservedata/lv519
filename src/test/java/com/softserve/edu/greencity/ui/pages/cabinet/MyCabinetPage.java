package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.StableWebElementSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyCabinetPage extends TopPart implements StableWebElementSearch {
    protected WebDriverWait wait;

    private By addNewHabitButton = By.xpath("//*[@id = 'create-button']");
    private HabitsContainer habitsContainer;
    private MyGoalsContainer goalsContainer;

    public MyCabinetPage(WebDriver driver) {
        super(driver);
        checkElements();
    }

    private void checkElements() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(getAddNewHabitButton()));
    }

    public HabitsContainer getHabitsContainer() {
        return habitsContainer = new HabitsContainer(driver);
    }

    public MyGoalsContainer getGoalsContainer() {
        return goalsContainer = new MyGoalsContainer(driver);
    }

    public WebElement getAddNewHabitButton() {
        return SearchElementByXpath(addNewHabitButton);
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}

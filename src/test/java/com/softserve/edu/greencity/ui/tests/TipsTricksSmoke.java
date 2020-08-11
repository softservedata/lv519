package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsCardsContainer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TipsTricksSmoke extends GreencityTestRunner {
    private final String TipsTricksLabelText = "Tips & Tricks";
    @Test
    public void checkTipsTricks() {
        // Check TipsTricks
        TipsCardsContainer tipsTricksPage = new TipsCardsContainer(driver);
        tipsTricksPage.navigateMenuTipsTricks();
        Assert.assertTrue(tipsTricksPage.getTipsTricksLabelText().contains(TipsTricksLabelText));
        Assert.assertTrue(tipsTricksPage.prevButtonIsDisplayed());
        Assert.assertTrue(tipsTricksPage.NextButtonIsDisplayed());
        tipsTricksPage.tipCardIsDisplayed(tipsTricksPage.getTipCard());
        presentationSleep();
    }
}

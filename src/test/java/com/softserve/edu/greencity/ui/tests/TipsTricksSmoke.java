package com.softserve.edu.greencity.ui.tests;

import com.softserve.edu.greencity.ui.pages.tipstricks.TipsCardsContainer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TipsTricksSmoke extends GreencityTestRunner {
    private final String TIPS_TRICKS_LABEL_TEXT = "Tips & Tricks";
    private final int TIP_CARD_INDEX = 10;
    @Test
    public void checkTipsTricks() {
        // Check TipsTricks
        TipsCardsContainer tipsTricksPage = new TipsCardsContainer(driver);
        tipsTricksPage.navigateMenuTipsTricks();
        Assert.assertTrue(tipsTricksPage.getTipsTricksLabelText().contains(TIPS_TRICKS_LABEL_TEXT));
        Assert.assertTrue(tipsTricksPage.prevButtonIsDisplayed());
        Assert.assertTrue(tipsTricksPage.NextButtonIsDisplayed());
        tipsTricksPage.tipCardIsDisplayed(tipsTricksPage.getTipCard(TIP_CARD_INDEX));
        presentationSleep();
    }
}

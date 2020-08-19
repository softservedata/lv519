package com.softserve.edu.greencity.ui.pages.econews;

import com.softserve.edu.greencity.ui.data.econews.NewsData;
import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.StableWebElementSearch;
import com.softserve.edu.greencity.ui.tools.UploadFileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

/**
 * CreateNewsPage class
 *
 * @author lv-493 Taqc/Java
 */
public class CreateNewsPage extends TopPart implements StableWebElementSearch {

    private final String VALUE_ATTRIBUTE = "value";
    private final String CLASS_ATTRIBUTE = "class";
    private TagsComponent tagsComponent;
    private By titleField = By.cssSelector("input[formcontrolname='title']");
    private By sourceField = By.cssSelector("div[formarrayname='tags']+label > input");
    private By contentField = By.cssSelector("div.textarea-wrapper > textarea");
    private By dateField = By.cssSelector("div.date > p:first-child > span");
    private By authorField = By.cssSelector("div.date > :nth-child(2n) > span");
    private By cancelButton = By.cssSelector("div.submit-buttons > :first-child");
    private By previewButton = By.cssSelector("div.submit-buttons > :first-child+button");
    private By publishButton = By.cssSelector("div.submit-buttons > button[type='submit']");
    private By dropArea = By.cssSelector("div.text-wrapper, div.ng-star-inserted > img");
    private By titleDescription = By.cssSelector("input[formcontrolname='title'] + span");
    private By tagsDescription = By.cssSelector("div.tags > button + p");
    private By sourceDescription = By.cssSelector("div[formarrayname='tags']+label > input + span");
    private By contentDescription = By.cssSelector("p.textarea-description");
    private By pictureDescription = By.xpath("//div[@class = 'text-wrapper']/../../div/../span | //div[@class = 'ng-star-inserted']/../span");

    public CreateNewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        tagsComponent = new TagsComponent(driver);
    }

    public TagsComponent getTagsComponent() {
        tagsComponent = new TagsComponent(driver);
        return tagsComponent;
    }

    private WebElement getTitleField() {
        return SearchElementByCss(titleField);
    }

    public void setTitleField(String text) {
        getTitleField().sendKeys(text);
    }

    public String getTitleFieldText() {
        return getTitleField().getText();
    }

    public String getTitleFieldValue() {
        return getTitleField().getAttribute(VALUE_ATTRIBUTE);
    }

    public void clearTitleField() {
        getTitleField().clear();
    }

    public void clickTitleField() {
        getTitleField().click();
    }

    public WebElement getSourceField() {
        return SearchElementByCss(sourceField);
    }

    public void setSourceField(String text) {
        getSourceField().sendKeys(text);
    }

    public String getSourceFieldText() {
        return getSourceField().getText();
    }

    public String getSourceFieldValue() {
        return getSourceField().getAttribute(VALUE_ATTRIBUTE);
    }

    public void clearSourceField() {
        getSourceField().clear();
    }

    public void clickSourceField() {
        getSourceField().click();
    }

    public WebElement getContentField() {
        return SearchElementByCss(contentField);
    }

    public void setContentField(String text) {
        getContentField().sendKeys(text);
    }

    public String getContentFieldText() {
        return getContentField().getText();
    }

    public String getContentFieldValue() {
        return getContentField().getAttribute(VALUE_ATTRIBUTE);
    }

    public void clearContentField() {
        getContentField().clear();
    }

    public void clickContentField() {
        getContentField().click();
    }

    public WebElement getDateField() {
        return SearchElementByCss(dateField);
    }

    public String getDateFieldText() {
        return getDateField().getText();
    }

    public WebElement getAuthorField() {
        return SearchElementByCss(authorField);
    }

    public String getAuthorFieldText() {
        return getAuthorField().getText();
    }

    public WebElement getCancelButton() {
        return SearchElementByCss(cancelButton);
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }

    public WebElement getPreviewButton() {
        return SearchElementByCss(previewButton);
    }

    public void clickPreviewButton() {
        getPreviewButton().click();
    }

    public WebElement getPublishButton() {
        return SearchElementByCss(publishButton);
    }

    public void clickPublishButton() {
        getPublishButton().click();
    }

    public boolean isPublishButtonClickable() {
        return getPublishButton().isEnabled();
    }

    public WebElement getDropArea() {
        return SearchElementByCss(dropArea);
    }

    public Boolean isPictureUploaded() {
        return getDropArea().getAttribute(CLASS_ATTRIBUTE).contains("ng-star-inserted");
    }

    public WebElement getTitleDescription() {
        return SearchElementByCss(titleDescription);
    }

    public boolean isTitleDescriptionWarning() {
        return getTitleField().getAttribute(CLASS_ATTRIBUTE).contains("invalid");
    }

    public WebElement getSourceDescription() {
        return SearchElementByCss(sourceDescription);
    }

    public boolean isSourceDescriptionWarning() {
        return getSourceDescription().getAttribute(CLASS_ATTRIBUTE).contains("warning");
    }

    public WebElement getContentDescription() {
        return SearchElementByCss(contentDescription);
    }

    public boolean isContentDescriptionWarning() {
        return getContentField().getAttribute(CLASS_ATTRIBUTE).contains("invalid");
    }

    public WebElement getPictureDescription() {
        return SearchElementByXpath(pictureDescription);
    }

    public boolean isPictureDescriptionWarning() {
        return getPictureDescription().getAttribute(CLASS_ATTRIBUTE).contains("warning-color");
    }

    public WebElement getTagsDescription() {
        return SearchElementByCss(tagsDescription);
    }

    public boolean isTagsDescriptionWarning() {
        return getTagsDescription().getAttribute(CLASS_ATTRIBUTE).contains("warning");
    }

    // Functional

    // Drop and upload file
    public CreateNewsPage uploadFile(WebElement dropArea, String path) {
        String absolutePath = new File(path).getAbsolutePath();
        UploadFileUtil.DropFile(new File(absolutePath), dropArea, 0, 0);
        try {
            driver.findElements(By.cssSelector(".cropper-buttons button")).get(0).click();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Method to fill all fields in CreateNewsPage or only required
     *
     * @param newsData
     * @return CreateNewsPage
     */

    public CreateNewsPage fillFields(NewsData newsData) {
        clearTitleField();
        setTitleField(newsData.getTitle());
        clearContentField();
        setContentField(newsData.getContent());
        tagsComponent.selectTags(newsData.getTags());
        if (!newsData.getSource().equals("")) {
            clearSourceField();
            setSourceField(newsData.getSource());
        }
        if (!newsData.getFilePath().equals("")) {
            uploadFile(getDropArea(), newsData.getFilePath());
        }
        return this;
    }
    // Business Logic

    /**
     * Method to get list of selected tags names from TagsComponent
     *
     * @return List<String>
     */
    public List<String> getSelectedTagsNames() {
        return tagsComponent.getTagsNames(tagsComponent.getSelectedTagsButtons());
    }

    /**
     * Method to open PreViewPage
     *
     * @return PreViewPage
     */
    public PreViewPage goToPreViewPage() {
        clickPreviewButton();
        return new PreViewPage(driver);
    }

    /**
     * Method to Publish news
     *
     * @return EcoNewsPage
     */
    public EcoNewsPage publishNews() {  //FIXME return type should be changed to EcoNewsPage
        clickPublishButton();
        try {
            new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.container div.people-img"))));
            new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.container div.people-img"))));
        } catch (Exception e) {
            System.out.println("Publish Button(((((");
            e.printStackTrace();
        }
        return new EcoNewsPage(driver);
    }

    /**
     * Method to cancel news creation
     * by clicking Cancel button in IFrame
     *
     * @return EcoNewsPage
     */
    public EcoNewsPage cancelNewsCreating() {
        clickCancelButton();
        CancelFrame cancelFrame = new CancelFrame(driver);
        return cancelFrame.clickCancelEditingButton();
    }

    /**
     * Method to continue news creation after clicking Cancel button
     * by clicking ContinueEditing button in IFrame
     *
     * @return CreateNewsPage
     */
    public CreateNewsPage continueNewsCreating() {
        clickCancelButton();
        CancelFrame cancelFrame = new CancelFrame(driver);
        return cancelFrame.clickContinueEditingButton();
    }

    /**
     * CancelFrame class
     * Nested class that appears after clicking on Cancel button
     */
    private class CancelFrame {

        private WebElement continueEditingButton;
        private WebElement cancelEditingButton;

        /**
         * Constructor CancelFrame
         *
         * @param driver
         */
        public CancelFrame(WebDriver driver) {
            initElements(driver);
        }

        private void initElements(WebDriver driver) {
            continueEditingButton = driver.findElement(By.cssSelector("div.continue-btn > button"));
            cancelEditingButton = driver.findElement(By.cssSelector("button.primary-global-button"));
        }

        private WebElement getContinueEditingButton() {
            return continueEditingButton;
        }

        private WebElement getCancelEditingButton() {
            return cancelEditingButton;
        }

        /**
         * Method to continue news creation after clicking Continue editing button
         *
         * @return CreateNewsPage
         */
        public CreateNewsPage clickContinueEditingButton() {
            getContinueEditingButton().click();
            return new CreateNewsPage(driver);
        }

        /**
         * Method to cancel news creation after clicking "Yes, cancel" button
         *
         * @return EcoNewsPage
         */
        public EcoNewsPage clickCancelEditingButton() {
            getCancelEditingButton().click();
            return new EcoNewsPage(driver);
        }
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }

}
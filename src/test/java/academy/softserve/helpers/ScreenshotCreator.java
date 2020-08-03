package academy.softserve.helpers;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotCreator {
    @Step("Take screenShot")
    public void screenshot(WebDriver driver) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String screenshotName = formatter.format(date).replace(":", "-").replace("\\s+", "-");
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Pavel\\Pictures\\Selenium\\GreenCity" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Take screenShot with before/after delay")
    public void screenshot(WebDriver driver, int screenShotSecondsDelayBefore, int screenShotSecondsDelayAfter) {
        wait(screenShotSecondsDelayBefore);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String screenshotName = formatter.format(date).replace(":", "-").replace("\\s+", "-");
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Pavel\\Pictures\\Selenium\\GreenCity" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait(screenShotSecondsDelayAfter);
    }

    @Step("set delay")
    public void wait(int secondsDelay){
        try {
            Thread.sleep((secondsDelay) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


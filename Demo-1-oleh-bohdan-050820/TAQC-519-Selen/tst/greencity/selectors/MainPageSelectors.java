package greencity.selectors;

public class MainPageSelectors {
public static final String signUpButton="//li[@class='sign-up-link ng-star-inserted']//span[contains(text(),'Sign up')]";
public static final String randomEmail=getRandomMail();
public static String getRandomMail() {
    return String.format("%s, %d", "+", (int) (Math.random() * ((Integer.MAX_VALUE - 1) - 10 + 1) + 1))
            .replaceAll("\\s+", "")
            .replace("-", "")
            .replace(",", "");
}
}

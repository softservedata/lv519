package academy.softserve.constantParameters;
public enum SingUpFieldsSelectorsValue {
    /**
     Constants and selectors
     */
    EMAIL("email"),
    USER_NAME("fistName"),
    PASSWORD("form-control password"),
    PASSWORD_CONFIRM("form-control password-confirm"),
    SING_UP_BUTTON("//button[contains(text(),'Sign Up')]"),
    H1("//h1[contains(text(),'Hello!')]"),
    H2("//h2[@class='subtitle-text']"),
    SPAN("//span[contains(text(),'Do you already have an account?')]"),
    SING_IN_LINK("//a[@class='exist-sign-in']"),
    EMAIL_WRONG_FORMAT("email");
    private String value;

    SingUpFieldsSelectorsValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

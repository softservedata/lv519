package academy.softserve.constantParameters.sing.up;

public enum Links {
    CONFIRMATION_REGEX_TEMPLATE("https://greencity.azurewebsites.net/ownSecurity/verifyEmail\\?token=([-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])"),
    MAIL_SUBJECT_NAME("Verify your email address");
    private String value;

    Links(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

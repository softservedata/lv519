package academy.softserve.constantParameters.sing.up;

public enum SelectorsValue {
    EMAIL("email"),
    USER_NAME("fistName"),
    PASSWORD("form-control password"),
    PASSWORD_CONFIRM("form-control password-confirm"),
    SING_UP_BUTTON("//button[contains(text(),'Sign Up')]");

    private String value;

    SelectorsValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

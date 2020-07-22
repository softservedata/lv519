package academy.softserve.constantParameters;

public enum SingUpFieldsSelectorsValue {

    EMAIL("email"),
    USER_NAME("fistName"),
    PASSWORD("form-control password"),
    PASSWORD_CONFIRM("form-control password-confirm");
    private String value;

    SingUpFieldsSelectorsValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

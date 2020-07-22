package academy.softserve.constantParameters;

public enum BaseLink {
    URL("https://ita-social-projects.github.io/GreenCityClient/#/welcome");
    private String value;

    BaseLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

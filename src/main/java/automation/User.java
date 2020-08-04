package automation;

public class User {

    private String userEmail;
    private String userName;
    private String userPassword;
    private String userConfirmPassword;

    public User setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public User setUserConfirmPassword(String userConfirmPassword) {
        this.userConfirmPassword = userConfirmPassword;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserConfirmPassword() {
        return userConfirmPassword;
    }
}

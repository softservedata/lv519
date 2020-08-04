package automation;

public class Message {

    final String passwordsDoNotMatchMessage;
    final String userNameRequiredMessage;
    final String signUpPageOpenMessage;
    final String mainPageOpenMessage;

    public Message(){
        passwordsDoNotMatchMessage = "Passwords do not match";
        signUpPageOpenMessage = " Sign Up ";
        mainPageOpenMessage = "A new way to cultivate useful habits";
        userNameRequiredMessage = "User name is required";
    }
}

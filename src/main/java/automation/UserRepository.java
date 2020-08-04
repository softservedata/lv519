package automation;

public final class UserRepository {

    private UserRepository() {

    }

    public static User getDefault() {
        return getValidUser();
    }

    public static User getValidUser() {
        return new User()
                .setUserEmail("Voronovsky@gmail.com")
                .setUserName("Voronovsky")
                .setUserPassword("Voronovsky_1")
                .setUserConfirmPassword("Voronovsky_1");
    }

    public static User getUserWithIncorrectConfirmPassword() {
        return new User()
                .setUserEmail("Voronovsky@gmail.com")
                .setUserName("Voronovsky")
                .setUserPassword("Voronovsky_1")
                .setUserConfirmPassword("Voronovsky_2");
    }

    public static User getUserWithoutUserName() {
        return new User()
                .setUserEmail("Voronovskyi@gmail.com")
                .setUserPassword("Voronovskyi_1")
                .setUserConfirmPassword("Voronovskyi_1");
    }
}

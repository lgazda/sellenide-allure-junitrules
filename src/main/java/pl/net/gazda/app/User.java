package pl.net.gazda.app;

public class User {
    private final String name;
    private User(String name) {
        this.name = name;
    }
    public static User of(String name) {
        return new User(name);
    }

    public String getName() {
        return name;
    }
}

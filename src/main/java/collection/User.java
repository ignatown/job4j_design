package collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    Calendar birthday;

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }

    public static void main(String[] args) {
        User user1 = new User("Robert", 2);
        User user2 = new User("Robert", 2);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, 1);
        map.put(user2, 1);

        map.entrySet().stream().forEach(System.out::println);

    }
}

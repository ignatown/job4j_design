package collection;

import java.util.*;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> previousUsers = new HashMap<>();
        Map<Integer, String> currentUsers = new HashMap<>();
        for (User user :
                previous) {
            previousUsers.put(user.id, user.name);
        }
        for (User user :
                current) {
            currentUsers.put(user.id, user.name);
            if (!previous.contains(user)) {
                if (previousUsers.get(user.id) == null) {
                    info.added++;
                } else {
                    if (!previousUsers.get(user.id).equals(user.name)) {
                        info.changed++;
                    }
                }
            }
        }
        for (User user :
                previous) {
            if (currentUsers.get(user.id) == null) {
                info.deleted++;
            }
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

    }

}
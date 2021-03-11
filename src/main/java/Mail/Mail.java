package Mail;

import java.util.*;

public class Mail {
    Map<String, Set<String>> base = new HashMap<>();
    Set<String> emails = new HashSet<>();
    Map<String, Set<String>> dubUsers = new HashMap<>();
    Set<String> emptyUsers = new HashSet<>();
    String tempUser;


    public String findByEmail(String mail) {
        for (String findUser:
             base.keySet()) {
            if (base.get(findUser).contains(mail)) {
                return findUser;
            }
        }
        return null;
    }

    public Map<String, Set<String>> merge(Map<String, Set<String>> data){
        for (String user:
             data.keySet()) {
            for (String userEmail:
            data.get(user)) {
                if (emails.contains(userEmail)) {
                    tempUser = findByEmail(userEmail);
                    if (dubUsers.containsKey(tempUser)) {
                        dubUsers.get(tempUser).addAll(data.get(user));
                    } else {
                   dubUsers.put(tempUser, data.get(user));
                   emptyUsers.add(user);
                    }
                } else {
                    emails.add(userEmail);
                }
            }
        }
        for (String user:
             emptyUsers) {
            data.remove(user);
        }
        for (String user:
             dubUsers.keySet()) {
            data.put(user, dubUsers.get(user));
        }
        return data;
    }
}


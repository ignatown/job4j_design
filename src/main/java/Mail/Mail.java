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

    public void mailsTreatment(){
        for (String user:
             base.keySet()) {
            for (String userEmail:
            base.get(user)) {
                if (emails.contains(userEmail)) {
                    tempUser = findByEmail(userEmail);
                    if (dubUsers.containsKey(tempUser)) {
                        dubUsers.get(tempUser).addAll(base.get(user));
                    } else {
                   dubUsers.put(tempUser, base.get(user));
                   emptyUsers.add(user);
                    }
                } else {
                    emails.add(userEmail);
                }
            }
        }
        for (String user:
             emptyUsers) {
            base.remove(user);
        }
        for (String user:
             dubUsers.keySet()) {
            base.put(user, dubUsers.get(user));
        }


    }

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.base.put("user1", Set.of("em1","em2","em3"));
        mail.base.put("user2", Set.of("em4","em5","em6"));
        mail.base.put("user3", Set.of("em7"));
        mail.base.put("user4", Set.of("em7","em8"));
/*        mail.base.put("user5", Set.of("em7","em9"));*/
        System.out.println(mail.base);
        System.out.println(mail.emails);
        System.out.println(mail.emptyUsers);
        System.out.println(mail.dubUsers);
        mail.mailsTreatment();
        System.out.println(mail.base);
        System.out.println(mail.emails);
        System.out.println(mail.emptyUsers);
        System.out.println(mail.dubUsers);
    }

}


package Mail;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class MailTest {

    @Test
    public void when() {
        Map<String, Set<String>> base = new HashMap<>();
        Mail mail = new Mail();
        HashSet<String> mails1 = new HashSet<>();
        HashSet<String> mails2 = new HashSet<>();
        HashSet<String> mails3 = new HashSet<>();
        mails1.add("1");
        mails2.add("2");
        mails3.add("1");
        mails3.add("3");
        base.put("user1", mails1);
        base.put("user2", mails2);
        base.put("user3", mails3);
        mail.merge(base);
        assertEquals(mail.merge(base).get("user1").toString(), "[1, 3]");
        assertEquals(mail.merge(base).get("user2").toString(), "[2]");
    }
}
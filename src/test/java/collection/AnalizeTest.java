package collection;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void when1A1C1D() {
     Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "C"),
                new Analize.User(4, "D"));
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "G"),
                new Analize.User(5, "new"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }

    @Test
    public void when1A0C0D() {
        Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "C"),
                new Analize.User(4, "D"));
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "C"),
                new Analize.User(4, "D"),
                new Analize.User(5, "new"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(1));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void when0A1C0D() {
        Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "C"),
                new Analize.User(4, "D"));
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "C"),
                new Analize.User(4, "chgd"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void when0A0C1D() {
        Analize analize = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(3, "C"),
                new Analize.User(4, "D"));
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "A"),
                new Analize.User(2, "B"),
                new Analize.User(4, "D"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(1));
    }
}
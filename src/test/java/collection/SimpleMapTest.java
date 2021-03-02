package collection;

import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void insertAndGetTest() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "Test One");
        map.insert(2, "Test Two");
        map.insert(3, "Test Three");
        assertThat(map.get(1), is("Test One"));
        assertThat(map.get(2), is("Test Two"));
        assertThat(map.get(3), is("Test Three"));
    }

    @Test
    public void deleteTest() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "Test One");
        map.delete(1);
        assertThat(map.iterator().hasNext(), is(false));
    }

    @Test
    public void iteratorTest() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "Test One");
        map.insert(2, "Test Two");
        map.insert(3, "Test Three");
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTestWhenNoElement() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "Test One");
        map.insert(2, "Test Two");
        map.insert(3, "Test Three");
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}
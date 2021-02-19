package collection;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(!set.add(2));
        assertTrue(set.add(3));
    }
}
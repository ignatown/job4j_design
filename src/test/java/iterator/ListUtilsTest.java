package iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        ListUtils.addAfter(input, 3, 9);
        assertThat(Arrays.asList(1, 9, 3, 4, 5), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        ListUtils.addAfter(input, 1, 9);
        assertThat(Arrays.asList(1, 9, 3, 4, 5), Is.is(input));
    }

    @Test
    public void whenRemoveIfMoreThanThree() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Predicate<Integer> flt = a -> a > 3;
        List<Integer> rsl = ListUtils.removeIf(input, flt);
        assertThat(Arrays.asList(1, 2, 3), Is.is(rsl));
    }

    @Test
    public void threeKiller() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1));
        Predicate<Integer> flt = a -> a == 3;
        List<Integer> rsl = ListUtils.replaceIf(input, flt, null);
        assertThat(Arrays.asList(1, 2, null, 4, 5, 4, null, 2, 1), Is.is(rsl));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> elms = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> rsl = ListUtils.removeAll(input, elms);
        assertThat(Arrays.asList(3, 4, 5), Is.is(rsl));
    }
}
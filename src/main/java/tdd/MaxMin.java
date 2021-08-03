package tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

   public <T> T max(List<T> value, Comparator<T> comparator) {
       return search(value, comparator,v -> v < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return search(value, comparator,v -> v > 0);
    }

    private <T> T search(List<T> value, Comparator<T> comparator, Predicate<Integer> pred){
        T rsl = value.get(0);
        for (T t: value) {
            if (pred.test(comparator.compare(rsl, t))) {
                rsl = t;
            }
        }
    return rsl;
    }
}
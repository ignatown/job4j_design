package tdd;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        List<T> rsl = sort(value, comparator);
        return rsl.get(rsl.size() - 1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        List<T> rsl = sort(value, comparator);
        return rsl.get(0);
    }

    //Shuttle Sort
    private <T> List<T> sort(List<T> value, Comparator<T> comparator){
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(value.get(i), value.get(i - 1)) < 0) {
                swap(value, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (comparator.compare(value.get(z), value.get(z - 1)) < 0) {
                        swap(value, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    return value;
    }

    private <T> void swap(List<T> array, int i, int j) {
        T tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}
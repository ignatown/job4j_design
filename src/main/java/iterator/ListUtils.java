package iterator;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index-2, list.size());
                list.add(index-2,value);


    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        list = list.stream().filter(filter).collect(Collectors.toList());
       return list.stream().filter(filter).collect(Collectors.toList());
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
       return list.stream().map(a -> filter.test(a)? a = value : a).collect(Collectors.toList());
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                if (list.get(i).equals(elements.get(j)))  {
                    list.remove(i);
                }
            }
        }
        return list;
    }

}
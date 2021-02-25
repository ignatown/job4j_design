package iterator;

import java.util.*;
import java.util.function.Predicate;

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
        Objects.checkIndex(index-1, list.size());
            ListIterator<T> i = list.listIterator(index-1);
            list.add(i.previousIndex(), value);

    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T chk = i.next();
            if (filter.test(chk)) {
                i.remove();
            }
        }
       return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T chk = i.next();
            if (filter.test(chk)) {
                i.set(value);
            }
        }
        return list;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> iList = list.listIterator();
           while (iList.hasNext()) {
               if (elements.contains(iList.next())) {
                   iList.remove();
               }

        }
        return list;
    }
}
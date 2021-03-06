package generics;

public interface Store<T extends generics.Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);

    int findIndexById(String id);
}
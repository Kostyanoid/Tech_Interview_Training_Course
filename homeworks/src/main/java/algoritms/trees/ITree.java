package algoritms.trees;

public interface  ITree<E extends Comparable<E>, V> {
    void insert(E key, V value);
    int size();
    boolean isEmpty();
}

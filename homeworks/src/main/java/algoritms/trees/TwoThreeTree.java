package algoritms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TwoThreeTree<K extends Comparable<K>, V> implements ITree<K, V> {

    private Node<K, V> root;
    private int size;

    private class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("[");
            sb.append(key);
            sb.append(": ").append(value);
            sb.append(']');
            return sb.toString();
        }
    }
    private class Node<K, V> {
        private final List<Entry<K, V>> entries;
        private Node<K, V> top;
        private Node<K, V> left;
        private Node<K, V> right;
        private Node<K, V> mid;
        private int capacity;

        private Node() {
            entries = new ArrayList<>(3);
            capacity = 0;
        }

        public Node(K key, V value) {
            this();
            insertEntry(key, value);
        }

        public List<K> getKeys() {
            return entries.stream().map(Entry::getKey).collect(Collectors.toList());
        }


        public List<V> getValues() {
            return entries.stream().map(Entry::getValue).collect(Collectors.toList());
        }

        public int containsKey(K key) {
            return getKeys().indexOf(key);
        }

        public void insertEntry(K key, V value) {
            if (key == null) throw new IllegalStateException("Key can not be null!");
            entries.add(new Entry<>(key, value));
        }

        public Node<K, V> getTop() {
            return top;
        }

        public void setTop(Node<K, V> top) {
            this.top = top;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
        }

        public Node<K, V> getMid() {
            return mid;
        }

        public void setMid(Node<K, V> mid) {
            this.mid = mid;
        }

        public boolean isLeaf() {
            return left == null && right == null && mid == null;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

    }

    @Override
    public void insert(K key, V value) {
        if (isEmpty()) {
            root = new Node<>(key, value);
            size = 1;
        }
        //TODO: insert
    }

    private Node<K, V> seekNodForInsertKey(Node<K, V> top, K key) {
        if (top.isLeaf() || top.getKeys().contains(key)) return top;
        if (top.getKeys().get(0).compareTo(key) < 0 ) seekNodForInsertKey(top.getLeft(), key);
        else if (top.getKeys().get(top.getKeys().size() - 1).compareTo(key) > 0) seekNodForInsertKey(top.getRight(), key);
        else if (top.getMid() != null) seekNodForInsertKey(top.getMid(), key);
        return top;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

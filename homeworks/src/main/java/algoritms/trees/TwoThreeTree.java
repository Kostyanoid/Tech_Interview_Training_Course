package algoritms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TwoThreeTree<K extends Comparable<K>, V> implements ITree<K, V> {

    private Node<K, V> root;
    private int size;

    private class Entry<K, V> {
        private final K key;
        private V value;

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

        public void setValue(V value) {
            this.value = value;
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
    private class Node<K extends Comparable<K>, V> {
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

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
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

        public  int keysCount() {
            return getKeys().size();
        }

        public void insertEntry(K key, V value) {
            if (key == null) throw new IllegalStateException("Key can not be null!");
            entries.add(new Entry<>(key, value));
            capacity++;
        }

        private void sortKeys() {
            if (keysCount() <= 1) return;
            if (keysCount() == 2) {
                //TODO: sort
            }
        }

        private void swapEntries(int i1, int i2) {
            assert (i1 >=0 && i1 < entries.size() && i2 >=0 && i2 < entries.size());
            if (i1 == i2) return;
            Entry<K, V> temp = entries.get(i1);
            entries.set(i1, entries.get(i2));
            entries.set(i2, temp);
        }

        public boolean isLeaf() {
            return left == null && right == null && mid == null;
        }

        public void changeValueByKey(K key, V value) {
            int i = containsKey(key);
            if (i < 0 ) return;
            entries.get(i).setValue(value);
        }

    }

    @Override
    public void insert(K key, V value) {
        if (isEmpty()) {
            root = new Node<>(key, value);
            size = 1;
        }
        Node<K, V> n = seekNodeForInsertKey(root, key);

        if (n.getKeys().contains(key)) {
            n.changeValueByKey(key, value);
            return;
        }

        if (!n.isLeaf() && n.keysCount() == 2) {
            Node<K, V> newNode = new Node<>(key, value);
            newNode.setTop(n);
            n.setMid(newNode);
        } else {
            n.insertEntry(key, value);
            if (n.keysCount() == 3) {
                dividingNode(n);
            }
        }
        size++;
    }

    private Node<K, V> seekNodeForInsertKey(Node<K, V> top, K key) {
        if (top.isLeaf() || top.getKeys().contains(key)) return top;
        if (top.getKeys().get(0).compareTo(key) > 0 ) seekNodeForInsertKey(top.getLeft(), key);
        else if (top.getKeys().get(top.getKeys().size() - 1).compareTo(key) < 0) seekNodeForInsertKey(top.getRight(), key);
        else if (top.getMid() != null) seekNodeForInsertKey(top.getMid(), key);
        return top;
    }

    private void dividingNode(Node<K, V> node) {
        if (node.keysCount() < 3) return;

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

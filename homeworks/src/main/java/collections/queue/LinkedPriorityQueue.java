package collections.queue;

import java.util.Iterator;
import java.util.Objects;

public class LinkedPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {

    private static class Node<E extends Comparable<E>> {
        private E value;
        private Node<E> top;
        private Node<E> left;
        private Node<E> right;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> top, Node<E> left, Node<E> right) {
            this(value);
            this.top = top;
            this.left = left;
            this.right = right;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getTop() {
            return top;
        }

        public void setTop(Node<E> top) {
            this.top = top;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(value);
        }

        public int compareTo(Node<E> o) {
            return value.compareTo(o.getValue());
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node {");
            sb.append("value=").append(value);
            if (top != null) sb.append(", top=").append(top.getValue());
            else sb.append(",top=null");
            if (left != null) sb.append(", left=").append(left.getValue());
            else sb.append(", left=null");
            if (right != null) sb.append(", right=").append(right.getValue());
            else sb.append(", right=null");
            sb.append('}');
            return sb.toString();
        }
    }


    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_ORDER = ASCENDING;
    private Node<E> head;
    private Node<E> last;
    private int size;
    private int capacity;
    private int order;

    public LinkedPriorityQueue() {
        capacity = DEFAULT_CAPACITY;
        order = DEFAULT_ORDER;
    }

    public LinkedPriorityQueue(int capacity, int order) throws IllegalArgumentException {
        if (capacity < 1) {
            this.capacity = DEFAULT_CAPACITY;
            throw new IllegalArgumentException("Capacity can't be less than 1.");
        }

        if (order >= 0) this.order = ASCENDING;
        else this.order = DESCENDING;

        this.capacity = capacity;
    }

    public LinkedPriorityQueue(Iterable<E> elements) {
        this();
        Iterator<E> iterator = elements.iterator();
        while (iterator.hasNext()) {
            insert(iterator.next());
        }
    }

    public LinkedPriorityQueue(Iterable<E> elements, int capacity) throws IllegalArgumentException {
        this(capacity, ASCENDING);
        Iterator<E> iterator = elements.iterator();
        while (iterator.hasNext()) {
            insert(iterator.next());
        }
    }

    public LinkedPriorityQueue(Iterable<E> elements, int capacity, int order) {
        this(elements, capacity);
        if (order >= 0) this.order = ASCENDING;
        else this.order = DESCENDING;
    }


    @Override
    public void insert(E element) {
        Objects.requireNonNull(element);
        if (isEmpty()) {
            head.setValue(element);
            last = head;
            size = 1;
        } else {
            Node<E> newNode = getNext();
            newNode.setValue(element);
            bobUp(newNode);

            if (size > capacity) {
                if (newNode.getTop().getLeft() == newNode) {
                    newNode.getTop().setLeft(null);
                } else {
                    newNode.getTop().setRight(null);
                }
                size--;
            }
        }
    }

    @Override
    public E poll() {
        return head != null ? head.getValue() : null;
    }

    @Override
    public E remove() {
        E removing = head.value;
        if (size == 1) {
            size--;
            head = null;
            last = null;
        } else {
            swap(head, last);
            sink(head);
            removeLast();
        }

        return removing;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private boolean hasNoLeafs(Node<E> node) {
        return node != null && (node.getLeft() == null && node.getRight() == null);
    }

    private Node<E> getNext() {
        int m = size + 1;
        Node<E> next = head;

        while (m >>> 1 > 1) {
            if (m % 2 == 0) next = next.getLeft();
            else next = next.getRight();
            m = m >>> 1;
        }

        Node<E> newNode = new Node<>();
        newNode.setTop(next);

        if (m % 2 == 0) {
            next.setLeft(newNode);
        } else {
            next.setRight(newNode);
        }

        last = newNode;
        size++;
        return newNode;
    }

    private Node<E> findLast() {
        int m = size;
        Node<E> next = head;

        while (m >>> 1 > 1) {
            if (m % 2 == 0) next = next.getLeft();
            else next = next.getRight();
            m = m >>> 1;
        }

        if (m % 2 == 0) {
            return next.getLeft();
        } else {
            return next.getRight();
        }
    }

    private void removeLast() {
        Node<E> lastTop = last.getTop();
        if (lastTop.getLeft() == last) {
            lastTop.setLeft(null);
        } else {
            lastTop.setRight(null);
        }
        last = findLast();
        size--;
    }

    private void bobUp(Node<E> element) {
        while (element.getTop() != null
                && element.getTop().getValue().compareTo(element.getValue()) * order > 0) {
            swap(element, element.getTop());
            element = element.getTop();
        }
    }

    private void sink(Node<E> element) {
        while (element.getLeft() != null && element.compareTo(element.getLeft()) * order < 0
            || element.getRight() != null && element.compareTo(element.getRight()) * order < 0) {
            if (element.getLeft() != null) {
                if (element.getRight() != null) {
                    if (element.getLeft().compareTo(element.getRight()) * order < 0) {
                        swap(element, element.getRight());
                        element = element.getRight();
                    } else {
                        swap(element, element.getLeft());
                        element = element.getLeft();
                    }
                } else {
                    swap(element, element.getLeft());
                    element = element.getLeft();
                }
            } else {
                swap(element, element.getRight());
                element = element.getRight();
            }
        }
    }

    private void swap(Node<E> n1, Node<E> n2) {
        if (n1 == null || n2 == null) return;
        E temp = n2.getValue();
        n2.setValue(n1.getValue());
        n2.setValue(temp);
    }
}

package collections.queue;

import algoritms.sort.Swapable;

import java.util.Arrays;
import java.util.Objects;

public class  ArrayPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E>, Swapable {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public ArrayPriorityQueue() {
        elements = (E[]) new Comparable[DEFAULT_CAPACITY + 2];
    }

    public ArrayPriorityQueue(int capacity) throws IllegalStateException {
        if (capacity < 1) {
            elements = (E[]) new Comparable[DEFAULT_CAPACITY + 2];
            throw new IllegalStateException("Capacity can't be less than 1!");
        }
        elements = (E[]) new Comparable[capacity + 2];
    }

    public ArrayPriorityQueue(E[] elements) {
        Objects.requireNonNull(elements);

        if (elements.length > 0) {
            this.elements = (E[]) new Comparable[elements.length + 2];
        } else {
            this.elements = (E[]) new Comparable[DEFAULT_CAPACITY + 2];
        }

        for (E element: elements) {
            insert(element);
        }
    }

    public ArrayPriorityQueue(E[] elements, int capacity) throws IllegalStateException {
        Objects.requireNonNull(elements);

        if (capacity < 1) {
            if (elements.length < 1) {
                this.elements = (E[]) new Comparable[DEFAULT_CAPACITY + 2];
            } else {
                this.elements = (E[]) new Comparable[elements.length + 2];
            }
            throw new IllegalStateException("Capacity can't be less than 1!");
        }

        for (E element: elements) {
            insert(element);
        }
    }

    @Override
    public void insert(E element) {
        if (element == null) throw  new IllegalArgumentException("Inserting element can not be null.");
        elements[++size] = element;
        if (size > 1) bobUp(size);
        if (size == elements.length - 1) {
            elements[size] = null;
            size--;
        }
    }

    @Override
    public E poll() {
        return elements[1];
    }

    @Override
    public E remove() {
        E removing = poll();
        swap(elements, 1, size);
        elements[size] = null;
        size--;
        sink(1);
        return removing;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.stream(elements).forEach(element -> element = null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void bobUp(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(elements, k/2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k + 1 <= size + 1 && (less(k, 2 * k) || less(k, 2 * k + 1))) {
            if (less(2 * k, 2 * k + 1)) {
                swap(elements, k,2 * k + 1);
                k = 2 * k + 1;
            } else {
                swap(elements, k,2 * k);
                k = 2 * k;
            }
        }
    }

    private boolean less(int i, int j) {
        if (elements[i] == null || elements[j] == null) return  false;
        return ((E) elements[i]).compareTo((E) elements[j]) < 0;
    }
}

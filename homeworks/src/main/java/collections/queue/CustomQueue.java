package collections.queue;

import java.util.Arrays;

public class CustomQueue implements IQueue {

    private static class Element {
        private Object value;
        private Element next;

        private Element() {};

        static Element of(Object value) {
            Element newElement = new Element();
            newElement.setValue(value);
            newElement.setNext(null);
            return newElement;
        }

        Object getValue() {
            return value;
        }

        Element setValue(Object value) {
            this.value = value;
            return this;
        }

        Element getNext() {
            return next;
        }

        Element setNext(Element next) {
            this.next = next;
            return this;
        }

        boolean equals(Element another) {
            return this.getValue().equals(another.getValue());
        }
    }

    private Element head;
    private Element tail;
    private int size;

    public CustomQueue() {
    }

    public CustomQueue(Object[] values) {
        Arrays.stream(values).forEach(this::offer);
    }

    @Override
    public void offer(Object value) {
        Element newElement = Element.of(value);
        if (head == null) {
            head = newElement;
            tail = newElement;
        }
        tail.setNext(newElement);
        tail = newElement;
        size++;
    }

    @Override
    public Object poll() {
        if (isEmpty()) return null;
        Element polled = head;
        head = head.getNext();
        size--;
        return polled.getValue();
    }

    @Override
    public Object remove() throws NoElementsInQueueException {
        if (isEmpty()) throw new NoElementsInQueueException();
        Element polled = head;
        head = head.getNext();
        size--;
        return polled.getValue();
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : head.getValue();
    }

    @Override
    public Object element() throws NoElementsInQueueException {
        if (isEmpty()) throw new NoElementsInQueueException();
        return head.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "{empty}";
        if (size == 1) return "{head}=" + head.getValue() + " -> {tail}";
        StringBuilder sb = new StringBuilder();
        sb.append("{head}=");
        Element nextEl = head;
        while (nextEl != null) {
            sb.append(nextEl.getValue()).append(" -> ");
            nextEl = nextEl.getNext();
        }
        sb.append("{tail}");
        return sb.toString();
    }
}

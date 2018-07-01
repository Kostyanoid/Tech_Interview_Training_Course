package collections.list;

import java.util.Arrays;

public class LoopedLinkedList implements ICustomLinkedList {

    private Element head;
    private Element tail;
    private int length;

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


    public LoopedLinkedList() {}

    public LoopedLinkedList(Object[] values) {
        Arrays.stream(values).forEach(this::add);
    }

    public LoopedLinkedList(Object[] values, int looped) {
        Arrays.stream(values).forEach(this::add);
        loop(looped);
    }

    @Override
    public Object head() {
        if (isEmpty()) return null;
        return head.getValue();
    }

    @Override
    public Object tail() {
        if (isEmpty()) return null;
        return tail.getValue();
    }

    @Override
    public int add(Object newElement) {
        if (head == null) {
            head = Element.of(newElement);
            tail = head;
            head.setNext(tail);
        } else {
            tail.setNext(Element.of(newElement));
            tail = tail.getNext();
        }
        tail.setNext(head);
        length++;
        return length;
    }

    public void loop(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();
        if (isEmpty()) throw new IllegalStateException();
        Element el = head;
        while (0 < index--) el = el.getNext();
        tail.setNext(el);
    }

    public int findLoopedElement() {
        if (isEmpty()) throw new IllegalStateException();
        int i = 0;
        Element el = head;
        while (i++ < length) el = el.getNext();
        Element el2 = head;
        i = 0;
        while (el2 != el) {
            i++;
            el2 = el2.getNext();
        }
        return i;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {

    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index >= length) throw new IndexOutOfBoundsException();
        if (isEmpty()) throw new IllegalStateException();
        Element el = head;
        while (0 < index--) el = el.next;
        return el.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String toString() {
        if (length == 0) return "{empty}";
        StringBuilder sb = new StringBuilder();
        sb.append("{head}=");
        Element nextEl = head;
        while (nextEl != tail) {
//            sb.append("El_").append(i).append(": ");
            sb.append(nextEl.getValue()).append(" -> ");
            nextEl = nextEl.getNext();
        }
        sb.append("{end}");
        return sb.toString();
    }
}

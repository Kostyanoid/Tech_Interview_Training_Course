package collections.stack;

import java.util.*;

public class StackByLinkedList implements IStack {

    private Element head;
    private int size;

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


    public StackByLinkedList() {}

    public StackByLinkedList(Object[] values) {
        Arrays.stream(values).forEach(this::push);
    }

    @Override
    public void push(Object value) {
        head = head == null ? Element.of(value) : Element.of(value).setNext(head);
        size++;
    }

    @Override
    public Object pop() throws NoElementsInStackException {
        if (isEmpty()) throw new NoElementsInStackException();

        Element result = head;
        head = head.getNext();
        size--;
        return result.getValue();
    }

    @Override
    public Object peek() {
        return head != null ? head.value : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (size == 0) return "{empty}";
        StringBuilder sb = new StringBuilder();
        sb.append("{head}=");
        Element nextEl = head;
        while (nextEl != null) {
//            sb.append("El_").append(i).append(": ");
            sb.append(nextEl.getValue()).append(" -> ");
            nextEl = nextEl.getNext();
        }
        sb.append("{end}");
        return sb.toString();
    }
}

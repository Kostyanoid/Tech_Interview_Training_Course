package stack;

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

    protected Element getHead() {
        return head;
    }

    protected void setHead(Element head) {
        this.head = head;
    }

    @Override
    public void push(Object value) {
        Element el = Element.of(value);
        if (head == null) {
            head = el;
        } else {
            head.setNext(el);
            head = el;
        }
        size++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) return null;

        Element result = head;
        head = head.next;
        size--;
        return result;
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
        int i = 1;
        sb.append("{head}=");
        while (head != null) {
//            sb.append("El_").append(i).append(": ");
            sb.append(head.getValue()).append(" -> ");
            i++;
            head = head.next;
        }
        sb.append("{end}");
        return sb.toString();
    }
}

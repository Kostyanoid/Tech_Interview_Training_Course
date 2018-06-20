package collections;

import java.util.Arrays;
import java.util.Objects;

public class CustomLinkedList implements ICustomList {

    private static class Element {
        private final Object value;
        private int index;
        private Element next;
        private Element prev;

        public Element(Object value, int index, Element next, Element prev) {
            this.value = value;
            this.index = index;
            this.next = next;
            this.prev = prev;
        }

        public Element(Object value, int index) {
            this.value = value;
            this.index = index;
        }

        public Object getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return index == element.index &&
                    Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }

    }

    private Element head;
    private Element tail;
    private int length;

    public CustomLinkedList() {};

    public CustomLinkedList(Object[] array) {
        Arrays.stream(array).forEach(this::add);
    }

    public Element head() {
        return head;
    }

    protected void setHead(Element head) {
        this.head = head;
    }

    public Element tail() {
        return tail;
    }

    protected void setTail(Element tail) {
        this.tail = tail;
    }

    public int length() {
        return length;
    }

    @Override
    public int add(Object value) {
        Element newElement = new Element(value, length);
        if (head == null) setHead(newElement);
        if (tail == null) setTail(newElement);

        newElement.setNext(head);
        newElement.setPrev(tail);

        tail.setNext(newElement);
        head.setPrev(newElement);

        tail = newElement;

        return length++;
    }

    @Override
    public int add(Object newElement, int index) throws IndexOutOfBoundsException {
        return 0;
    }

    @Override
    public boolean delete(Object element) {
        return false;
    }

    @Override
    public boolean delete(int index) throws IndexOutOfBoundsException {
        return false;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > length - 1) throw new IndexOutOfBoundsException();
        int direction = index >= length / 2 ? -1 : 1;
        Element result = direction > 0 ? head : tail;
        while (result.getIndex() != index)
            result = direction > 0 ? result.getNext() : result.getPrev();
        return result.getValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Element el = head;
        do {
            if (el.equals(head)) sb.append("Head: ");
            if (el.equals(tail)) sb.append("Tail: ");
            sb.append("{Element ").append(el.getIndex()).append(": ")
                    .append("value=").append(el.getValue()).append("; ")
                    .append("prev=").append(el.getPrev() != null ? el.getPrev().equals(head) ? "head" : "{Element " + el.getPrev().getIndex() + "}": null).append("; ")
                    .append("next=").append(el.getNext() != null ? el.getNext().equals(tail) ? "tail" : "{Element " + el.getNext().getIndex() + "}": null).append("; ");
            sb.append("}\n");
            el = el.getNext();
        } while (!el.equals(head));
        return sb.toString();
    }
}

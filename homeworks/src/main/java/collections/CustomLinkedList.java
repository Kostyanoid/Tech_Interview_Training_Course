package collections;

import java.util.Arrays;
import java.util.Objects;

public class CustomLinkedList implements ICustomLinkedList {

    private static class Element {
        private final Object value;
        private Element next;
        private Element prev;

        public Element(Object value,Element next, Element prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Element(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
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

        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof Element)) return false;
            if (!super.equals(object)) return false;

            Element element = (Element) object;

            return getValue() != null ? getValue().equals(element.getValue()) : element.getValue() == null;
        }

        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
            return result;
        }
    }

    private Element head;
    private Element tail;
    private int length;

    public CustomLinkedList() {}

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
        Element newElement = new Element(value);
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
    public void delete(int index) throws IndexOutOfBoundsException {

        if (length == 1) {
            length = 0;
            head = null;
            tail = null;
            return;
        }

        Element deletingElement = find(index);

        deletingElement.getNext().setPrev(deletingElement.getPrev());
        deletingElement.getPrev().setNext(deletingElement.getNext());
        length--;

        if (deletingElement.equals(head)) {
            head = deletingElement.getNext();
        }

        if (deletingElement.equals(tail)) {
            tail = deletingElement.getPrev();
        }

    }


    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return find(index).getValue();
    }

    private Element find(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > length - 1) throw new IndexOutOfBoundsException();

        int direction = index >= length / 2 ? -1 : 1;

        Element result = direction > 0 ? head : tail;
        int searchingIndex = direction > 0 ? 0 : length - 1;

        while (searchingIndex != index) {
            result = direction > 0 ? result.getNext() : result.getPrev();
            searchingIndex += direction;
        }

        return result;
    }

    public String toString() {
        if (length == 0) return "{empty}";
        StringBuilder sb = new StringBuilder();
        Element el = head;
        int index  = 0;
        do {
            if (el.equals(head)) sb.append("Head: ");
            if (el.equals(tail)) sb.append("Tail: ");
            sb.append("{Element ").append(index).append(": ")
                    .append("value=").append(el.getValue()).append("; ")
                    .append("prev=").append(el.getPrev() != null ? el.getPrev().equals(head) ? "head" : "{Element " + (index - 1) + "}": null).append("; ")
                    .append("next=").append(el.getNext() != null ? el.getNext().equals(tail) ? "tail" : "{Element " + (index + 1) + "}": null).append("; ");
            sb.append("}\n");
            el = el.getNext();
            index++;
        } while (!el.equals(head));
        return sb.toString();
    }
}

package collections.stack;

public class StackByArray implements IStack {

    private int capacity = 12;
    private Object[] elements = new Object[capacity];
    private int size;

    public StackByArray() {
    }

    public StackByArray(Object[] elements) {
        size = elements.length;
        if (size > this.capacity) {
            this.capacity = (size * 3) / 2;
            elements = new Object[this.capacity];
        }
        System.arraycopy(elements, 0, this.elements, 0, size);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        resizeElementsArray(capacity);
        this.capacity = capacity;
    }

    @Override
    public void push(Object value) {
        if (size == capacity) resizeElementsArray(capacity * 3 / 2);
        elements[size++] = value;
    }

    private void resizeElementsArray(int newCapacity) {
        if (newCapacity <= capacity) return;
        Object[] temp = new Object[newCapacity];
        System.arraycopy(elements, 0, temp, 0, size);
        elements = temp;
        capacity = newCapacity;
    }

    public void trimElementArray() {
        if (size == capacity) return;
        Object[] temp = new Object[size];
        System.arraycopy(elements, 0, temp, 0, size);
        elements = temp;
        capacity = size;
    }

    @Override
    public Object pop() throws NoElementsInStackException {
        if (isEmpty()) throw new NoElementsInStackException();
        return elements[--size];
    }

    @Override
    public Object peek() {
        return size > 0 ? elements[size - 1] : null;
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
        if (isEmpty()) return "{empty}";
        final StringBuilder sb = new StringBuilder("{head}=");
        for (int i = size - 1; i >=0; i--) {
            sb.append(elements[i]).append(" -> ");
        }
        sb.append("{end}");
        return sb.toString();
    }
}

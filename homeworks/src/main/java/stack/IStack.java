package stack;

public interface IStack {
    void push(Object value);
    Object pop() throws NoElementsInStackException;
    int size();
    boolean isEmpty();
}

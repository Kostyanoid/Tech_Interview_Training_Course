package stack;

public interface IStack {
    void push(Object value);
    Object pop();
    int size();
    boolean isEmpty();
}

package collections;

public interface ICustomList {
    int add(Object newElement);
    void delete(int index) throws IndexOutOfBoundsException;
    int length();
    Object get(int index) throws IndexOutOfBoundsException;
}

package collections;

public interface ICustomList {

    int add(Object newElement);
    int add(Object newElement, int index) throws IndexOutOfBoundsException;
    boolean delete(Object element);
    boolean delete(int index) throws IndexOutOfBoundsException;
    int length();
    Object get(int index) throws IndexOutOfBoundsException;

}

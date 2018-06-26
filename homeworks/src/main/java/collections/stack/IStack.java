package collections.stack;

import collections.IMyCollection;

public interface IStack extends IMyCollection {
    void push(Object value);
    Object pop() throws NoElementsInStackException;
}

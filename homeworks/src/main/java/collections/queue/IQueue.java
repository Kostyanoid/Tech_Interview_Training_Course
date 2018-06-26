package collections.queue;

import collections.IMyCollection;

public interface IQueue extends IMyCollection {
    void offer(Object value);
    Object poll();
    Object peek();
    Object remove() throws NoElementsInQueueException;
    Object element() throws NoElementsInQueueException;
}

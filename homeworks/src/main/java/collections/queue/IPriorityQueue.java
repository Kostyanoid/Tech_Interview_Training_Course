package collections.queue;

import collections.IMyCollection;

public interface IPriorityQueue<E extends Comparable<E>> extends IMyCollection {
    void insert(E element);
    E poll();
    E remove();
}

package collections.queue;

import collections.IMyCollection;

public interface IPriorityQueue<E extends Comparable<E>> extends IMyCollection {

    int ASCENDING = 1;
    int DESCENDING = -1;

    void insert(E element);
    E poll();
    E remove();
}

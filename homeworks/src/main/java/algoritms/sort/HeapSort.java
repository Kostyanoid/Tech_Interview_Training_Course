package algoritms.sort;

import static collections.queue.IPriorityQueue.ASCENDING;

public class HeapSort<E extends Comparable<E>> implements SortArrayAlg<E> {

    private ShuffleArrayAlg shuffle = new ShuffleArray();
    private final int order;

    public HeapSort() {
        order = ASCENDING;
    }

    public HeapSort(int order) {
        this.order = order;
    }

    @Override
    public void sort(E[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        if (!validate(array)) {
            throw new IllegalArgumentException("The sorting array must not contain nulls.");
        }
        shuffle.shuffle(array);

        buildHeap(array, 0, array.length - 1);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            sink(array, 0, i - 1);
        }
    }

    private void sink(E[] array, int k, int rightBorder) {
        if (array == null || k < 0 || k > rightBorder || rightBorder > array.length - 1) {
            throw new IllegalArgumentException();
        }
        k = k + 1;
        while (k * 2 + 1 <= rightBorder + 1
                && (array[k - 1].compareTo(array[k * 2 - 1]) * order < 0
                || array[k - 1].compareTo(array[k * 2]) * order < 0)) {
            if (array[k * 2 - 1].compareTo(array[k * 2]) * order < 0) {
                swap(array, k - 1, k * 2);
                k = 2 * k + 1;
            } else {
                swap(array, k - 1, k * 2 - 1);
                k = 2 * k;
            }
        }

        if (k * 2 <= rightBorder + 1) {
            if (array[k - 1].compareTo(array[2 * k - 1]) * order < 0) {
                swap(array, k - 1, k * 2 - 1);
            }
        }
    }

    private void buildHeap(E[] array, int low, int high) {
        if (array == null || low < 0 || high > array.length - 1 || low > high) {
            throw new IllegalArgumentException();
        }

        int topIndex = (low - 1) + ((high - low + 1) >>> 1);
        int leftIndex = topIndex  - (low - 1) + topIndex;
        int rightIndex = leftIndex + 1;
        int popUpElementIndex;
        while (topIndex >= 0) {
            if (rightIndex <= high) {
                popUpElementIndex = array[leftIndex].compareTo(array[rightIndex]) * order > 0
                        ? leftIndex
                        : rightIndex;
            } else {
                popUpElementIndex = leftIndex;
            }
            if (array[topIndex].compareTo(array[popUpElementIndex]) * order < 0) {
                swap(array, popUpElementIndex, topIndex);
                sink(array, popUpElementIndex, high);
            }
            topIndex = topIndex - 1;
            leftIndex = topIndex  * 2 - (low - 1);
            rightIndex = leftIndex + 1;
        }

    }
}

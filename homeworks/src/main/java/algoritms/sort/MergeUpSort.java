package algoritms.sort;

public class MergeUpSort implements MergeSortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");

        mergeSort(array, 0, 1);

    }

    private void mergeSort(Comparable[] array, int first, int len) {
        if (len >= array.length) return;
        int last = Math.min(first + 2 * len  - 1, array.length - 1);
        while (first + len < array.length) {
            mergeInPlace(array, first, first + len - 1, first + len, last);
            first = last + 1;
            last = Math.min(first + 2 * len  - 1, array.length - 1);
        }
        mergeSort(array, 0, 2 * len);
    }

}

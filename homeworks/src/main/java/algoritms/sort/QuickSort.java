package algoritms.sort;

public class QuickSort implements SortArrayAlg {


    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");

        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] values, int lo, int hi) {
        if (lo >= hi) return;

        int suppElementIndex = lo;
        int i = lo;
        int j = hi + 1;
        Comparable suppElement = values[suppElementIndex];

        while (i < j) {
            while (values[++i].compareTo(suppElement) < 0) {
                if (i >= hi) break;
            }
            while (values[--j].compareTo(suppElement) >= 0) {
                if (j < lo + 1) break;
            }

            if (i >= j) break;

            swap(values, i, j);
        }
        swap(values, suppElementIndex, j);
        if (j > lo ) quickSort(values, lo, j);
        if (j + 1 < hi) quickSort(values, j + 1, hi);
    }
}

package algoritms.sort;

public class ThreeSideQuickSort implements SortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");

        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] values, int lo, int hi) {
        if (lo >= hi) return;

        int i = lo + 1;
        int lt = lo;
        int gt = hi;

        Comparable pivot = values[lo];

        while (i <= gt) {
            if (values[i].compareTo(pivot) < 0)
                swap(values, i++, lt++);
            else if (values[i].compareTo(pivot) > 0)
                swap(values, i, gt--);
            else i++;
        }

        quickSort(values, lo, lt - 1);
        quickSort(values, gt + 1 , hi);
    }
}

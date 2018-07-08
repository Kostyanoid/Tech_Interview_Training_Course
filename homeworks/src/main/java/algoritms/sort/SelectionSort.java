package algoritms.sort;

public class SelectionSort implements SortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");
        for (int i = 0; i < array.length - 1; i++) {
            int iMin = findMin(array, i, array.length);
            if (iMin != i) swap(array, i, iMin);
        }
    }

    private int findMin(Comparable[] array, int from, int last) {
        Comparable min = array[from];
        int iMin = from;
        for (int i = from + 1; i < last; i++) {
                if (min.compareTo(array[i]) > 0) {
                    iMin = i;
                    min = array[i];
                }
        }
        return iMin;
    }
}

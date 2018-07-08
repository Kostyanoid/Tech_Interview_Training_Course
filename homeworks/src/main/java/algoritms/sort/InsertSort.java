package algoritms.sort;

public class InsertSort implements SortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");
        int j;
        for (int i = 1; i < array.length; i++) {
            j = i;
            while (j > 0 && array[j - 1].compareTo(array[j]) > 0) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }
}

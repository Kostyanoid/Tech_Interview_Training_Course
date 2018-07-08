package algoritms.sort;

public class MergeDownSort implements MergeSortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");

        mergeSort(array, 0, array.length - 1);

    }

    private void mergeSort(Comparable[] subArray, int first, int last) {
        if (first >= last) return;
        int med = first + (last - first) / 2;
        mergeSort(subArray, first, med);
        mergeSort(subArray, med + 1, last);
        mergeInPlace(subArray, first, med, med + 1, last);
    }

}

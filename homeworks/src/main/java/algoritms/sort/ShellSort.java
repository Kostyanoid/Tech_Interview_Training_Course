package algoritms.sort;

public class ShellSort implements ShellSortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");

        int k = maxStepIndexResolver(array.length);
        while (k > 0) {
            int step = stepSizeGenerator(k--);
            for (int i = step; i < array.length; i++) {
                int j = i;
                while (j - step >= 0 && array[j].compareTo(array[j - step]) < 0) {
                   swap(array, j, j - step);
                   j -= step;
                }
            }
        }
    }
}

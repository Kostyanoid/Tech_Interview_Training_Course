package algoritms.sort;

import java.util.Arrays;

public class BubbleSort implements SortArrayAlg {
    @Override
    public void sort(Comparable[] array) {
        if (array == null || array.length < 2) return;
        if (!validate(array)) throw new IllegalArgumentException("Array contains null values. Sorting is impossible.");
        boolean flag;
        for (int i = array.length - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    flag = true;
                }
//                System.out.printf("i = %d, j = %d: %s\n",  i, j, Arrays.toString(array));
            }
            if (!flag) break;
        }
    }
}

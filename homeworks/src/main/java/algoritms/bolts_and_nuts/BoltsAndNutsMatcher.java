package algoritms.bolts_and_nuts;

import algoritms.sort.SortArrayAlg;
import algoritms.sort.Swapable;

import java.util.Arrays;
import java.util.Objects;

public class BoltsAndNutsMatcher implements Swapable {

    public void match(Bolt[] bolts, Nut[] nuts) {
        if (bolts == null || nuts == null) throw new IllegalArgumentException("There is null of bolts or nuts.");
        if (bolts.length == 0 && nuts.length == 0) return;
        if (!validate(bolts) || !validate(nuts)) throw new IllegalArgumentException("Some bolts or nuts are null. Impossible to match.");
        if (bolts.length != nuts.length) throw new IllegalArgumentException("There is different amount bolts and nuts.");

        sort(bolts, nuts, 0, bolts.length - 1);
    }

    private boolean validate(Object[] array) {
        return Arrays.stream(array).noneMatch(Objects::isNull);
    }

    private void sort(Bolt[] bolts, Nut[] nuts, int lo, int hi) {
        if (lo > hi - 1) return;

        Nut n = nuts[lo];

        int equalsBoltIndex = partitioning(bolts, lo, hi, n);
        Bolt equalsBolt = bolts[equalsBoltIndex];

        int mid = partitioning(nuts, lo, hi, equalsBolt);

        sort(bolts, nuts, lo , mid);
        sort(bolts, nuts, mid + 1, hi);
    }

    private <T> int partitioning(Comparable<T>[] values, int lo, int hi, T pivot) {
        if (lo >= hi) return lo;

        int i = lo - 1;
        int j = hi + 1;

        int equalPivotIndex = -1;

        while (i < j) {
            while (values[++i].compareTo(pivot) <= 0) {
                if (values[i].compareTo(pivot) == 0) equalPivotIndex = i;
                if (i >= hi) break;
            }
            while (values[--j].compareTo(pivot) > 0) {
                if (j < lo + 1) break;
            }

            if (i >= j) break;

            swap(values, i, j);
            if (values[i].compareTo(pivot) == 0) equalPivotIndex = i;
        }

        assert equalPivotIndex != -1;

        swap(values, equalPivotIndex, j);
        return j;
    }
}

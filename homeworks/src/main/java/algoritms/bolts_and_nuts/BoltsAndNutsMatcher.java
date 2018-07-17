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
        Bolt b = sortBolts(bolts, lo, hi, n);
        int mid = sortNuts(nuts, lo, hi, b);
        sort(bolts, nuts, lo , mid);
        sort(bolts, nuts, mid + 1, hi);
    }

    private Bolt sortBolts(Bolt[] bolts, int lo, int hi, Nut nut) {
        if (lo >= hi) return bolts[lo];

        int i = lo - 1;
        int j = hi + 1;

        Bolt equalBolt = null;

        while (i < j) {
            while (bolts[++i].compareTo(nut) <= 0) {
                if (bolts[i].compareTo(nut) == 0) equalBolt = bolts[i];
                if (i >= hi) break;
            }

            while (bolts[--j].compareTo(nut) > 0) {
                if (j < lo + 1) break;
            }

            if (i >= j) break;

            if (bolts[j].compareTo(nut) == 0) equalBolt = bolts[j];
            swap(bolts, i, j);

        }

        assert equalBolt != null;
        return equalBolt;
    }

    private int sortNuts(Nut[] nuts, int lo, int hi, Bolt bolt) {
        if (lo >= hi) return lo;

        int i = lo - 1;
        int j = hi + 1;

        Integer equalNutIndex = null;

        while (i < j) {
            while (nuts[++i].compareTo(bolt) <= 0) {
                if (i >= hi) break;
            }
            while (nuts[--j].compareTo(bolt) > 0) {
                if (j < lo + 1) break;
            }

            if (i >= j) break;

            swap(nuts, i, j);

        }

        return j;
    }
}

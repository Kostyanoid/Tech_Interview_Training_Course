package algoritms.sort;

public interface ShellSortArrayAlg extends SortArrayAlg {

    default int stepSizeGenerator(int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) result  *= 3;
        return (result - 1) / 2;
    }

    default int maxStepIndexResolver(int arraySize) {
        int k = 0;
        while (stepSizeGenerator(k) < arraySize / 2) k++;
        return k - 1;
    }
}

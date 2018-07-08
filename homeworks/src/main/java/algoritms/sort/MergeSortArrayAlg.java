package algoritms.sort;

public interface MergeSortArrayAlg extends SortArrayAlg{
    default void mergeInPlace(Comparable[] array,
                             int firstSubArrayStartIndex,
                             int firstSubArrayEndIndex,
                             int secondSubArrayStartIndex,
                             int secondSubArrayEndIndex) {
        if (firstSubArrayStartIndex > firstSubArrayEndIndex || secondSubArrayStartIndex > secondSubArrayEndIndex
                || firstSubArrayEndIndex >= secondSubArrayStartIndex) throw new IllegalArgumentException();
        if (firstSubArrayStartIndex < 0 || firstSubArrayEndIndex >= array.length
                || secondSubArrayStartIndex < 0 || secondSubArrayEndIndex >= array.length) throw new IndexOutOfBoundsException();

        int mergedArrayIndex = firstSubArrayStartIndex;
        int offset = 0;
        Comparable temp;
        while (firstSubArrayStartIndex <= firstSubArrayEndIndex && secondSubArrayStartIndex <= secondSubArrayEndIndex) {
            if (array[firstSubArrayStartIndex].compareTo(array[secondSubArrayStartIndex]) > 0) {
                temp = array[secondSubArrayStartIndex];
                System.arraycopy(array, mergedArrayIndex, array, mergedArrayIndex + 1, firstSubArrayEndIndex - firstSubArrayStartIndex + 1);
                array[mergedArrayIndex] = temp;
                firstSubArrayStartIndex++;
                firstSubArrayEndIndex++;
                secondSubArrayStartIndex++;
            } else {
                firstSubArrayStartIndex++;
            }
            mergedArrayIndex++;
        }
    }
}

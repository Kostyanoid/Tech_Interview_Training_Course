package algoritms.sort;

public interface MergeSortArrayAlg extends SortArrayAlg{

    @Deprecated
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

    default void merge(Comparable[] array,
                       int firstIndex,
                       int medIndex,
                       int lastIndex) {

        if (firstIndex > medIndex || medIndex + 1 > lastIndex) throw new IllegalArgumentException();
        if (firstIndex < 0 || lastIndex >= array.length) throw new IndexOutOfBoundsException();

        Comparable[] mergedArray = new Comparable[lastIndex - firstIndex + 1];
        int mergedArrayIndex = 0;
        int firstArrayPointer = firstIndex;
        int secondArrayPointer = medIndex + 1;
        while (firstArrayPointer <= medIndex && secondArrayPointer <= lastIndex) {
            if (array[firstArrayPointer].compareTo(array[secondArrayPointer]) > 0) {
                mergedArray[mergedArrayIndex] = array[secondArrayPointer];
                secondArrayPointer++;
            } else {
                mergedArray[mergedArrayIndex] = array[firstArrayPointer];
                firstArrayPointer++;
            }
            mergedArrayIndex++;
        }

        //выполнится только один из циклов
        for (int i = firstArrayPointer; i <= medIndex; i++) {
            mergedArray[mergedArrayIndex++] = array[i];
        }

        for (int i = secondArrayPointer; i <= lastIndex; i++) {
            mergedArray[mergedArrayIndex++] = array[i];
        }

        System.arraycopy(mergedArray, 0, array, firstIndex, mergedArray.length);
    }
}

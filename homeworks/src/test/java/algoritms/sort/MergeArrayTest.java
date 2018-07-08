package algoritms.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeArrayTest {

    @Test
    void mergeInPlace1() {
        Integer[] array = new Integer[] {4, 5, 6, 1, 2, 3};
        Integer[] exceptingResult = new Integer[] {1, 2, 3, 4, 5, 6};

        System.out.println("source: " + Arrays.toString(array));
        System.out.println("expecting result: " + Arrays.toString(exceptingResult));

        new MergeDownSort().mergeInPlace(array, 0, 2, 3, 5);
        System.out.println("result: " + Arrays.toString(array));
        assertArrayEquals(exceptingResult, array);
    }

    @Test
    void mergeInPlace2() {
        Integer[] array = new Integer[] {1, 3, 6, 0, 2, 4, 5};
        Integer[] exceptingResult = new Integer[] {0, 1, 2, 3, 4, 5, 6};

        System.out.println("source: " + Arrays.toString(array));
        System.out.println("expecting result: " + Arrays.toString(exceptingResult));

        new MergeDownSort().mergeInPlace(array, 0, 2, 3, 6);
        System.out.println("result: " + Arrays.toString(array));
        assertArrayEquals(exceptingResult, array);
    }

    @Test
    void mergeInPlace3() {
        Integer[] array = new Integer[] {0, 10, 3, 6, 1, 2, 4, 5, 16, 18, 19};
        Integer[] exceptingResult = new Integer[] {0, 10, 1, 2, 3, 4, 5, 6, 16, 18, 19};

        System.out.println("source: " + Arrays.toString(array));
        System.out.println("expecting result: " + Arrays.toString(exceptingResult));

        new MergeDownSort().mergeInPlace(array, 2, 3, 4, 7);
        System.out.println("result: " + Arrays.toString(array));
        assertArrayEquals(exceptingResult, array);
    }
}
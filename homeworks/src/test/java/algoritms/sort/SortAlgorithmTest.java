package algoritms.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortAlgorithmTest {

    protected SortArrayAlg sortAlg;
    private ShuffleArrayAlg shuffleAlg = new ShuffleArray();

    public SortAlgorithmTest(SortArrayAlg sortAlg) {
        this.sortAlg = sortAlg;
    }

    @Test
    @DisplayName("Sort null array")
    void sortNull() {
        System.out.print("\nSort null array:");
        Comparable[] array = null;
        System.out.println("before: " + Arrays.toString(array));
        sortAlg.sort(array);
        assertNull(array);
        System.out.println("after: " + Arrays.toString(array));
    }

    @Test
    @DisplayName("Sort empty array")
    void sortEmpty() {
        System.out.println("\nSort empty array:");
        Comparable[] array = new Integer[] {};
        System.out.println("before: " + Arrays.toString(array));

        sortAlg.sort(array);

        assertEquals(0, array.length);
        System.out.println("after: " + Arrays.toString(array));
    }

    @Test
    @DisplayName("Sort one element array")
    void sortOneElement() {
        System.out.println("\nSort one element array:");
        Comparable[] array = new Integer[] {5};
        Comparable[] arrayCopy = new Integer [1];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        System.out.println("before: " + Arrays.toString(array));

        sortAlg.sort(array);

        assertArrayEquals(arrayCopy, array);
        System.out.println("after: " + Arrays.toString(array));
    }

    @ParameterizedTest
    @CsvSource({"10", "25", "199", "1000"})
    @DisplayName("Sort some integers array")
    void sortSomeIntegersArray(int N) {
        System.out.println("\nSort some integers array:");
        Comparable[] array = new Integer[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        Comparable[] etalonArray = new Integer [N];
        System.arraycopy(array, 0, etalonArray, 0, array.length);

        shuffleAlg.shuffle(array);

        System.out.println("before: " + Arrays.toString(array));

        sortAlg.sort(array);

        assertArrayEquals(etalonArray, array);
        System.out.println("after: " + Arrays.toString(array));
    }

    @ParameterizedTest
    @CsvSource({"10", "50"})
    @DisplayName("Sort some chars array")
    void sortSomeCharsArray(int N) {
        System.out.println("\nSort some chars array:");
        Comparable[] array = new Character[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (49 + i);
        }

        Comparable[] etalonArray = new Character [N];
        System.arraycopy(array, 0, etalonArray, 0, array.length);

        shuffleAlg.shuffle(array);

        System.out.println("before: " + Arrays.toString(array));

        sortAlg.sort(array);

        assertArrayEquals(etalonArray, array);
        System.out.println("after: " + Arrays.toString(array));
    }

    @Test
    @DisplayName("Sort integer array with some null values")
    void sortSomeIntegersArrayWithNulls() {
        int N = 10;
        System.out.println("\nSort integer array with some null values:");
        Comparable[] array = new Integer[N];
        for (int i = 0; i < array.length; i++) array[i] = i + 1;
        array[3] = null;
        array[7] = null;

        Comparable[] etalonArray = new Integer [N];
        System.arraycopy(array, 0, etalonArray, 0, array.length);

        shuffleAlg.shuffle(array);

        System.out.println("before: " + Arrays.toString(array));

        assertThrows(IllegalArgumentException.class, () -> sortAlg.sort(array));
        System.out.println("after: " + Arrays.toString(array));
    }
}

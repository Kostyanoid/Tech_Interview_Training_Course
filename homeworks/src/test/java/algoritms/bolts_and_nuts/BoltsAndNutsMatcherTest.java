package algoritms.bolts_and_nuts;

import algoritms.sort.ShuffleArray;
import algoritms.sort.ShuffleArrayAlg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoltsAndNutsMatcherTest {

    private ShuffleArrayAlg shuffleAlg = new ShuffleArray();
    private BoltsAndNutsMatcher  matcher = new BoltsAndNutsMatcher();

    @ParameterizedTest
    @CsvSource({"5", "11", "128"})
    @DisplayName("Match for random arrays")
    void match(int N) {
        Bolt[] bolts = new Bolt[N];
        Nut[] nuts = new Nut[N];
        for (int i = 0; i < N; i++) {
            bolts[i] = new Bolt(i + 1);
            nuts[i] = new Nut(i + 1);
        }

        Bolt[] etalonBolts = new Bolt[N];
        Nut[] etalonNuts = new Nut[N];

        System.arraycopy(bolts, 0, etalonBolts, 0, N);
        System.arraycopy(nuts, 0, etalonNuts, 0, N);

        shuffleAlg.shuffle(bolts);
        shuffleAlg.shuffle(nuts);

        System.out.println("Bolts before matching: " + Arrays.toString(bolts));
        System.out.println("Nuts before matching: " + Arrays.toString(nuts));
        matcher.match(bolts, nuts);
        System.out.println("Bolts after matching: " + Arrays.toString(bolts));
        System.out.println("Nuts after matching: " + Arrays.toString(nuts));

        assertArrayEquals(etalonBolts, bolts);
        assertArrayEquals(etalonNuts, nuts);
    }

    @Test
    @DisplayName("Match for fixed arrays, size = 5")
    public void matchFixedArrays() {
        Bolt[] bolts = new Bolt[] {new Bolt(2), new Bolt(5), new Bolt(3), new Bolt(1), new Bolt(4)};
        Nut[] nuts = new Nut[] {new Nut(4), new Nut(1), new Nut(3), new Nut(5), new Nut(2)};

        System.out.println("Bolts before matching: " + Arrays.toString(bolts));
        System.out.println("Nuts before matching: " + Arrays.toString(nuts));
        matcher.match(bolts, nuts);
        System.out.println("Bolts after matching: " + Arrays.toString(bolts));
        System.out.println("Nuts after matching: " + Arrays.toString(nuts));

        for (int i = 0; i < bolts.length; i++)
            assertEquals(0, bolts[i].compareTo(nuts[i]));
    }

    @Test
    @DisplayName("Match for empty arrays")
    public void matchForEmptyArrays() {
        Bolt[] bolts = new Bolt[0];
        Nut[] nuts = new Nut[0];

        System.out.println("Bolts before matching: " + Arrays.toString(bolts));
        System.out.println("Nuts before matching: " + Arrays.toString(nuts));
        matcher.match(bolts, nuts);
        System.out.println("Bolts after matching: " + Arrays.toString(bolts));
        System.out.println("Nuts after matching: " + Arrays.toString(nuts));

        for (int i = 0; i < bolts.length; i++)
            assertEquals(0, bolts[i].compareTo(nuts[i]));
    }

}
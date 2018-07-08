package algoritms.sort;

import java.util.Random;

public class ShuffleArray implements ShuffleArrayAlg {
    private Random random = new Random();

    @Override
    public void shuffle(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            int nextRandomIndex = random.nextInt(array.length);
            swap(array, i, nextRandomIndex);
        }
    }
}

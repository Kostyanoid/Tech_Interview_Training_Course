package algoritms.sort;

import java.util.Arrays;
import java.util.Objects;

public interface SortArrayAlg<E extends Comparable<E>> extends Swapable {

    void sort(E[] array);

    default boolean validate(Object[] array) {
        return Arrays.stream(array).noneMatch(Objects::isNull);
    }
}

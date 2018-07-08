package algoritms.sort;

import java.util.Arrays;
import java.util.Objects;

public interface SortArrayAlg extends Swapable {

    void sort(Comparable[] array);

    default boolean validate(Object[] array) {
        return Arrays.stream(array).noneMatch(Objects::isNull);
    }
}

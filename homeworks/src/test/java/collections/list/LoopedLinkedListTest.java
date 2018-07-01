package collections.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopedLinkedListTest {

    @Test
    @DisplayName("Try to find looped element index")
    void findLoopedElement() {
        String[] values = new String[] {"00", "01", "02", "03", "04", "05"};
        LoopedLinkedList lll = new LoopedLinkedList(values, 4);
        System.out.println(lll.toString());
        int looped = lll.findLoopedElement();
        assertEquals(4, looped);
        System.out.println("Looped: " + looped);
    }
}
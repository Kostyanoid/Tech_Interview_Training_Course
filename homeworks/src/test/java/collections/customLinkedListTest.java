package collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class customLinkedListTest {

    @DisplayName("Add a few elements")
    @Test
    void add() {
        String el1 = "El_1";
        String el2 = "El_2";
        String el3 = "El_3";
        String el4 = "El_4";
        String el5 = "El_5";

        CustomLinkedList list = new CustomLinkedList();
        list.add(el1);
//        System.out.println(list.toString());
        list.add(el2);
//        System.out.println(list.toString());
        list.add(el3);
//        System.out.println(list.toString());
        list.add(el4);
//        System.out.println(list.toString());
        list.add(el5);
        System.out.println(list.toString());
        assertEquals(5, list.length());
    }

    @DisplayName("Get elements by indexes")
    @ParameterizedTest
    @CsvSource({"El_1, 0", "El_3, 2", "El_2, 1", "El_4, 3", "El_5, 4"})
    void testGetByIndex(String expected, int index) {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};
        CustomLinkedList list = new CustomLinkedList(strings);
        assertEquals(expected, list.get(index));
    }

    @DisplayName("Get element by index outing of bound")
    @Test
    void testGetByIndexOutOfBounds() {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};
        CustomLinkedList list = new CustomLinkedList(strings);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(6));
    }

    @DisplayName("Delete one element from interior")
    @Test
    void testDeleteFromInterior() {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};
        CustomLinkedList list = new CustomLinkedList(strings);
        System.out.println(list);

        list.delete(3);
        System.out.println(list);

        assertEquals(4, list.length());
        assertEquals("El_5", list.get(3));
    }

    @DisplayName("Delete head")
    @Test
    void testDeleteHead() {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};
        CustomLinkedList list = new CustomLinkedList(strings);
        System.out.println(list);

        list.delete(0);
        System.out.println(list);

        assertEquals(4, list.length());
        assertEquals("El_2", list.get(0));
    }

    @DisplayName("Delete tail")
    @Test
    void testDeleteTail() {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};
        CustomLinkedList list = new CustomLinkedList(strings);
        System.out.println(list);

        list.delete(list.length() - 1);
        System.out.println(list);

        assertEquals(4, list.length());
        assertEquals("El_4", list.get(list.length() - 1));
    }

    @DisplayName("Delete once")
    @Test
    void deleteOnce() {
        String[] strings = new String[] {"El_1"};
        CustomLinkedList list = new CustomLinkedList(strings);
        System.out.println(list);

        list.delete(0);
        assertEquals(0, list.length());
    }

    @DisplayName("Delete from empty list")
    @Test
    void deleteFromEmptyList() {
        CustomLinkedList list = new CustomLinkedList();
        System.out.println(list);

        assertThrows(IndexOutOfBoundsException.class,() -> list.delete(0));
    }

    @DisplayName("Delete element by index out of bounds")
    @Test
    void testDeleteOutOfBounds() {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};
        CustomLinkedList list = new CustomLinkedList(strings);

        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(5));
    }
}
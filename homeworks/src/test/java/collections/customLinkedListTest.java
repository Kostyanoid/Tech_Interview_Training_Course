package collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class customLinkedListTest {

    @Test
    void add() {
        String el1 = "El_1";
        String el2 = "El_2";
        String el3 = "El_3";
        String el4 = "El_4";
        String el5 = "El_5";

        CustomLinkedList list = new CustomLinkedList();
        list.add(el1);
        System.out.println(list.toString());
        list.add(el2);
        System.out.println(list.toString());
        list.add(el3);
        System.out.println(list.toString());
        list.add(el4);
        System.out.println(list.toString());
        list.add(el5);
        System.out.println(list.toString());
        assertEquals(5, list.length());
    }

    @ParameterizedTest
    @CsvSource({"El_1, 0", "El_3, 2", "El_2, 1", "El_4, 3", "El_5, 4"})
    void testGetByIndex(String expected, int index) {
        String[] strings = new String[] {"El_1", "El_2", "El_3", "El_4", "El_5"};

        CustomLinkedList list = new CustomLinkedList(strings);
//        System.out.println(list);
        assertEquals(expected, list.get(index));
    }
}
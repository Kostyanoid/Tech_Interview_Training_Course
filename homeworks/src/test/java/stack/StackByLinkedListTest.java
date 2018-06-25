package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackByLinkedListTest {

    @Test
    void putSeveralValues() {
        String el1 = "'1'";
        String el2 = "'2'";
        String el3 = "'3'";
        String el4 = "'4'";
        String el5 = "'5'";

        StackByLinkedList stack = new StackByLinkedList();
        stack.push(el1);
        stack.push(el2);
        stack.push(el3);
        stack.push(el4);
        stack.push(el5);

        assertEquals(5, stack.size());
        System.out.println(stack.toString());
    }

    @Test
    void emptyStack() {
        StackByLinkedList stack = new StackByLinkedList();
        assertTrue(stack.isEmpty());
        System.out.println(stack.toString());
    }

    @Test
    void putNullValues() {
        Object[] values = new Object[] {"'1'", null, "'3'", null, null};
        StackByLinkedList stack = new StackByLinkedList(values);
        assertEquals(5, stack.size());
        System.out.println(stack.toString());
    }

    @Test
    void pushOneValue() {
        Object[] values = new Object[] {"'1'", null, "'3'", null, "'6'"};
        StackByLinkedList stack = new StackByLinkedList(values);
        System.out.println(stack.toString());

        Object received = stack.pop();
        assertEquals(values[4], received);
        assertEquals(4, stack.size());
        System.out.println(stack.toString());
    }
}
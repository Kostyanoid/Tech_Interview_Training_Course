package collections.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackByLinkedListTest {

    @DisplayName("Push several values into the stack")
    @Test
    void pushSeveralValues() {
        System.out.println("Push several values into the stack:");
        String el1 = "'1'";
        String el2 = "'2'";
        String el3 = "'3'";
        String el4 = "'4'";
        String el5 = "'5'";

        IStack stack = new StackByLinkedList();
        stack.push(el1);
        stack.push(el2);
        stack.push(el3);
        stack.push(el4);
        stack.push(el5);

        assertEquals(5, stack.size());
        System.out.println(stack.toString());
    }

    @DisplayName("Check for empty stack")
    @Test
    void emptyStack() {
        System.out.println("Check for empty collections.stack:");
        IStack stack = new StackByLinkedList();
        assertTrue(stack.isEmpty());
        System.out.println(stack.toString());
    }

    @DisplayName("Push null values into the stack")
    @Test
    void pushNullValues() {
        System.out.println("Push null values into the stack:");
        Object[] values = new Object[] {"'1'", null, "'3'", null, null};
        IStack stack = new StackByLinkedList(values);
        assertEquals(5, stack.size());
        System.out.println(stack.toString());
    }

    @DisplayName("Pop one value")
    @Test
    void popOneValue() {
        System.out.println("Pop one value:");
        Object[] values = new Object[] {"'1'", null, "'3'", null, "'6'"};
        IStack stack = new StackByLinkedList(values);
        System.out.println(stack.toString());

        Object received = stack.pop();
        assertEquals(values[4], received);
        assertEquals(4, stack.size());
        System.out.println(stack.toString());
        System.out.println("Received value: " + received);
    }

    @DisplayName("Pop all values from the stack")
    @Test
    void popAllValues() {
        System.out.println("Pop all values from the stack:");
        Object[] values = new Object[] {"'1'", "'2'", "'3'", null, "'6'"};
        IStack stack = new StackByLinkedList(values);
        System.out.println(stack.toString());

        while (!stack.isEmpty()) {
            Object received = stack.pop();
            System.out.println(stack.toString());
            System.out.println("Received value: " + received);
        }
        assertEquals(0, stack.size());
    }

    @DisplayName("Pop from empty stack")
    @Test
    void popFromEmptyStack() {
        System.out.println("Pop from empty stack:");
        IStack stack = new StackByLinkedList();
        System.out.println(stack.toString());

        assertThrows(NoElementsInStackException.class, stack::pop);
    }


    @DisplayName("Push and pop values from the stack")
    @Test
    void pushAndPopAllValues() {
        System.out.println("Push and pop values from the stack:");
        Object[] values = new Object[] {"'1'", "'2'", "'3'", "'4'", "'5'"};
        IStack stack = new StackByLinkedList();
        System.out.println(stack.toString());

        System.out.println("Push: " + values[0]);
        stack.push(values[0]);
        assertEquals(1, stack.size());
        System.out.println(stack.toString());

        System.out.println("Push: " + values[1]);
        stack.push(values[1]);
        assertEquals(2, stack.size());
        System.out.println(stack.toString());

        System.out.println("Pop: received " + stack.pop());
        assertEquals(1, stack.size());
        System.out.println(stack.toString());

        System.out.println("Push: " + values[3]);
        stack.push(values[3]);
        assertEquals(2, stack.size());
        System.out.println(stack.toString());

        System.out.println("Pop: received " + stack.pop());
        assertEquals(1, stack.size());
        System.out.println(stack.toString());

        System.out.println("Pop: received " + stack.pop());
        assertEquals(0, stack.size());
        System.out.println(stack.toString());

        System.out.println("Push: " + values[4]);
        stack.push(values[4]);
        assertEquals(1, stack.size());
        System.out.println(stack.toString());
    }
}
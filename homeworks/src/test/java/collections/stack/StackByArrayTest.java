package collections.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackByArrayTest {

    @DisplayName("Push several values into the collections.stack")
    @Test
    void pushSeveralValues() {
        System.out.println("Push several values into the collections.stack:");
        String el1 = "'1'";
        String el2 = "'2'";
        String el3 = "'3'";
        String el4 = "'4'";
        String el5 = "'5'";

        IStack stack = new StackByArray();
        stack.push(el1);
        stack.push(el2);
        stack.push(el3);
        stack.push(el4);
        stack.push(el5);

        assertEquals(5, stack.size());
        System.out.println(stack.toString());
    }

    @DisplayName("Check for empty collections.stack")
    @Test
    void emptyStack() {
        System.out.println("Check for empty collections.stack:");
        IStack stack = new StackByArray();
        assertTrue(stack.isEmpty());
        System.out.println(stack.toString());
    }

    @DisplayName("Push null values into the collections.stack")
    @Test
    void pushNullValues() {
        System.out.println("Push null values into the collections.stack:");
        Object[] values = new Object[] {"'1'", null, "'3'", null, null};
        IStack stack = new StackByArray(values);
        assertEquals(5, stack.size());
        System.out.println(stack.toString());
    }

    @DisplayName("Pop one value")
    @Test
    void popOneValue() {
        System.out.println("Pop one value:");
        Object[] values = new Object[] {"'1'", null, "'3'", null, "'6'"};
        IStack stack = new StackByArray(values);
        System.out.println(stack.toString());

        Object received = stack.pop();
        assertEquals(values[4], received);
        assertEquals(4, stack.size());
        System.out.println(stack.toString());
        System.out.println("Received value: " + received);
    }

    @DisplayName("Pop all values from the collections.stack")
    @Test
    void popAllValues() {
        System.out.println("Pop all values from the collections.stack:");
        Object[] values = new Object[] {"'1'", "'2'", "'3'", null, "'6'"};
        IStack stack = new StackByArray(values);
        System.out.println(stack.toString());

        while (!stack.isEmpty()) {
            Object received = stack.pop();
            System.out.println(stack.toString());
            System.out.println("Received value: " + received);
        }
        assertEquals(0, stack.size());
    }

    @DisplayName("Pop from empty collections.stack")
    @Test
    void popFromEmptyStack() {
        System.out.println("Pop from empty collections.stack:");
        IStack stack = new StackByArray();
        System.out.println(stack.toString());

        assertThrows(NoElementsInStackException.class, stack::pop);
    }


    @DisplayName("Push and pop values from the collections.stack")
    @Test
    void pushAndPopAllValues() {
        System.out.println("Push and pop values from the collections.stack:");
        Object[] values = new Object[] {"'1'", "'2'", "'3'", "'4'", "'5'"};
        IStack stack = new StackByArray();
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

    @DisplayName("Push more than capacity values")
    @Test
    void pushMoreThanCapacityValues() {
        System.out.println("Push more than capacity values:");
        StackByArray stack = new StackByArray();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
            System.out.println("Pushed value: " + i + ", capacity = " + stack.getCapacity());
            System.out.println(stack.toString());
        }
        assertEquals(12 * 3 / 2, stack.getCapacity());
        assertEquals(15, stack.size());
    }

}
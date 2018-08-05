package collections.queue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayPriorityQueueTest {

    @Test
    @DisplayName("Try to poll from an empty queue. Expected: null")
    void test_1() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        assertTrue(pq.isEmpty());
        assertNull(pq.poll());
    }

    @Test
    @DisplayName("Try to remove from an empty queue. Expected: null")
    void test_2() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        assertTrue(pq.isEmpty());
        assertNull(pq.remove());
    }

    @Test
    @DisplayName("Create a new priority queue from array of integer. Expected: size = 10")
    void test_3() {
        Integer[] numbers = ThreadLocalRandom.current().ints(10, 0, 100).boxed().toArray(Integer[]::new);
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(numbers);
        assertEquals(10, pq.size());
    }

    @Test
    @DisplayName("Create a new priority and put 1 integer. Expected: queue size = 1")
    void test_3_1() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        pq.insert(5);
        assertEquals(1, pq.size());
    }

    @Test
    @DisplayName("Create a new priority and put 1 integer. And then poll. Expected: the same integer, queue size = 1")
    void test_4() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        pq.insert(5);
        assertEquals(Integer.valueOf(5), pq.poll());
        assertEquals(1, pq.size());
    }

    @Test
    @DisplayName("Create a new priority and put 1 integer. And then remove. Expected: the same integer, queue size = 0")
    void test_5() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        pq.insert(5);
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(0, pq.size());
    }

    @Test
    @DisplayName("Create a new priority and put 10 numbers from 1 to 10 randomly. And then poll MAX. Expected: 10")
    void test_6() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        pq.insert(5); pq.insert(2); pq.insert(8); pq.insert(9);
        pq.insert(1); pq.insert(3); pq.insert(6); pq.insert(10);
        pq.insert(7); pq.insert(4);
        assertEquals(10, pq.size());
        assertEquals(Integer.valueOf(10), pq.poll());
    }

    @Test
    @DisplayName("Create a new priority and put 10 numbers from 1 to 10 randomly. And then remove MAX. Expected: 10")
    void test_7() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        pq.insert(5); pq.insert(2); pq.insert(8); pq.insert(9);
        pq.insert(1); pq.insert(3); pq.insert(6); pq.insert(10);
        pq.insert(7); pq.insert(4);
        assertEquals(10, pq.size());
        assertEquals(Integer.valueOf(10), pq.remove());
        assertEquals(9, pq.size());
    }

    @Test
    @DisplayName("Create a new priority and put 10 numbers from 1 to 10 randomly. And then remove MAX 10 times. Expected: 10, 9, ... , 1")
    void test_8() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        pq.insert(5); pq.insert(2); pq.insert(8); pq.insert(9);
        pq.insert(1); pq.insert(3); pq.insert(6); pq.insert(10);
        pq.insert(7); pq.insert(4);
        assertEquals(10, pq.size());
        assertEquals(Integer.valueOf(10), pq.remove());
        assertEquals(Integer.valueOf(9), pq.remove());
        assertEquals(Integer.valueOf(8), pq.remove());
        assertEquals(Integer.valueOf(7), pq.remove());
        assertEquals(Integer.valueOf(6), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(4), pq.remove());
        assertEquals(Integer.valueOf(3), pq.remove());
        assertEquals(Integer.valueOf(2), pq.remove());
        assertEquals(Integer.valueOf(1), pq.remove());
        assertTrue(pq.isEmpty());
    }

    @Test
    @DisplayName("Create a new priority and insert 10 equal numbers. And then remove MAX 10 times. Expected: size 10, the same number 10 times")
    void test_9() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        for (int i = 0; i < 10; i++) {
            pq.insert(5);
        }
        assertEquals(10, pq.size());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertEquals(Integer.valueOf(5), pq.remove());
        assertTrue(pq.isEmpty());
    }

    @Test
    @DisplayName("Try yo insert 'null' to the priority queue. Excepted: IllegalArgumentException.")
    void test_10() {
        IPriorityQueue<Integer> pq = new ArrayPriorityQueue<>(10);
        assertThrows(IllegalArgumentException.class, () -> pq.insert(null));
    }
}

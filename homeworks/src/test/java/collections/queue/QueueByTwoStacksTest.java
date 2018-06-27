package collections.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueByTwoStacksTest {

    @DisplayName("Offer several values into the custom queue")
    @Test
    void offerSeveralValues() {
        System.out.println("\nTest: Offer several values into the custom queue:");
        String val1 = "val_1";
        String val2 = "val_2";
        String val3 = "val_3";
        String val4 = "val_4";
        String val5 = "val_5";

        IQueue queue = new QueueByTwoStacks();
        queue.offer(val1);
        queue.offer(val2);
        queue.offer(val3);
        queue.offer(val4);
        queue.offer(val5);
        assertEquals(5, queue.size());
        System.out.println(queue.toString());
    }

    @DisplayName("Offer null values into the custom queue")
    @Test
    void OfferNullValues() {
        System.out.println("\nTest: Offer null values into the queue:");
        Object[] values = new Object[] {"val_1", null, "val_3", null, null};
        IQueue queue = new QueueByTwoStacks(values);
        assertEquals(5, queue.size());
        System.out.println(queue.toString());
    }

    @DisplayName("Check for an empty queue")
    @Test
    void checkForEmptyQueue() {
        System.out.println("\nTest: Check for an empty queue:");
        IQueue queue = new QueueByTwoStacks();
        assertTrue(queue.isEmpty());
        System.out.println(queue.toString());
    }

    @DisplayName("Peek one value from a not empty queue")
    @Test
    void peekOneValueFromNotEmptyQueue() {
        System.out.println("\nTest: Peek one value from a not empty queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        System.out.println(queue.toString());
        Object peekedValue = queue.peek();
        assertEquals(values[0], peekedValue);
        System.out.printf("Peeked value is '%s'", peekedValue);
    }

    @DisplayName("Peek one value from an empty queue")
    @Test
    void peekOneValueFromEmptyQueue() {
        System.out.println("\nTest: Peek one value from an empty queue:");
        IQueue queue = new QueueByTwoStacks();
        System.out.println(queue.toString());
        Object peekedValue = queue.peek();
        assertNull(peekedValue);
        System.out.printf("Peeked value is '%s'\n", peekedValue);
    }

    @DisplayName("Poll one value from the custom queue")
    @Test
    void pollOneValueFromTheQueue() {
        System.out.println("\nTest: Poll one value from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        System.out.println(queue.toString());
        Object polledValue = queue.poll();
        assertEquals(values[0], polledValue);
        assertEquals(4, queue.size());
        System.out.printf("Polled value is '%s'\n", polledValue);
        System.out.printf("Queue is '%s'", queue.toString());
    }

    @DisplayName("Poll one value from an empty queue")
    @Test
    void pollOneValueFromEmptyQueue() {
        System.out.println("\nTest: Poll one value from an empty queue:");
        IQueue queue = new QueueByTwoStacks();
        System.out.println(queue.toString());
        Object polledValue = queue.poll();
        assertNull(polledValue);
        System.out.printf("Polled value is '%s'\n", polledValue);
    }

    @DisplayName("Poll all values from the custom queue")
    @Test
    void pollAllValueFromTheQueue() {
        System.out.println("\nTest: Poll all values from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            Object polledValue = queue.poll();
            System.out.printf("Polled value is '%s'\n", polledValue);
        }
        assertEquals(0, queue.size());
        System.out.printf("Queue is:\n%s", queue.toString());
    }

    @DisplayName("Poll one more then queue's size values from the custom queue")
    @Test
    void pollOneMoreValuesFromTheQueue() {
        System.out.println("\nTest: Poll one more then queue's size values from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            Object polledValue = queue.poll();
            System.out.printf("Polled value is '%s'\n", polledValue);
        }
        System.out.printf("Queue is:\n%s", queue.toString());
        Object polledValue = queue.poll();
        assertEquals(0, queue.size());
        assertNull(polledValue);
        System.out.printf("Polled value is '%s'\n", polledValue);
    }

    @DisplayName("Check for size")
    @Test
    void checkForSize() {
        String val1 = "val_1";
        String val2 = "val_2";
        String val3 = "val_3";
        String val4 = "val_4";
        String val5 = "val_5";

        IQueue queue = new QueueByTwoStacks();
        assertEquals(0, queue.size());
        queue.offer(val1);
        queue.offer(val2);
        queue.offer(val3);
        queue.offer(val4);
        queue.offer(val5);
        assertEquals(5, queue.size());
        System.out.println(queue.toString());
    }

    @DisplayName("Offer and Poll values from the custom queue")
    @Test
    void offerAndPollAllValues() {
        System.out.println("\nTest: Offer and Poll values from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks();
        System.out.println(queue.toString());

        System.out.println("Offer: " + values[0]);
        queue.offer(values[0]);
        assertEquals(1, queue.size());
        System.out.println(queue.toString());

        System.out.println("Offer: " + values[1]);
        queue.offer(values[1]);
        assertEquals(2, queue.size());
        System.out.println(queue.toString());

        System.out.println("Poll: received " + queue.poll());
        assertEquals(1, queue.size());
        System.out.println(queue.toString());

        System.out.println("Offer: " + values[3]);
        queue.offer(values[3]);
        assertEquals(2, queue.size());
        System.out.println(queue.toString());

        System.out.println("Poll: received " + queue.poll());
        assertEquals(1, queue.size());
        System.out.println(queue.toString());

        System.out.println("Poll: received " + queue.poll());
        assertEquals(0, queue.size());
        System.out.println(queue.toString());

        System.out.println("Offer: " + values[4]);
        queue.offer(values[4]);
        assertEquals(1, queue.size());
        System.out.println(queue.toString());
    }

    @DisplayName("Remove one value from the custom queue")
    @Test
    void removeOneValueFromTheQueue() {
        System.out.println("\nTest: Remove one value from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        System.out.println(queue.toString());
        Object removedValue = queue.remove();
        assertEquals(values[0], removedValue);
        assertEquals(4, queue.size());
        System.out.printf("Removed value is '%s'\n", removedValue);
        System.out.printf("Queue is:\n%s", queue.toString());
    }

    @DisplayName("Remove one value from an empty queue")
    @Test
    void removeOneValueFromEmptyQueue() {
        System.out.println("\nTest: Remove one value from an empty queue:");
        IQueue queue = new QueueByTwoStacks();
        System.out.println(queue.toString());
        assertThrows(NoElementsInQueueException.class, queue::remove);
    }

    @DisplayName("Remove all values from the custom queue")
    @Test
    void removeAllValueFromTheQueue() {
        System.out.println("\nTest: Remove all values from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            Object removeValue = queue.remove();
            System.out.printf("Removed value is '%s'\n", removeValue);
        }
        assertEquals(0, queue.size());
        System.out.printf("Queue is:\n%s", queue.toString());
    }

    @DisplayName("Remove one more then queue's size values from the custom queue")
    @Test
    void removeOneMoreValuesFromTheQueue() {
        System.out.println("\nTest: Remove one more then queue's size values from the custom queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            Object removedValue = queue.remove();
            System.out.printf("Polled value is '%s'\n", removedValue);
        }
        System.out.printf("Queue is:\n%s", queue.toString());
        assertThrows(NoElementsInQueueException.class,queue::remove);
    }

    @DisplayName("Get 'element' from a not empty queue")
    @Test
    void elementFromNotEmptyQueue() {
        System.out.println("\nTest: Get 'element' from a not empty queue:");
        Object[] values = new Object[] {"val_1", "val_2", "val_3", "val_4", "val_5"};
        IQueue queue = new QueueByTwoStacks(values);
        System.out.println(queue.toString());
        Object peekedValue = queue.element();
        assertEquals(values[0], peekedValue);
        System.out.printf("Received value is '%s'\n", peekedValue);
    }

    @DisplayName("Get 'element' from an empty queue")
    @Test
    void elementFromEmptyQueue() {
        System.out.println("\nTest: Get 'element' from an empty queue:");
        IQueue queue = new QueueByTwoStacks();
        System.out.println(queue.toString());
        assertThrows(NoElementsInQueueException.class, queue::element);
    }

}
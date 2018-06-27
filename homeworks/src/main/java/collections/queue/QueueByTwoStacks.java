package collections.queue;

import collections.stack.IStack;
import collections.stack.StackByLinkedList;

import java.util.Arrays;

public class QueueByTwoStacks implements IQueue {

    private IStack stackOffer;
    private IStack stackPoll;

    public QueueByTwoStacks() {
        stackOffer = new StackByLinkedList();
        stackPoll = new StackByLinkedList();
    }

    public QueueByTwoStacks(Object[] values) {
        this();
        Arrays.stream(values).forEach(this::offer);
    }

    @Override
    public void offer(Object value) {
        stackOffer.push(value);
    }

    @Override
    public Object poll() {
        if (isEmpty()) return null;
        if (stackPoll.isEmpty())
            while (!stackOffer.isEmpty()) stackPoll.push(stackOffer.pop());
        return stackPoll.pop();
    }

    @Override
    public Object peek() {
        if (isEmpty()) return null;
        if (stackPoll.isEmpty())
            while (!stackOffer.isEmpty()) stackPoll.push(stackOffer.pop());
        Object result = stackPoll.pop();
        stackPoll.push(result);
        return result;
    }

    @Override
    public Object remove() throws NoElementsInQueueException {
        if (isEmpty()) throw new NoElementsInQueueException();
        if (stackPoll.isEmpty())
            while (!stackOffer.isEmpty()) stackPoll.push(stackOffer.pop());
        return stackPoll.pop();
    }

    @Override
    public Object element() throws NoElementsInQueueException {
        if (isEmpty()) throw new NoElementsInQueueException();
        if (stackPoll.isEmpty())
            while (!stackOffer.isEmpty()) stackPoll.push(stackOffer.pop());
        Object result = stackPoll.pop();
        stackPoll.push(result);
        return result;
    }

    @Override
    public int size() {
        return stackPoll.size() + stackOffer.size();
    }

    @Override
    public boolean isEmpty() {
        return stackPoll.isEmpty() && stackOffer.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack 'offer': ").append(stackOffer.toString()).append("\n");
        sb.append("Stack 'poll': ").append(stackPoll.toString()).append("\n");
        return sb.toString();
    }
}

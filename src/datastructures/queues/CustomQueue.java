package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        try {
            list.addLast((T) t);
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Queue is full or operation failed");
        }
    }

    @Override
    public boolean offer(Object t) {
        try {
            list.addLast((T) t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    // TODO: Override and fill the methods to complete the data structure

}
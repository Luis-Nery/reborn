package DSA;

import java.util.NoSuchElementException;

public class Queue<T> {
    private MyLinkedList<T> list;

    public Queue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T value) {
        list.add(value);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T result = list.get(0);
        list.remove(0);
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.get(0);

    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
    }
}

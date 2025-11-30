package DSA;

public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;

    public CircularQueue(int capacity) {
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(int number) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear+1)%arr.length;
            arr[rear] = number;
        }
    }

    public int dequeue() {
        int value;
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else {
            value = arr[front];
            front = (front + 1)%arr.length;
            if (front == rear) {
                front = -1;
                rear = -1;
            }
        }
        return value;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == arr.length - 1) || (front == rear + 1);
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    public void printQueue() {
        int i;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for ( i = front; i != rear; i=(i+1)%arr.length) {
            System.out.println(arr[i]);
        }
        System.out.println(arr[i]);

    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        q.enqueue(6);
        System.out.println(q.isFull());
        System.out.println(q.isEmpty());
        q.printQueue();
    }
}

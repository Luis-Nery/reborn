package DSA;

public class Queue {
    private int[] arr;
    private int front;
    private int rear;

    public Queue(int capacity) {
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
            arr[++rear] = number;
        }
    }

    public int dequeue() {
        int value;
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else {
            value = arr[front++];
            if (front >= rear) {
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
        return rear == arr.length - 1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        System.out.println(q.isFull());
        System.out.println(q.isEmpty());
        q.printQueue();
    }
}

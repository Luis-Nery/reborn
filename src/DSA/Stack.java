package DSA;

import java.util.EmptyStackException;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        } else {
            arr[++top] = value;
        }
    }

    public int pop() {
        try {
            if (isEmpty()) {
                throw new EmptyStackException();
            } else {
                return arr[top--];
            }

        } catch (EmptyStackException e) {
            System.out.println("The stack is already empty.");
            throw e;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            throw e;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }
}

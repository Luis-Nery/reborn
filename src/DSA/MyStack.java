package DSA;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> {
    private ArrayList<T> stack;

    public MyStack() {
        stack = new ArrayList<T>();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return stack.size();
    }
}

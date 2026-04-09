package DSA;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.data).append(" -> ").append(this.next);
            return sb.toString();
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Add behavior straight to the tail
    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            this.tail = head;
        } else {
            tail.next = new Node<>(value);
            tail = tail.next;
        }
        this.size++;
    }

    public void add(int index, T value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null && index == 0) {
            add(value);
            return;
        }
        if (index == 0 && head != null) {
            Node<T> temp = head;
            head = new Node<>(value);
            head.next = temp;
            size++;
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> tempNode = current.next;
        if (tempNode != null && tempNode.next == null) {
            this.tail = tempNode;
        }
        current.next = new Node<>(value);
        current = current.next;
        current.next = tempNode;
        if (tempNode == null) {
            this.tail = current; // current IS the new node now
        }
        this.size++;
    }

    public boolean remove(int index) {
        //0,1,2,3,4
        if(size == 0){
            throw new IllegalArgumentException("Size is 0");
        }
        if(size == 1&&index==0){
            head=null;
            tail=null;
            size--;
            return true;
        }

        if (index == 0 && head.next != null) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        if (current.next == null) {
            this.tail = current;
        }
        this.size--;
        return true;
    }

    public T get(int index){
        Node<T> current = head;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds " + index);
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

}

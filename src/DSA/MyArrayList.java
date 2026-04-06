package DSA;

public class MyArrayList<T> {
    private T[] array;
    private int capacity;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[10];
        capacity = array.length;
        size = 0;
    }

    private void resize() {
        if (size >= capacity) {
            T[] newArray = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            capacity = newArray.length;
        }
    }

    public void add(T value) {
        resize();
        //case 1-- the item we want to add is after headIndex
        array[size] = value;
        size++;
    }

    public void add(int index, T value) {
        //case 2 -- The item we want to add is before headIndex, shift everything right once
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }
        resize();
        //[0,1,2,3,4,,6,7,null,null]
        if (index < size) {
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
        }
        array[index] = value;
        size++;
    }

    public void remove(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("There is no items in the array list");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }
        return array[index];
    }

    public int size() {
        return this.size;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < size; i++) {
            text.append(array[i]).append(" ");
        }
        return text.toString();
    }

}

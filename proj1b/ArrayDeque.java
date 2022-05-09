public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int head;
    private int tail;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = 0;
        tail = 0;
    }
    private int correctIndex(int index) {
        if (index < 0) {
            return index + items.length;
        } else if (index >= items.length) {
            return index - items.length;
        } else {
            return index;
        }
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int j = head;
        for (int i = size - 1; i >= 0; i--) {
            a[i] = items[j];
            j = correctIndex(j - 1);
        }
        head = size - 1;
        tail = capacity - 1;
        items = a;
    }
    public void addFirst(T item) {
        if (items.length == size) {
            resize(size * 2);
        }
        if (size == 0) {
            items[head] = item;
            tail = correctIndex(tail - 1);
        } else {
            head = correctIndex(head + 1);
            items[head] = item;
        }
        size += 1;
    }
    public void addLast(T item) {
        if (items.length == size) {
            resize(size * 2);
        }
        if (size == 0) {
            items[head] = item;
            tail = correctIndex(tail - 1);
        } else {
            items[tail] = item;
            tail = correctIndex(tail - 1);
        }
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        int j = correctIndex(head);
        for (int i = 0; i < size; i++) {
            System.out.print(items[j] + " ");
            j = correctIndex(j - 1);
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T res = items[head];
        head = correctIndex(head - 1);
        size -= 1;
        if (items.length > 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return res;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T res = items[correctIndex(tail + 1)];
        tail = correctIndex(tail + 1);
        size -= 1;
        if (items.length > 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return res;
    }
    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }
        return items[correctIndex(head - index)];
    }
}

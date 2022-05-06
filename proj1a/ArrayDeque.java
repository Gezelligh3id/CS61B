public class ArrayDeque<T> {
    private T[] items;
    private int size;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addFirst(T item) {
        T[] a = (T[]) new Object[items.length + 1];
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        items[0] = item;
        size += 1;
    }
    public void addLast(T item) {
        if(size == items.length) {
            resize(size*2);
        }
        items[size] = item;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T ans = items[0];
        T[] a = (T[]) new Object[items.length - 1];
        System.arraycopy(items, 1, a, 0, size-1);
        items = a;
        size -= 1;
        return ans;
    }
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T ans = items[size - 1];
        size -= 1;
        if(size >= 16 && size <= items.length * 0.25){
            resize(items.length / 2);
        }
        return ans;
    }
    public T get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return items[index];
    }
}

//public class ArrayDeque<T> {
//    private T[] items;
//    private int size;
//    private int head;
//    private int tail;
//    public ArrayDeque() {
//        items = (T[]) new Object[8];
//        size = 0;
//        head = 0;
//        tail = 0;
//    }
//    public int CorrectIndex(int index){
//        if (index < 0) {
//            return index + size;
//        } else if (index > size) {
//            return index - size;
//        } else {
//            return index;
//        }
//    }
//    public void resize(int capacity) {
//        T[] a = (T[]) new Object[capacity];
//        if (tail < head) {
//           for(int i = 0; i <= tail; i++) {
//               a[i + size] = items[i];
//           }
//           for(int i = head; i <= size-tail; i++){
//               a[]
//           }
//        }
//    }
//    public void addFirst(T item) {
//        if(items.length == size){
//            resize(size * 2);
//        }
//        head = CorrectIndex(head-1);
//        items[head] = item;
//    }
//    public void addLast(T item) {
//
//    }
//    public boolean isEmpty() {
//        return size == 0;
//    }
//    public int size() {
//        return size;
//    }
//    public void printDeque() {
//        for(int i = 0; i < size; i++) {
//            System.out.print(items[i] + " ");
//        }
//    }
//    public T removeFirst() {
//    }
//    public T removeLast() {
//    }
//    public T get(int index){
//    }
//}

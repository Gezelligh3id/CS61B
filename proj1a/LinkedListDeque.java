public class LinkedListDeque<T> {
    private class Node<T> {
        Node prev;
        Node next;
        T value;
        public Node(T a) {
            prev = null;
            next = null;
            value = a;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public LinkedListDeque() {
        head = new Node(99);
        tail = new Node(99);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void addFirst(T item) {
        Node tmp = new Node(item);
        Node next = head.next;
        head.next = tmp;
        tmp.next = next;
        next.prev = tmp;
        tmp.prev = head;
        size += 1;
    }
    public void addLast(T item) {
        Node tmp = new Node(item);
        Node prev = tail.prev;
        prev.next = tmp;
        tail.prev = tmp;
        tmp.next = tail;
        tmp.prev = prev;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Node tmp = head.next;
        while (tmp.next != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ans = (T) head.next.value;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return ans;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T ans = (T) tail.prev.value;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
        return ans;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (size == 0) {
            return null;
        }
        Node tmp = head.next;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return (T) tmp.value;
    }
    private T getRecursive1(int index, Node p) {
        if (index == 0) {
            return (T) p.value;
        } else {
            return (T) getRecursive1(index - 1, p.next);
        }

    }

    public T getRecursive(int index) {
        if (size == 0) {
            return null;
        } else if (index < 0 || index >= size) {
            return null;
        }
        return (T) getRecursive1(index, head.next);
    }
}

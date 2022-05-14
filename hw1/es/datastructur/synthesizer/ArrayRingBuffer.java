package es.datastructur.synthesizer;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement es.datastructur.synthesizer.BoundedQueue<T>

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    //private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if (this.isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        this.fillCount += 1;
        rb[last] = x;
        this.last = (this.last + 1) % this.capacity;
        return;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        this.fillCount -= 1;
        T ans = rb[this.first];
        this.first = (this.first + 1) % this.capacity;
        return ans;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iteration();
    }

    private class Iteration implements Iterator<T> {
        int pointer = -1;
        List<T> list = new ArrayList<T>();
        Iteration() {
            while (!isEmpty()) {
                list.add(dequeue());
            }
            for (int i = 0; i < capacity; i++) {
                enqueue(list.get(i));
            }
            if (!isEmpty()) {
                pointer = 0;
            }
        }


        public boolean hasNext() {
            if (pointer == -1 || pointer == capacity) {
                return false;
            }
            return true;


        }
        public T next() {
            T temp = list.get(pointer);
            pointer++;
            return temp;
        }


    }

}

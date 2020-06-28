package PriorityQueue;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxPriorityQueue {

    Integer[] heap;
    int size;

    public MaxPriorityQueue(Integer capacity) {

        this.heap = new Integer[capacity + 1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(int x) {
        if (this.size == heap.length - 1) {
            resize(2 * heap.length);
        }
        size++;
        heap[size] = x;
        swim(size);

    }

    private void swim(int i) {

        while (i > 1 && heap[i / 2] < heap[i]) {  // Changing '<' to '>' makes it a Min Heap from a Max Heap !!
            int temp = heap[i];
            heap[i] = heap[i / 2];
            heap[i / 2] = temp;
            i = i / 2;
        }
    }

    private void resize(int capacity) {
        Integer[] temp = Arrays.copyOf(heap, capacity);
        heap = temp;
    }

    private void printMaxPQ() {
        Stream.of(heap).filter(Objects::nonNull).map(x -> x + " ").forEach(System.out::print);
    }

    public static void main(String[] args) {
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(3);
        System.out.println(maxPriorityQueue.isEmpty());
        System.out.println(maxPriorityQueue.size());
        maxPriorityQueue.insert(5);
        maxPriorityQueue.insert(3);
        maxPriorityQueue.insert(8);
        maxPriorityQueue.insert(14);
        maxPriorityQueue.insert(13);
        maxPriorityQueue.printMaxPQ();
        System.out.println();
        System.out.println("current size of heap : " + maxPriorityQueue.heap.length);
    }
}

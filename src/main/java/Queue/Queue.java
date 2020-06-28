package Queue;

import java.util.List;
import java.util.NoSuchElementException;

public class Queue<T> {

    private ListNode<T> front;
    private ListNode<T> rear;
    private int length;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void enqueue(T data) {
        ListNode<T> queueMember = new ListNode<>(data);
        if (isEmpty()) {
            front = queueMember;
        } else {
            rear.next = queueMember;
        }
        rear = queueMember;
        length++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T removedMember = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;

        return removedMember;
    }

    public void print() {
        if (isEmpty()) return;
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<Integer>();
        integerQueue.enqueue(30);
        integerQueue.enqueue(50);
        integerQueue.enqueue(80);
        integerQueue.print();
        integerQueue.dequeue();
        System.out.println("After one dequeue operation: ");
        integerQueue.print();
    }
}

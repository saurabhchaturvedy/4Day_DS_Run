package DoublyLinkedList;

import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int length;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;
        private ListNode<T> previous;

        public ListNode(T data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;

    }

    private boolean isEmpty() {
        return length == 0;
    }

    private int length() {
        return length;
    }

    private void printDListForward() {
        if (head == null) return;
        ListNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("null");
    }

    private void printDListBackward() {
        if (head == null) return;
        ListNode<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.previous;
        }
        System.out.println("null");
    }

    private void insertAtBeginning(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    private void insertAtEnd(T data) {
        ListNode<T> newNode = new ListNode<T>(data);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public ListNode<T> deleteAtFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        ListNode<T> temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode<T> deleteAtEnd() {
        if (isEmpty())
            throw new NoSuchElementException();

        ListNode<T> temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
        doublyLinkedList.insertAtBeginning(20);
        doublyLinkedList.insertAtBeginning(30);
        doublyLinkedList.insertAtEnd(40);
        //doublyLinkedList.deleteAtFirst();
        doublyLinkedList.deleteAtEnd();
        doublyLinkedList.printDListForward();
        //doublyLinkedList.printDListBackward();

    }
}

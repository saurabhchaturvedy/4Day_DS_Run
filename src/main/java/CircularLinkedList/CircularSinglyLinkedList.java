package CircularLinkedList;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        this.last = null;
        this.length = 0;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private int length() {
        return length;
    }

    private void printCircularLinkedList() {
        if (last == null) return;

        ListNode<?> first = last.next;
        while (first != last) {
            System.out.print(first.data + " -> ");
            first = first.next;
        }
        System.out.println(first.data + "");

    }

    private void insertNodeAtBeginning(int data) {
        ListNode<Integer> newNode = new ListNode<>(data);
        if (last == null) {
            last = newNode;
        }
        ListNode<Integer> first = last.next;
        newNode.next = first;
        last.next = newNode;
        length++;
    }

    private void insertNodeAtEnd(int data) {
        ListNode<Integer> newNode = new ListNode<>(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;

        }
        length++;

    }

    private void removeFirstNode() {
        if (last == null) return;
        if (length == 1) {
            last = null;
        } else {
            ListNode first = last.next;
            last.next = first.next;
            first.next = null;
        }
        length--;
    }

    private void createCircularLinkedList() {
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> fourth = new ListNode<>(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public static void main(String[] args) {

        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.createCircularLinkedList();
        circularSinglyLinkedList.printCircularLinkedList();
        circularSinglyLinkedList.insertNodeAtBeginning(13);
        circularSinglyLinkedList.insertNodeAtEnd(8);
        circularSinglyLinkedList.removeFirstNode();
        circularSinglyLinkedList.printCircularLinkedList();


    }
}

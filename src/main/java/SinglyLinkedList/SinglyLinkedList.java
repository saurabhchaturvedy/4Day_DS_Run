import java.util.List;

public class SinglyLinkedList<T> {

    private ListNode<T> head;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public <T> void printList(ListNode<T> head) {
        ListNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("null");
    }

    private <T> int length(ListNode<T> head) {
        ListNode<T> current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    private void insertAtHead(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        newNode.next = head;
        head = newNode;
    }

    private void insertAtEnd(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    private boolean searchNode(T data) {
        if (head == null)
            return false;
        ListNode<T> current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    private <T> ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> current = head;
        ListNode<T> previous = null;
        ListNode<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private ListNode<T> findMiddleNode(ListNode<T> head) {
        ListNode<T> slowPtr = head;
        ListNode<T> fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    private <T> ListNode<T> findNthNodeFromEnd(ListNode<T> head, int N) {
        ListNode<T> mainPtr = head;
        ListNode<T> refPtr = head;
        int count = 0;

        while (count < N) {
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        return mainPtr;
    }

    private void removeDuplicateNodes(ListNode<T> head) {
        ListNode<T> current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    private <T> void removeNode(ListNode<T> head, T data) {
        ListNode<T> current = head;
        while (current != null && current.next!=null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    private boolean containsLoop(ListNode<T> node)
    {
        ListNode<T> fastPtr = head;
        ListNode<T> slowPtr = head;
        while(fastPtr!=null && fastPtr.next!=null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr==slowPtr) return true;
        }
        return false;
    }

    private <T extends Number> ListNode<Integer> insertInSortedList(ListNode<Integer> head, Integer data) {
        ListNode<Integer> current = head;
        ListNode<Integer> temp = null;

        ListNode<Integer> newNode = new ListNode<>(data);

        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.head = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> fourth = new ListNode<>(4);
        ListNode<Integer> fifth = new ListNode<>(8);

        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        //fifth.next = second; to simulate a loop

       // singlyLinkedList.printList(singlyLinkedList.head);
        singlyLinkedList.insertAtHead(0);
        singlyLinkedList.insertInSortedList(singlyLinkedList.head, 6);
       // singlyLinkedList.printList(singlyLinkedList.head);
        System.out.println("Length of the linked list is : " + singlyLinkedList.length(singlyLinkedList.head));
        singlyLinkedList.removeNode(singlyLinkedList.head, 4);
        //singlyLinkedList.printList(singlyLinkedList.head);
        System.out.println("Length of the linked list is : " + singlyLinkedList.length(singlyLinkedList.head));
        System.out.println("Does LinkedList contains a Loop ? "+singlyLinkedList.containsLoop(singlyLinkedList.head));
//        System.out.println("Is node present in the LinkedList " + singlyLinkedList.searchNode(3));
//        ListNode<Integer> reverse = singlyLinkedList.reverse(singlyLinkedList.head);
//        singlyLinkedList.printList(reverse);
//        singlyLinkedList.insertAtHead(6);
//        ListNode<Integer> middleNode = singlyLinkedList.findMiddleNode(reverse);
//        System.out.println("The middle node is " + middleNode.data);
//        System.out.println("4th node from the end is : " + singlyLinkedList.findNthNodeFromEnd(reverse, 4).data);
//        singlyLinkedList.removeDuplicateNodes(reverse);
//        singlyLinkedList.printList(reverse);
//        ListNode<Integer> reverse2 = singlyLinkedList.reverse(singlyLinkedList.head);
//        System.out.println("Now the reversed linked list is : " + reverse2);
    }
}

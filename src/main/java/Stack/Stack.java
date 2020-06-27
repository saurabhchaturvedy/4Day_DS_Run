package Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Stack<T> {

    private ListNode<T> top;
    private int length;

    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    public Stack() {

        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void push(T data) {
        ListNode<T> temp = new ListNode<>(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public T pop() {
        if (length == 0) throw new EmptyStackException();
        T element = top.data;
        top = top.next;
        length--;
        return element;
    }

    public void printStackElements() {
        if (length == 0) return;
        ListNode<T> temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.push(20);
        integerStack.push(30);
        integerStack.printStackElements();
        System.out.println("popped an element from stack " + integerStack.pop());
    }

}

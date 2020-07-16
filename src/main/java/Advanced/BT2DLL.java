package Advanced;

public class BT2DLL {

    Node node;

    Node head;

    static Node prev = null;

    public void BSTToDLL(Node node) {
        if (node == null) return;

        BSTToDLL(node.left);
        if (prev == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        BSTToDLL(node.right);
    }
}

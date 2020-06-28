package BinaryTree;

import java.util.Stack;

public class BinaryTree<T> {

    private TreeNode<T> root;

    private static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public void preOrder(TreeNode<T> root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIterative(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrderIterative(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<T> temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;

            }
        }
    }

    public void postOrder(TreeNode<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderIterative(TreeNode<T> root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> output = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode<Integer> temp = stack.pop();
            //output.push(temp.data);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }

            Stack<Integer> holderStack = new Stack<>();
            while (!output.isEmpty()) {
                holderStack.push(output.pop());
                // System.out.print(output.pop() + " ");
            }

            while (!holderStack.isEmpty()) {
                System.out.print(holderStack.pop() + " ");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.root = new TreeNode<Integer>(8);
        TreeNode<Integer> first = new TreeNode<>(6);
        TreeNode<Integer> second = new TreeNode<>(10);
        TreeNode<Integer> third = new TreeNode<>(3);
        TreeNode<Integer> fourth = new TreeNode<>(12);
        TreeNode<Integer> fifth = new TreeNode<>(9);
        TreeNode<Integer> sixth = new TreeNode<>(22);

        binaryTree.root.left = first;
        binaryTree.root.right = second;
        first.left = third;
        first.right = fourth;
        second.left = fifth;
        second.right = sixth;

        System.out.println("Printing Pre-Order Recursive Traversal : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.println("Printing Pre-Order Iterative Traversal : ");
        binaryTree.preOrderIterative(binaryTree.root);
        System.out.println();
        System.out.println("Printing In-Order Recursive Traversal : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.println("Printing In-Order Iterative Traversal : ");
        binaryTree.inOrderIterative(binaryTree.root);
        System.out.println();
        System.out.println("Printing Post-Order Recursive Traversal : ");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        System.out.println("Printing Post-Order Iterative Traversal : ");
        binaryTree.postOrderIterative(binaryTree.root);

    }
}

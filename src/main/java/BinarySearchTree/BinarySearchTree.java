package BinarySearchTree;

import java.util.Optional;

public class BinarySearchTree<T> {

    private TreeNode<T> root;

    private static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    private TreeNode<Integer> insert(TreeNode<Integer> root, Integer value) {
        if (root == null) {
            root = new TreeNode<Integer>(value);
            return root;
        }


        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    private TreeNode<Integer> search(TreeNode<Integer> root, Integer value) {
        if (root == null || root.data == value) {
            return root;
        }


        if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public void inOrder(TreeNode<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        TreeNode<Integer> insert = bst.insert(bst.root, 35);
        TreeNode<Integer> insert2 = bst.insert(insert, 40);
        TreeNode<Integer> insert3 = bst.insert(insert2, 25);
        bst.inOrder(insert3);
        System.out.println("Is the searched value found in BST ? : " + Optional.ofNullable(bst.search(insert3, 35)).isPresent());
    }
}

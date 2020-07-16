package Tree;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(28);
        tree.insert(13);
        tree.insert(22);
        tree.insert(17);

        tree.traverse();
        System.out.println("The minimum value is " + tree.min());
        System.out.println("value was found ? " + tree.get(28));
    }
}

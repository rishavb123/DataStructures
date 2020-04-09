public class Testing {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        // tree.add(7);

        System.out.println(tree.preorder());

        // tree.rotateRight();
        tree.rotateLeft();

        System.out.println(tree.preorder());

    }
}
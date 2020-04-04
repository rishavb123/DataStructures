public class Testing {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(2);
        tree.add(2);
        tree.add(4);
        for(int i = 0; i < 10; i++)
            tree.add((int) (Math.random() * 100));
        System.out.println(tree.size());
        System.out.println(tree.inorderList());
        tree.remove(tree.maxValue());
        tree.remove(tree.minValue());
        System.out.println(tree.size());
        System.out.println(tree.inorderList());


        /*
        // TRAVERSALS
        System.out.println(tree.preorder());
        System.out.println(tree.preorderList());
        System.out.println(tree.inorder());
        System.out.println(tree.inorderList());
        System.out.println(tree.postorder());
        System.out.println(tree.postorderList());
        System.out.println(tree.contains(2));
        */
    }
}
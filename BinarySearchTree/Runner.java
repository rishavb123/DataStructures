public class Runner {
    public static void main(String[] args) {
        BinarySearchTree<Character> tree = new BinarySearchTree<>();
        for(int i = 0; i < 26; i ++)
            tree.add((char)((int)(Math.random() * 26) + 97));
        int average = 0;
        for(Character c: tree.preorderList())
            average += c;
        average /= tree.size();
        
        System.out.println("Average ASCII Value: " + average);
        System.out.println("Average Character: " + (char)average);

        System.out.println(tree);

        BinarySearchTree<Character> preorderCopy = new BinarySearchTree<>();
        BinarySearchTree<Character> inorderCopy = new BinarySearchTree<>();
        BinarySearchTree<Character> postorderCopy = new BinarySearchTree<>();

        for(Character c: tree.preorderList()) preorderCopy.add(c);
        for(Character c: tree.inorderList()) inorderCopy.add(c);
        for(Character c: tree.postorderList()) postorderCopy.add(c);   
        
        System.out.println("PREORDER COPY: \n" + preorderCopy);
        System.out.println("INORDER COPY: \n" + inorderCopy);
        System.out.println("POSTORDER COPY: \n" + postorderCopy);
        
        tree.remove((char) ((int)(Math.random() * 26) + 97));

        System.out.println(tree);
    }
}
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {

    private int size;
    private Node<E> root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public BinarySearchTree(E obj) {
        this.root = new Node<>(obj);
    }

    public void add(E obj) {
        if(root == null) {
            root = new Node<>(obj);
            size = 1;
        }
        else if(root.insert(obj)) 
            size++;
    }

    public void remove(E obj) {
        root = remove(root, obj, true);
    }

    public Node<E> remove(Node<E> node, E obj, boolean removalFlag) {
        if(node == null) return null;
        int c = node.getValue().compareTo(obj);
        if(c > 0) 
            node.setLeft(remove(node.getLeft(), obj, removalFlag));
        else if(c < 0)
            node.setRight(remove(node.getRight(), obj, removalFlag));
        else {
            if(removalFlag)
                size--;
            switch(node.childCount()) {
                case 0:
                case 1:
                    return node.getFirstChild();
                case 2:
                    node.setValue(subtree(node.getRight()).minValue());
                    node.setRight(remove(node.getRight(), node.getValue(), false));
            }
        }
        return node;
    }

    public E minValue() {
        Node<E> node;
        for(node = root; node.getLeft() != null; node = node.getLeft());
        return node.getValue();
    }

    public E maxValue() {
        Node<E> node;
        for(node = root; node.getRight() != null; node = node.getRight());
        return node.getValue();
    }

    public boolean contains(E obj) {
        return root == null? false : root.contains(obj);
    }

    public BinarySearchTree<E> subtree(E obj) {
        return subtree(root.search(obj));
    }

    public BinarySearchTree<E> subtree(Node<E> node) {
        return new BinarySearchTree<>(node);
    }

    public List<E> preorderList() {
        ArrayList<E> list = new ArrayList<>();
        preorderList(root, list);
        return list;
    }

    public void preorderList(Node<E> node, List<E> list) {
        if(node != null) {
            list.add(node.getValue());
            preorderList(node.getLeft(), list);
            preorderList(node.getRight(), list);
        }
    }

    public List<E> inorderList() {
        ArrayList<E> list = new ArrayList<>();
        inorderList(root, list);
        return list;
    }

    public void inorderList(Node<E> node, List<E> list) {
        if(node != null) {
            inorderList(node.getLeft(), list);
            list.add(node.getValue());
            inorderList(node.getRight(), list);
        }
    }

    public List<E> postorderList() {
        ArrayList<E> list = new ArrayList<>();
        postorderList(root, list);
        return list;
    }

    public void postorderList(Node<E> node, List<E> list) {
        if(node != null) {
            postorderList(node.getLeft(), list);
            postorderList(node.getRight(), list);
            list.add(node.getValue());
        }
    }

    public String preorder() {
        return preorder(root);
    }

    public String preorder(Node<E> node) {
        if(node != null) {
            String s = "";
            s += node.toString();
            String temp = preorder(node.getLeft());
            if(temp.length() != 0)
                s += "\t" + temp;
            temp = preorder(node.getRight());
            if(temp.length() != 0)
                s +=  "\t" + temp;
            return s;
        } else {
            return "";
        }
    }

    public String inorder() {
        return inorder(root);
    }

    public String inorder(Node<E> node) {
        if(node != null) {
            String s = "";
            String temp = inorder(node.getLeft());
            if(temp.length() != 0) {
                s += temp;
                s += "\t" + node.toString();
            } else {
                s += node.toString();
            }
            temp = inorder(node.getRight());
            if(temp.length() != 0)
                s +=  "\t" + temp;
            return s;
        } else {
            return "";
        }
    }

    public String postorder() {
        return postorder(root);
    }

    public String postorder(Node<E> node) {
        if(node != null) {
            String s = "";
            String temp = postorder(node.getLeft());
            if(temp.length() != 0)
                s += temp;
            temp = postorder(node.getRight());
            if(temp.length() != 0)
                s +=  (s.length() == 0? "" : "\t") + temp;
            if(s.length() == 0) 
                s += node.toString();
            else
                s += "\t" + node.toString();
            return s;
        } else {
            return "";
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        return preorder() + "\n" + inorder() + "\n" + postorder() + "\n";
    }

    public static class Node<E extends Comparable<E>> {
        
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
        }

        public boolean insert(E obj) {
            int c = obj.compareTo(value);
            if(c > 0) {
                if(right == null) {
                    right = new Node<>(obj);
                    return true;
                }
                else 
                    return right.insert(obj);
            } else if(c < 0) {
                if(left == null)  {
                    left = new Node<>(obj);
                    return true;
                }
                else 
                    return left.insert(obj);
            }
            return false;
        }

        public boolean contains(E obj) {
            return search(obj) != null;
        }

        public Node<E> search(E obj) {
            int c = obj.compareTo(value);
            if(c > 0)
                return right == null? null : right.search(obj);
            else if(c < 0)
                return left == null? null : left.search(obj);
            return this;
        }

        public void remove(Node<E> node) {
            replace(node, null);
        }

        public void replace(Node<E> node, Node<E> node2) {
            if(left == node) left = node2;
            if(right == node) right = node2;
        }

        public Node<E> getFirstChild() {
            return left == null? right: left;
        }

        public int childCount() {
            int i = 0;
            if(left != null) i += 1;
            if(right != null) i += 1;
            return i;
        }

        public E getValue() {
            return value;
        }
        
        public Node<E> getLeft() {
            return left;
        }
        
        public Node<E> getRight() {
            return right;
        }
        
        public void setValue(E value) {
            this.value = value;
        }
        
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        
        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }

}
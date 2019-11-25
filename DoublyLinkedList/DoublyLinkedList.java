import java.util.Iterator;

public class DoublyLinkedList<E extends Comparable<E>> implements Iterable<E> {

    private ListNode root;
    private ListNode end;
    private int size;

    private int currentIndex;

    public DoublyLinkedList() {

    }

    public DoublyLinkedList(E root) {
        this.root = new ListNode(root);
        this.end = this.root;
        size = 1;
    }

    public void add(E a) {
        ListNode newNode = new ListNode(a);
        if(root == null) {
            root = newNode;
            end = newNode;
        } else {
            end.setNext(newNode);
            newNode.setPrevious(end);
            end = newNode;
        }
        size++;
    }

    public void add(int index, E a) throws IndexOutOfBoundsException {
        if(index > size || index < 0) throw new IndexOutOfBoundsException("Index " + index + " is not in DoublyLinkedList of size " + size);
        if(index == 0) {
            ListNode node = new ListNode(a);
            if(root == null) {
                root = node;
                end = node;
            } else {
                root.setPrevious(node);
                node.setNext(root);
                root = node;
            }
        }
        else if(index == size) {
            add(a); return;
        } else {
            ListNode node = root;
            for(int i = 0; i < index - 1; i++)
                node = node.getNext();
            ListNode next = node.getNext();
            ListNode newNode = new ListNode(a);
            newNode.setPrevious(node);
            newNode.setNext(next);
            node.setNext(newNode);
            next.setPrevious(newNode);
        }
        size++;
    }

    public E remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Index " + index + " is not in DoublyLinkedList of size " + size);
        if(index == 0) {
            E obj = root.getValue();
            root = root.getNext();
            if(root != null)
                root.setPrevious(null);
            size--;
            return obj;
        }
        if(index == size - 1) {
            E obj = end.getValue();
            end = end.getPrevious();
            end.setNext(null);
            size--;
            return obj;
        }
        ListNode node = root;
        for(int i = 0; i < index - 1; i++)
            node = node.getNext();
        ListNode prev = node;
        node = node.getNext();
        ListNode next = node.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        size--;
        return node.getValue();
    }

    public E remove(E obj) {
        int i = 0;
        for(ListNode node = root; node != null; node = node.getNext()) {
            if(node.getValue().equals(obj))
                return remove(i);
            i++;
        }
        return null;
    }

    public DoublyLinkedList<E> reverse() { 
        for(ListNode node = root; node != null; node = node.getPrevious()) {
            ListNode temp = node.getPrevious();
            node.setPrevious(node.getNext());
            node.setNext(temp);
        }
        ListNode temp = root;
        root = end;
        end = temp;
        return this;
    }

    public E getNext() {
        return remove(0);
    }

    public E pop() {
        return remove(size - 1);
    }

    public E poll() {
        return remove(0);
    }

    public DoublyLinkedList<E> copy() {
        DoublyLinkedList<E> copie = new DoublyLinkedList<>();
        return copie.addAll(this);
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            ListNode current = root;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                E obj = current.getValue();
                current = current.getNext();
                return obj;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Index " + index + " is not in DoublyLinkedList of size " + size);
        ListNode node = root;
        for(int i = 0; i < index; i++) 
            node = node.getNext();
        return node.getValue();
    }

    public void set(int index, E a) throws IndexOutOfBoundsException{
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Index " + index + " is not in DoublyLinkedList of size " + size);
        ListNode node = root;
        for(int i = 0; i < index; i++) 
            node = node.getNext();
        node.setValue(a);
    }

    

    public DoublyLinkedList<E> addAll(DoublyLinkedList<E> other) {
        for(E a: other)
            add(a);
        return this;
    }

    public DoublyLinkedList<E> splice(int start) {
        return splice(start, size);
    }

    public void switchValues(int i, int j) {
        E temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    public DoublyLinkedList<E> splice(int start, int finish) {
        if(start >= finish)
            clear();
        else {
            if(start < 0)
                start = 0;
            if(finish > size)
                finish = size;
            ListNode node = root;
            for(int i = 0; i < start; i++) 
                node = node.getNext();
            root = node;
            if(root != null)
                root.setPrevious(null);
            for(int i = start; i < finish - 1; i++)
                node = node.getNext();
            end = node;
            if(end != null)
                end.setNext(null);
        }
        return this;
    }

    public int indexOf(E obj) {
        int i = 0;
        for(ListNode node = root; node != null; node = node.getNext()) {
            if(obj.equals(node.getValue()))
                return i;
            i++;
        }
        return -1;
    }

    public boolean contains(E obj) {
        for(ListNode node = root; node != null; node = node.getNext())
            if(obj.equals(node.getValue()))
                return true;
        return false;
    } 

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        end = null;
        size = 0;
    }

    public DoublyLinkedList<E> filter(ListFilter<E> checker) {
        for(E a: this)
            if(!checker.filter(a))
                remove(a);
        return this;
    }

    public void forEachValue(Func<E> func) {
        for(E a: this) func.func(a);
    }

    public <T extends Comparable<T>> DoublyLinkedList<T> map(Mapping<E, T> mapping) {
        DoublyLinkedList<T> mappedList = new DoublyLinkedList<>();
        for(E a: this) mappedList.add(mapping.mapping(a));
        return mappedList;
    }

    public int size() {
        return size;
    }

    public ListNode getRoot() {
        return root;
    }

    public ListNode getEnd() {
        return end;
    }

    public E getFront() {
        return root == null? null : root.getValue();
    }

    public E getBack() {
        return end == null? null : end.getValue();
    }

    public String toString() {
        String s = "[";
        for(ListNode node=root; node != null; node = node.getNext())
            s += node.getValue() + ", ";
        return (s.length() > 1? s.substring(0, s.length() - 2): s) + "]";
    }

    public String toReversedString() {
        String s = "[";
        for(ListNode node=end; node != null; node = node.getPrevious())
            s += node.getValue() + ", ";
        return (s.length() > 1? s.substring(0, s.length() - 2): s) + "]";
    }

    public class ListNode {
        
        private E value;
        private ListNode next;
        private ListNode previous;

        public ListNode(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public ListNode getPrevious() {
            return previous;
        }
        
        public void setPrevious(ListNode previous) {
            this.previous = previous;
        }

        public boolean hasPrevious() {
            return previous != null;
        }
        
        public ListNode getNext() {
            return next;
        }
        
        public void setNext(ListNode next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

    }

    @SafeVarargs
    public static <T extends Comparable<T>> DoublyLinkedList<T> fromArray(T... arr) {
        DoublyLinkedList<T> list = new DoublyLinkedList<T>();
        for(T a: arr)
            list.add(a);
        return list;
    }

    public static <T extends Comparable<T>> DoublyLinkedList<T> fromIterable(Iterable<T> arr) {
        DoublyLinkedList<T> list = new DoublyLinkedList<T>();
        for(T a: arr)
            list.add(a);
        return list;
    }

    public static interface ListFilter<E> {
        public boolean filter(E obj);
    }

    public static interface Func<E> {
        public void func(E obj);
    }

    public static interface Mapping<E, T> {
        public T mapping(E obj);
    }

}
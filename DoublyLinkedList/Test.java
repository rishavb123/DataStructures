public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = DoublyLinkedList.fromArray("z", "xs", "a", "bjkldsfj");
        DoublyLinkedList<String> list2 = DoublyLinkedList.fromArray("hi", "bob", "hello", "world");
        DoublyLinkedList<Integer> list3 = DoublyLinkedList.fromArray(-4, -3, -1, -2);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println();

        System.out.println(MyCollections.sort(list, list2, list3));
        System.out.println(list2);
        System.out.println(list3);
    }
}
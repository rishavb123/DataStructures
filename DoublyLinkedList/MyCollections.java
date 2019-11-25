public class MyCollections {
    public static <E extends Comparable<E>> DoublyLinkedList<E> sort(DoublyLinkedList<E> list) {
        for (int i = 1; i < list.size(); i++) {
            E ith = list.get(i);
            int j = i;
            while((j > 0) && (list.get(j - 1).compareTo(ith) > 0)) {
                list.switchValues(j, j - 1);
                j--;
            }
        }
        return list;
    }
    
    @SafeVarargs
    public static <E extends Comparable<E>> DoublyLinkedList<E> sort(DoublyLinkedList<E> list, DoublyLinkedList... lists) {
        for (int i = 1; i < list.size(); i++) {
            E ith = list.get(i);
            int j = i;
            while((j > 0) && (list.get(j - 1).compareTo(ith) > 0)) {
                list.switchValues(j, j - 1);
                for(int k = 0; k < lists.length; k++) lists[k].switchValues(j, j - 1);
                j--;
            }
        }
        return list;
    }
}
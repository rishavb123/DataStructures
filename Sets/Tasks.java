import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        System.out.println("List of Sets");
        one();
        printLine();
        System.out.println("Intersection of {1,2,3,4}, {3,4,5,6}, {4,1,2}");
        System.out.println(intersection(fromArr(1,2,3,4), fromArr(3, 4, 5, 6), fromArr(4, 1, 2)));
        printLine();
        System.out.println("Union of {1,2,3,4}, {3,4,5,6}, {4,1,2}");
        System.out.println(union(fromArr(1,2,3,4), fromArr(3, 4, 5, 6), fromArr(4, 1, 2)));
        printLine();
        System.out.println("Even Intersection of {1,2,3,4}, {3,4,5,6}");
        System.out.println(evenIntersection(fromArr(1,2,3,4), fromArr(3, 4, 5, 6)));
        printLine();
        System.out.println("Even Union of {1,2,3,4}, {3,4,5,6}");
        System.out.println(evenUnion(fromArr(1,2,3,4), fromArr(3, 4, 5, 6)));

    }

    public static void printLine() {
        System.out.println("---------------------------------------------------------------------------------");
    }

    @SafeVarargs
    public static <E> Set<E> fromArr(E... objs) {
        HashSet<E> set = new HashSet<>();
        // TreeSet<E> set = new TreeSet<>();
        for(E obj: objs) set.add(obj);
        return set;
    }

    public static void one() {
        ArrayList<HashSet> list = new ArrayList<>();
        int lim = (int)(Math.random() * 10) + 2;
        for(int i = 0; i < lim; i++) {
            HashSet<Integer> set = new HashSet<>();
            while(set.size() < 20) set.add((int)(Math.random() * 60) + 1);
            list.add(set);
        }

        System.out.println(list.size());
        for(HashSet set: list)
            System.out.print(set.size() + " ");
        System.out.println();

    }

    @SafeVarargs
    public static <E> Set<E> intersection(Set<E>... sets) {
        HashSet<E> set = new HashSet<>();
        // TreeSet<E> set = new TreeSet<>();
        if(sets.length == 0) return set;
        for(E obj: sets[0]) {
            boolean add = true;
            for(int i = 1; i < sets.length; i++)
                if(!sets[i].contains(obj)) add = false;
            if(add)
                set.add(obj);
        }

        return set;
    }

    @SafeVarargs
    public static <E> Set<E> union(Set<E>... sets) {
        HashSet<E> set = new HashSet<>();
        // TreeSet<E> set = new TreeSet<>();
        if(sets.length == 0) return set;
        for(Set<E> s: sets) set.addAll(s);
        return set;
    }

    public static interface Filterer<E> {
        public boolean keep(E obj);
    }

    public static <E> Set<E> filter(Filterer<E> filterer, Set<E> set) {
        Set<E> s = new HashSet<>();
        // TreeSet<E> s = new TreeSet<>();
        for(E e: set)
            if(filterer.keep(e)) s.add(e);
        return s;
    }

    @SafeVarargs
    public static Set<Integer> evenIntersection(Set<Integer>... sets) {
        return filter(i -> i % 2 == 0, intersection(sets));
    }

    @SafeVarargs
    public static Set<Integer> evenUnion(Set<Integer>... sets) {
        return filter(i -> i % 2 == 0, union(sets));
    }
    
}
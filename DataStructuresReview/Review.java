import java.util.*;

public class Review {

    public static void main(String[] args) {
        System.out.println("--------------------------------LIST Stuff--------------------------------");
        List<Integer> list = new ArrayList<>();
        int size = (int) (Math.random() * 101) + 50;

        for(int i = 0; i < size; i++) list.add((int)(Math.random() * 100) + 1);

        System.out.println(list);

        System.out.println("\n--------------------------------ARRAY Stuff--------------------------------");
        int dim = (int) Math.ceil(Math.sqrt(size));
        int[][] arr = new int[dim][dim];

        while(!list.isEmpty()) {
            int x = (int) (Math.random() * dim);
            int y = (int) (Math.random() * dim);
            while(arr[x][y] != 0) {
                x = (int) (Math.random() * dim);
                y = (int) (Math.random() * dim);
            }
            arr[x][y] = list.remove(0);
        }

        for(int[] ar: arr) {
            for(int a: ar)
                System.out.print(a + "\t");
            System.out.println();
        }        

        System.out.println("\n--------------------------------STACK Stuff--------------------------------");
        Stack<Integer> stack = new Stack<>();

        for(int j = 0; j < dim; j++)
            for(int i = 0; i < dim; i++) 
                stack.add(arr[i][j]);

        System.out.println(stack);

        System.out.println("\n--------------------------------SET Stuff--------------------------------");
        Set<Integer> set = new HashSet<>();
        for(;!stack.empty();set.add(stack.pop()));
        System.out.println(set);

        System.out.println("\n--------------------------------QUEUE Stuff--------------------------------");
        Queue<Integer> queue = new PriorityQueue<>();
        for(int a: set) {
            queue.add(a);
        }
        set.clear();
        System.out.println(queue);


        System.out.println("\n--------------------------------MAP Stuff--------------------------------");
        Map<Integer, TreeSet<Integer>> map = new TreeMap<>();

        int lastEven = -1;
        for(int a: queue)
            if(a % 2 == 0) {
                lastEven = a;
                map.putIfAbsent(lastEven, new TreeSet<>());
            }
            else if(lastEven != -1)
                map.get(lastEven).add(a);

        for(int key: map.keySet()) {
            String s = map.get(key).toString();
            System.out.println(key + ": {" + s.substring(1, s.length() - 1) + "}");
        }
    }

}
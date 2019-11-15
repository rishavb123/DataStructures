import java.io.IOException;
import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        int x = (int)(Math.random() * 10);
        System.out.print(x + " -> ");
        printBinary(x);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println(reverse("abcdefghijklmnopqrstuvwxyz"));
        System.out.println("----------------------------------------------------------------------------------------------- ");
        String[] arr = {"E", "H", "P", "S"};
        printBooks("100BestSciFi21stCentury.txt", b -> inArr(b.getFirst().charAt(0) + "", arr) || inArr(b.getLast().charAt(0) + "", arr));
    }

    public static boolean inArr(String s, String[] arr) {
        for(String a: arr) 
            if(s.equals(a)) return true;
        return false;
    }
    public static void printBooks(String filename, Checker filter) {
        try {
            Stack<Book> stack = Book.fromFile(filename);
            while(!stack.empty()) {
                Book book = stack.pop();
                if(filter.check(book))
                    System.out.println(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String reverse(String s) {
        Stack<Character> letters = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            letters.push(s.charAt(i));
        }
        String r = "";
        while(!letters.empty()) {
            r += letters.pop();
        }
        return r;
    }

    public static void printBinary(int x) {
        if(x==0) System.out.print("0");
        Stack<Integer> digits = new Stack<>();
        while(x > 0) {
            digits.push(x%2);
            x /= 2;
        }
        while(!digits.empty()) {
            System.out.print(digits.pop());
        }
        System.out.println();
    }

}
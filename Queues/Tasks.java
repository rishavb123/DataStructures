import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        taskOne();
        printLine();
        taskTwo2();
        printLine();
        taskTwo3();
    }

    public static void taskOne() {
        try {
            Queue<Word> queue = new LinkedList<>();
            PriorityQueue<Word> pq = new PriorityQueue<>();
            PriorityQueue<Word> rpq = new PriorityQueue<>();

            File file = new File("./paragraph.txt");
            String[] words = Files.readAllLines(file.toPath()).get(0).replace(".", "").replace(",", "").split(" ");
            for(String word: words) {
                Word w = new Word(word);
                Word w2 = new Word2(word);
                queue.add(w);
                pq.add(w);
                rpq.add(w2);

            }
            System.out.printf("%-20s %-20s %s\n", "Original", "Sorted", "Reversed");

            while(!queue.isEmpty()) {
                System.out.printf("%-20s %-20s %s\n", queue.poll(), pq.poll(), rpq.poll());
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void taskTwo2() {
        try {
            Queue<Passenger> queue = new LinkedList<>();

            File file = new File("./PassengerInfo.txt");
            List<String> lines = Files.readAllLines(file.toPath());
            for(int i = 0; i + 2 < lines.size(); i += 3) {
                queue.add(new Passenger(lines.get(i), lines.get(i + 2), lines.get(i + 1)));
            }
            while(!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void taskTwo3() {
        try {
            PriorityQueue<Passenger> queue = new PriorityQueue<>();

            File file = new File("./PassengerInfo.txt");
            List<String> lines = Files.readAllLines(file.toPath());
            for(int i = 0; i + 2 < lines.size(); i += 3) {
                queue.add(new Passenger(lines.get(i), lines.get(i + 2), lines.get(i + 1)));
            }
            while(!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void printLine() {
        System.out.println("\n---------------------------------------------------------------------\n");
    }

}
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(new File("./letters.txt").toPath());
            // HashMap<Character, Integer> map = new HashMap<>();
            TreeMap<Character, Integer> map = new TreeMap<>();
            for(String str: list) {
                for(int i = 0; i < str.length(); i++) {
                    Character chr = str.charAt(i);
                    if(!map.containsKey(chr))
                        map.put(chr, 1);
                    else
                        map.put(chr, map.get(chr) + 1);
                }
            }
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
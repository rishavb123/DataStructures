import java.nio.file.*;
import java.io.*;
import java.util.*;

public class FedCensus {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(new File("./letters.txt").toPath());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
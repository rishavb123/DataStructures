import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Book {

    private String first;
    private String last;
    private String title;
    private double rating;
    private int numRatings;
    private int votes;
    private int score;

    public Book(String author, String title, double rating, int numRatings, int votes, int score) {
        this.first = author.split(" ")[0];
        this.last = author.split(" ")[1];
        this.title = title;
        this.rating = rating;
        this.numRatings = numRatings;
        this.votes = votes;
        this.score = score;
    }

    public String toString() {
        return last + ", " + first + "-" + title + "; " + rating;
    }

    public static Stack<Book> fromFile(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> list = Files.readAllLines(file.toPath());
        Stack<Book> books = new Stack<>();
        for(int i = 0; i < list.size(); i += 7) {
            String author = list.get(i + 3).substring(3);
            String title = list.get(i + 2).substring(1);
            double rating = Double.parseDouble(list.get(i + 4).split(" ")[0]);
            int numRatings = Integer.parseInt(list.get(i + 4).split(" ")[4].replace(",", ""));
            int votes = Integer.parseInt(list.get(i + 5).split(" ")[3].replace(",", ""));
            int score = Integer.parseInt(list.get(i + 5).split(" ")[1].replace(",", ""));
            books.push(new Book(author, title, rating, numRatings, votes, score));
        }
        return books;
    }


    /**
     * @return String return the first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @return String return the last
     */
    public String getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return double return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return int return the numRatings
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     * @param numRatings the numRatings to set
     */
    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    /**
     * @return int return the votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    /**
     * @return int return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

}
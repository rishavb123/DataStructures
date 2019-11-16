public class Word2 extends Word {

    public Word2(String word) {
        super(word);
    }

    @Override
    public int compareTo(Word obj) {
        return -toString().toLowerCase().compareTo(obj.toString().toLowerCase());
    }

}
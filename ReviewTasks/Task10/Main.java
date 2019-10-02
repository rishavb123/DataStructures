import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob10Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

            String text;

            ArrayList<String[]> list = new ArrayList<>();

			while( (text=input.readLine())!= null)
			{
                list.add(text.split(","));
            }

            ArrayList<Chord> chords = new ArrayList<>();

            for(int j = 0; j < list.get(0).length; j++) {
                String[] arr = new String[5];
                for(int i = 0; i < 5; i++)
                    arr[i] = list.get(i)[j];
                chords.add(new Chord(arr));
            }

            String[] lines = new String[30];

            lines[0] = String.format("%-10s", "Measure");

            for(int i = 0; i < 29; i++)
                lines[i + 1] = String.format("%-10s", Chord.displayNote(Chord.getNoteFromIndexOfLines(i)));

            for(int i = 0; i < chords.size(); i++) {
                Chord c = chords.get(i);    
                lines[0] += String.format("%-10s", (i + 1));
                ArrayList<Integer> list2 = new ArrayList<>();
                for(int j = 0; j < c.getStringNotes().size(); j++) {
                    list2.add(Chord.getLineIndexFromNote(c.getStringNotes().get(j)));
                }
                for(int k = 0; k < 29; k ++)
                    lines[k + 1] += String.format("%-10s", ((list2.contains(k))? "O": ""));

            }

            for(String line: lines)
                System.out.println(line);
            
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}

class Chord {

    String[] arr;
    public static final String[][] positions = {
        {"0E", "0F", "0F#", "0G", "0G#"},
        {"0A", "0A#", "0B", "0C", "0C#"},
        {"0D", "0D#", "1E", "1F", "1F#"},
        {"1G", "1G#", "1A",  "1A#", "1B"},
        {"1B", "1C", "1C#", "1D", "1D#"},
        {"2E", "2F", "2F#", "2G", "2G#"}
    };

    public static final String[] notes = {
        "0E", "0F", "0F#", "0G", "0G#",
        "0A", "0A#", "0B", "0C", "0C#",
        "0D", "0D#", "1E", "1F", "1F#",
        "1G", "1G#", "1A",  "1A#", 
        "1B", "1C", "1C#", "1D", "1D#",
        "2E", "2F", "2F#", "2G", "2G#"
    };
    
    public static String getNoteFromIndexOfLines(int i) {
        return Chord.notes[28 - i];
    }

    public static int getLineIndexFromNote(String note) {
        int i = 0;
        for(int j = 0; j < notes.length; j++)
            if(note.equals(notes[j])) {
                i = j;
                break;   
            }
        i = 28 - i;
        return i;
    }

    public static String displayNote(String note) {
        return note.substring(1);
    }

    public Chord(String[] arr) {
        this.arr = arr;
    }

    public ArrayList<int[]> getNotes() {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < 6; i++)
            list.add(getNoteForColumn(i));
        list.removeIf(l -> l == null);
        return list;
    } 

    public ArrayList<String> getStringNotes() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<int[]> notes = getNotes();
        for(int[] i: notes)
            list.add(positions[i[0]][i[1]]);
        for(int i = 0; i < list.size() - 1; i++)
            if(list.get(i).equals(list.get(i + 1))) {
                list.remove(list.get(i));
                i--;
            }
        return list;
    }

    public int[] getNoteForColumn(int i) {
        int j;
        if(arr[0].charAt(i) == 'o')
            return getNote(i, 0);
        if(arr[0].charAt(i) == 'x' || (j = getColumn(i).indexOf('*')) == -1)
            return null;
        return getNote(i, j);
    }

    public String getColumn(int i) {
        String str = "";
        for(int j = 0; j < 5; j++)
            str += arr[j].charAt(i);
        return str;
    }

    public static int[] getNote(int i, int j) {
        return new int[]{i, j};
    }

}

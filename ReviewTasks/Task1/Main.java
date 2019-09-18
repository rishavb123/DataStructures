import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        File file = new File("../Input Files/Prob1Input.txt");
        
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

            String text;
            
			while((text=input.readLine())!= null)
			{
                ArrayList<Integer> list1 = toIntList(text);
                ArrayList<Integer> list2 = toIntList(input.readLine());
                ArrayList<Integer> list3 = toIntList(input.readLine());

                System.out.println("Set 1: " + list1.toString().replace("[", "{").replace("]", "}"));
                System.out.println("Set 2: " + list2.toString().replace("[", "{").replace("]", "}"));
                System.out.println("Set 3: " + list3.toString().replace("[", "{").replace("]", "}"));

                list1.removeIf(l -> !list2.contains(l) || !list3.contains(l));
                Collections.sort(list1);
                System.out.println("\t Intersection of sets: " + list1.toString().replace("[", "{").replace("]", "}") + "\n");

            }
            input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
        }

    }

    public static ArrayList<Integer> toIntList(String text) {
        if(text == null)
            return new ArrayList<>();
        String[] strArr = text.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < strArr.length; i++)
            list.add(Integer.parseInt(strArr[i]));
        return list;
    }
}
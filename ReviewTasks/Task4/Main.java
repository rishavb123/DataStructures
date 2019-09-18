import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob4Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

			
			String text;
			while( (text=input.readLine())!= null)
			{
				ArrayList<Character> charList = createCharList();
				String code = text;
				String guess = input.readLine();
				if(guess == null)
					break;
				int num = 0;
				int num2 = 0;
				for(int i = 0; i < code.length(); i++)
					if(code.charAt(i) == guess.charAt(i)) {
						num++;
						charList.remove(charList.indexOf(code.charAt(i)));
					}
				for(int i = 0; i < charList.size(); i++)
					if(code.indexOf(charList.get(i)) != -1 && guess.indexOf(charList.get(i)) != -1)
						num2++;

				System.out.println("Code: " + code);
				System.out.println("Guess: " + guess);
				System.out.println("Color Correct - Correctly Placed: " + num);
				System.out.println("Color Correct - Incorrectly Placed: " + num2 + "\n");
				
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public static ArrayList<Character> createCharList() {
		ArrayList<Character> list = new ArrayList<>();
		list.add('R');
		list.add('O');
		list.add('Y');
		list.add('G');
		list.add('B');
		list.add('I');
		list.add('V');
		return list;
	}
}

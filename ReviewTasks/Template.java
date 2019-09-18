import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/ProbIInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

			String text;
			while( (text=input.readLine())!= null)
			{
				
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}

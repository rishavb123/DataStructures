import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob7Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

			String text;
			while( (text=input.readLine())!= null)
			{
                double dollars = toBooth(text);
                double cr1 = toBooth(input.readLine());
                double fee1 = toBooth(input.readLine());
                double cr2 = toBooth(input.readLine());
                double fee2 = toBooth(input.readLine());

                double booth1 = (dollars - dollars * fee1 / 100.0) * cr1;
                double booth2 = (dollars - dollars * fee2 / 100.0) * cr2;

                System.out.println("Booth 1: " + formatDouble(booth1) + " euros");
                System.out.println("Booth 2: " + formatDouble(booth2) + " euros");
                System.out.println("Booth " + (booth1 > booth2? "1" : "2") + " is the best; difference is " + formatDouble(Math.abs(booth1 - booth2)) + " euros");
                System.out.println();
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }
    
    public static double toBooth(String text) {
        if(text == null)
            return 0;
        return Double.parseDouble(text.split(":")[1].substring(1));
    }

    public static String formatDouble(double d) {
        d = Math.round(d * 100) / 100.0;
        String s = Double.toString(d);
        if(s.split("\\.")[1].length() < 2)
            s += "0";
        return s;
    }
}

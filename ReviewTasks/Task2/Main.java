import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.math.BigInteger;
import java.lang.*;
import java.math.*;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob2Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(file));

            String text;
			while( (text=input.readLine())!= null)
			{
				System.out.println(lucasNumber(new BigInteger(text)));
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }
    
    public static BigInteger lucasNumber(BigInteger index) {
        BigInteger i = BigInteger.TWO;
        BigInteger j = BigInteger.ONE;

        for(BigInteger i_ = BigInteger.ONE; i_.compareTo(index) == -1; i_ = i_.add(BigInteger.ONE)) {
            BigInteger k = i.add(j);
            i = j; j = k;
        }
        return j;
    }
}

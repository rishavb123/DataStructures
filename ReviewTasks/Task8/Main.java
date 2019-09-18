import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Main
{

	public static void main(String args[])
	{
        File file = new File("../Input Files/Prob8Input.txt");
        
        Date curDate = new Date();
        // curDate = new Date(118, 8, 18, 12, 26);
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

            String text;
            int i = 0;
			while( (text=input.readLine())!= null)
			{
                i++;
                long[] arr = toLongArr(text);
                long ms = arr[0] * 86400000L + arr[1] * 3600000L + arr[2] * 60000L;

                System.out.println("Trip " + i);
                System.out.println("\tDeparture Date and Time: " + dateToString(curDate));
                System.out.println("\tArrival Date and Time: " + dateToString(new Date(curDate.getTime() + ms)));
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }
    
    public static long[] toLongArr(String text) {
        String[] strArr = text.split(" ");
        long[] arr = new long[strArr.length];
        for(int i = 0; i < strArr.length; i++)
            arr[i] = Long.parseLong(strArr[i]);
        return arr;
    } 

    public static String dateToString(Date date) {
        return ((date.getHours() - 1) % 12 + 1) + ":" + (date.getMinutes() < 10? "0": "") + date.getMinutes() + (date.getHours() >= 12? " PM" : " AM") + " on " + (1 + date.getMonth()) + "/" + date.getDate() + "/" + (1900 + date.getYear());
    }

}

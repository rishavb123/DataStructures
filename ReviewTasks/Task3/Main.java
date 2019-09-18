import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.ArrayList;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob3Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(file));

			String text;
			while( (text=input.readLine())!= null)
			{
                int[] nums = getTwoNums(text);

                ArrayList<Integer> factors1 = findFactors(nums[0]);
                ArrayList<Integer> factors2 = findFactors(nums[1]);

                int sum1 = sum(factors1);
                int sum2 = sum(factors2);
                
                System.out.println("The numbers " + nums[0] + " and " + nums[1] + " are " + ((sum1 == nums[1] && sum2 == nums[0])? "amicable.": "not amicable."));
                String s1 = factors1.toString().substring(1, factors1.toString().length() - 1);
                String s2 = factors2.toString().substring(1, factors2.toString().length() - 1);
                System.out.println("\t Factors of " + nums[0] + " are " + s1.substring(0, s1.lastIndexOf(",")) + " and " + s1.substring(s1.lastIndexOf(",")+2) + ". Sum is " + sum1 + ".");
                System.out.println("\t Factors of " + nums[1] + " are " + s2.substring(0, s2.lastIndexOf(",")) + " and " + s2.substring(s2.lastIndexOf(",")+2) + ". Sum is " + sum2 + ".");
            }
            input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }

    public static int[] getTwoNums(String text) {
        String[] strArr = text.split(" ");
        return new int[] { Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]) };
    }

    public static ArrayList<Integer> findFactors(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < num / 2 + 1; i++) {
            if(num % i == 0)
                list.add(i);
        }
        return list;
    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for(Integer i: list)
            sum += i;
        return sum;
    }

}

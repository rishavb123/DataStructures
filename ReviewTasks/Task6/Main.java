import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob6Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

			String text;
			while( (text=input.readLine())!= null)
			{
                Dice dice = new Dice();
                for(int i = 0; i < text.length(); i++)
                    dice.tip(text.charAt(i));
                System.out.println(dice.getTop());
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}


class Dice {

    public Value[] horizontal;
    public Value[] vertical;

    public Dice() {
        vertical = new Value[] {new Value(1), new Value(5), new Value(6), new Value(2)};
        horizontal = new Value[] {vertical[0], new Value(4), vertical[2], new Value(3)};
    }

    public void tip(char direction) {
        switch(direction) {
            case 'N': 
                shift(vertical, -1);
                break;
            case 'S':
                shift(vertical, 1);
                break;
            case 'W': 
                shift(horizontal, -1);
                break;
            case 'E':
                shift(horizontal, 1);
                break;
        }
    }

    public int getTop() {
        return vertical[0].val;
    }

    public static void shift(Value[] arr, int direction) {
        if(direction == -1) {
            int temp = arr[0].val;
            for(int i = 0; i < arr.length - 1; i++) {
                arr[i].val = arr[i + 1].val;
            }
            arr[arr.length - 1].val = temp;
        }
        else {
            int temp = arr[arr.length - 1].val;
            for(int i = arr.length - 1; i > 0; i--) {
                arr[i].val = arr[i - 1].val;
            }
            arr[0].val = temp;
        }
    }

}

class Value {

    int val;

    public Value(int val) {
        this.val = val;
    }

}
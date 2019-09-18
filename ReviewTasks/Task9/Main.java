import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
	public static void main(String args[])
	{
		File file = new File("../Input Files/Prob9Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));

			String text;
			while( (text=input.readLine())!= null)
			{
                int k = Integer.parseInt(text);
                char[][] arr = new char[k][k];
                for(int i = 0; i < k; i++)
                    for(int j = 0; j < k; j++)
                        arr[i][j] = '*';
                if(k > 1) {
                    int i = 1;
                    int j = 0;
                    int direction = 0;
                    while(true) {
                        arr[i][j] = '_';
                        if(!shouldGo(arr, direction, i, j)) {
                            direction++;
                            if(!shouldGo(arr, direction, i, j)) {
                                break;
                            }
                        }
                        int[] a = move(arr, i, j, direction);
                        if(a == null)
                            break;
                        i = a[0];
                        j = a[1];
                    }
                }
                printArr(arr);
			}
			input.close();
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
    }

    public static int[] move(char[][] arr, int i, int j, int direction) {
        if(direction % 4 == 0) {
            j++;
        } else if(direction % 4 == 1){
            i++;
        } else if(direction % 4 == 2){
            j--;
        } else if(direction % 4 == 3){
            i--;
        }
        return new int[]{i, j};
    }

    public static boolean shouldGo(char[][] arr, int direction, int i, int j) {
        
        int[] a = move(arr, i, j, direction);
        i = a[0];
        j = a[1];
        
        int[][] positions = {
            {i, j - 1},
            {i - 1, j},
            {i, j + 1},
            {i + 1, j}
        };

        for(int k = 0; k < positions.length; k++){
            if(k != direction % 4 && isFilled(positions[k], arr))
                return false;
        }

        if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == '_') {
            direction++;
        }
        a = move(arr, a[0], a[1], direction);
        i = a[0];
        j = a[1];
        return !(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == '_');            
    }

    public static boolean isFilled(int[] position, char[][] arr) {
        if(position[0] < 0 || position[1] < 0 || position[0] >= arr.length || position[1] >= arr.length)
            return false;
        return arr[position[0]][position[1]] == '_';
    }

    public static void printArr(char[][] arr) {
        // System.out.println(arr.length);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");           
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

}


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // int[][] arr = new int[4][4];
        // arr[0][0] = 5;
        // arr[0][1] = 2;
        // arr[0][2] = 9;
        // arr[1] = arr[0];
        // print(arr[0]);
        // print(arr[1]);
        // arr[0][3] = 7;
        // print(arr[0]);
        // print(arr[1]);
        double d = 2.0;
        System.out.println((d + "").split("\\.")[0]);
    }

    public static void print(int[] arr) {
        System.out.print("{");
        for(int i = 0; i < arr.length - 1; i++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[arr.length - 1]);
        System.out.println("}");
    }
}
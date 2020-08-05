package SearchingAlgorithms;

import java.util.Scanner;

public class LinearSearchAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // array does not have to be sorted like in binary search
        int[] arr = {2, 5, 6, 9, 0, 4, 5, 9};
        System.out.println("Enter value to be searched: ");
        int x = sc.nextInt();
        int i = linearSearch(arr, x);
        System.out.println(i == -1 ? "Element not found!" : "Element found at: " + i);
        sc.close();
    }

    private static int linearSearch(int[] arr, int x) {
        if (arr == null || arr.length == 0)
            return -1;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x)
                return i;

        return -1;
    }
}
package SearchingAlgorithms;

import java.util.Scanner;

public class BinarySearchAlgo  {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // array has to be sorted for binary search
        int[] arr = {0, 1, 3, 4, 5, 8, 10};
        System.out.println("Enter number to search");
        int value = sc.nextInt();
        int i = binarySearch(arr, value);
        System.out.println(i == -1 ? "Not Found" : "Found At: " + i);
        sc.close();
    }

    private static int binarySearch(int[] arr, int value) {
        if (arr == null || arr.length == 0)
            return -1;

        int p = 0;
        int r = arr.length;

        while (p <= r) {
            int q = (p + r) / 2;

            if (value > arr[q]) p = q + 1;
            else if (value < arr[q]) r = q - 1;
            else return q;
        }

        return -1;
    }
}
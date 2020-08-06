package SortingAlgorithms;

public class QuickSortAlgo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 45, 10, 1, 22, 8, 39, 50, 1};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r); // correctly placed value's index
            quickSort(arr, p, q - 1); // sorting of left part
            quickSort(arr, q + 1, r); // sorting of right part
        }
    }

    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] < x) {
                i++;
                swap(arr, i, j);
            }  
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
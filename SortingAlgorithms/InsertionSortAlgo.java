package SortingAlgorithms;

public class InsertionSortAlgo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 45, 10, 22, 8, 39, 50};
        arr= insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1; // points to the last element of the sorted section
            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j+1] = element;
        }

        return arr;
    } 
}
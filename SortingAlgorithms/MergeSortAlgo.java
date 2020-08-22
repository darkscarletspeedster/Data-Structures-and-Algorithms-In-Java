package SortingAlgorithms;

public class MergeSortAlgo {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 9, 45, 10, 22, 8, 39, 50, 1000, 4566, 455, 654, 71111, 50 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " | "));
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int[] tempArr = new int[r - p + 1];
        int leftSlot = p;
        int rightSlot = q + 1;
        int k = 0;
        while (leftSlot <= q && rightSlot <= r) {
            if (arr[leftSlot] < arr[rightSlot]) {
                tempArr[k] = arr[leftSlot];
                leftSlot++;
            } else {
                tempArr[k] = arr[rightSlot];
                rightSlot++;
            }
            k++;
        }

        if (leftSlot <= q) {
            while (leftSlot <= q) {
                tempArr[k] = arr[leftSlot];
                leftSlot++;
                k++;
            }
        } else if (rightSlot <= r) {
            while (rightSlot <= r) {
                tempArr[k] = arr[rightSlot];
                rightSlot++;
                k++;
            }
        }

        for (int i = 0; i < tempArr.length; i++)
            arr[p + i] = tempArr[i];
    }
}
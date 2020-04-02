package name.ryaboff.quicksort.cstyle;

import java.util.Arrays;

public class CStyleQuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            var pivotIdx = lomutoPartition(arr, begin, end); // balances array leaning on pivot and returns it's index.
            quickSort(arr, begin, pivotIdx - 1); // apply to the left part.
            quickSort(arr, pivotIdx + 1, end); // apply to the right part.
        }
    }

    private static int lomutoPartition(int[] arr, int begin, int end) {
        var pivotPosition = begin; // at the end this pointer will be equal the index of rightest element smaller than pivot.
        var pivotValue = arr[end]; // select pivot value (always the value of the last elem).

        for (int i = begin; i < end; i++) {
            if (arr[i] < pivotValue) {
                doSwap(arr, i, pivotPosition);
                pivotPosition++;
            }
        }

        doSwap(arr, pivotPosition, end);
        return pivotPosition;
    }

    private static void doSwap(int[] arr, int i, int j) {
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }
}

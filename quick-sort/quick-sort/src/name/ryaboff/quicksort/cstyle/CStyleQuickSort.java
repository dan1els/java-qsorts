package name.ryaboff.quicksort.cstyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CStyleQuickSort {

  public static void main(String[] args) {
    var arr = array1000();
    var start = System.nanoTime();
    quickSort(arr, 0, arr.size() - 1);
    var end = System.nanoTime();
    System.out.println((end - start) / 1000);
  }

  public static void quickSort(List<Integer> arr, int begin, int end) {
    if (begin < end) {
      var pivotIdx = lomutoPartition(arr, begin, end); // balances array leaning on pivot and returns it's index.
      quickSort(arr, begin, pivotIdx - 1); // apply to the left part.
      quickSort(arr, pivotIdx + 1, end); // apply to the right part.
    }
  }

  private static int lomutoPartition(List<Integer> arr, int begin, int end) {
    var pivotPosition = begin; // at the end this pointer will be equal the index of rightest element smaller than pivot.
    var pivotValue = arr.get(end); // select pivot value (always the value of the last elem).

    for (int i = begin; i < end; i++) {
      if (arr.get(i) < pivotValue) {
        Collections.swap(arr, i, pivotPosition);
        pivotPosition++;
      }
    }

    Collections.swap(arr, pivotPosition, end);
    return pivotPosition;
  }

  private static List<Integer> array1000() {
    var rng = new Random();
    var result = new ArrayList<Integer>();
    for (int i = 0; i < 10_000_000; ++i) {
      result.add(rng.nextInt(10000));
    }
    return result;
  }
}

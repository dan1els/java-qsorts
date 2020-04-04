package name.ryaboff.quicksort.oop.declarative;

import name.ryaboff.quicksort.oop.declarative.sort.ForkJoinQuickSort;
import name.ryaboff.quicksort.oop.declarative.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class DOOPStyleQuickSort {

  public static void main(String[] args) {
    var list = array1000();
    var start = System.nanoTime();
    var result = new QuickSort(list).sorted();
  //  var result = new ForkJoinPool(Runtime.getRuntime().availableProcessors()).invoke(new ForkJoinQuickSort(list));
    var end = System.nanoTime();
    out.println((end - start) / 1000);
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

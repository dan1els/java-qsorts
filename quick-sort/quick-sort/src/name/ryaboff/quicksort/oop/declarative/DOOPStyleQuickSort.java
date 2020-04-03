package name.ryaboff.quicksort.oop.declarative;

import name.ryaboff.quicksort.oop.declarative.sort.QuickSort;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class DOOPStyleQuickSort {

  public static void main(String[] args) {
    Integer[] arr = array1000();
    var start = System.nanoTime();
    var result = new QuickSort(Stream.of(arr)).sorted().collect(toUnmodifiableList());
    var end = System.nanoTime();
    out.println((end - start) / 1000);
  }

  private static Integer[] array1000() {
    var rng = new Random();
    return IntStream
        .range(0, 1000)
        .peek(i -> rng.nextInt(10000))
        .boxed()
        .collect(toList())
        .toArray(new Integer[1000]);
  }
}

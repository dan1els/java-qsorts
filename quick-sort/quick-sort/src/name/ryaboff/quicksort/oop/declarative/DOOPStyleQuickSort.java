package name.ryaboff.quicksort.oop.declarative;

import name.ryaboff.quicksort.oop.declarative.sort.QuickSort;

import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toUnmodifiableList;

public class DOOPStyleQuickSort {

  public static void main(String[] args) {
    Integer[] arr = {1, 3, 6, 2, 4};
    out.println(
        new QuickSort(Stream.of(arr)).sorted().collect(toUnmodifiableList())
    );
  }
}

package name.ryaboff.quicksort.functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Stream.*;

public class FunctionalStyleQuickSort {

  public static void main(String[] args) {
    Integer[] arr = {1, 3, 6, 2, 4};
    out.println(
        Functions.quicksort.apply(of(arr)).collect(toList())
    );
  }

  private static class Functions {

    private static Function<List<Integer>, Integer> xs = (coll) -> coll.get(coll.size() - 1);
    private static BiFunction<Integer, Integer, Boolean> lessThan = (elem, pivot) -> elem.compareTo(pivot) < 0;
    private static BiFunction<Integer, Integer, Boolean> greaterThan = (elem, pivot) -> elem.compareTo(pivot) > 0;

    public static Function<Stream<Integer>, Stream<Integer>> quicksort = (coll) -> {
        var copied = coll.collect(toUnmodifiableList());
        return copied.size() < 2
            ?
            copied.stream()
            :
            concat3(
                Functions.quicksort.apply(
                   copied.stream().filter(e -> lessThan.apply(e, xs.apply(copied)))
                ),
                of(xs.apply(copied)),
                Functions.quicksort.apply(
                    copied.stream().filter(e -> greaterThan.apply(e, xs.apply(copied)))
                )
            );
    };

    private static Stream<Integer> concat3(Stream<Integer> s1, Stream<Integer> s2, Stream<Integer> s3) {
      return concat(s1, concat(s2, s3));
    }
  }
}

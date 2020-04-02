package name.ryaboff.quicksort.oop.declarative.sort;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class QuickSort {

  private final List<Integer> partition;
  private final Integer pivot;

  public QuickSort(Stream<Integer> in) {
    this.partition = in.collect(toUnmodifiableList());
    this.pivot = partition.get(partition.size() - 1);
  }

  public Stream<Integer> sorted() {
    return partition.size() < 2
        ?
        partition.stream()
        :
        concat3(
            new QuickSort(partition.stream().filter(e -> e.compareTo(pivot) < 0)).sorted(),
            of(pivot),
            new QuickSort(partition.stream().filter(e -> e.compareTo(pivot) > 0)).sorted()
        );
  }

  private Stream<Integer> concat3(Stream<Integer> s1, Stream<Integer> s2, Stream<Integer> s3) {
    return concat(s1, concat(s2, s3));
  }
}

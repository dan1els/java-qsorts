package name.ryaboff.quicksort.oop.declarative.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;
import static java.util.stream.Collectors.toList;

public class QuickSort {

  private final List<Integer> partition;
  private final Integer pivot;

  public QuickSort(List<Integer> in) {
    this.partition = List.copyOf(in);
    this.pivot = partition.isEmpty() ? null : partition.get(partition.size() - 1);
  }

  public List<Integer> sorted() {
    return partition.size() < 2
        ?
        partition
        :
        concat3(
            new QuickSort(partition.stream().filter(e -> e.compareTo(pivot) < 0).collect(toList())).sorted(),
            of(pivot),
            new QuickSort(partition.stream().filter(e -> e.compareTo(pivot) > 0).collect(toList())).sorted()
        );
  }

  private List<Integer> concat3(List<Integer> s1, List<Integer> s2, List<Integer> s3) {
    var result = new ArrayList<>(s1);
    result.addAll(s2);
    result.addAll(s3);
    return result;
  }
}

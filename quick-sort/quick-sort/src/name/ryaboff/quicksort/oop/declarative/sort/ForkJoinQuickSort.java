package name.ryaboff.quicksort.oop.declarative.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import static java.util.stream.Collectors.toList;

public class ForkJoinQuickSort extends RecursiveTask<List<Integer>> {

  private final List<Integer> partition;
  private final Integer pivot;

  public ForkJoinQuickSort(List<Integer> in) {
    this.partition = new ArrayList<>(in);
    this.pivot = partition.isEmpty() ? null : partition.get(partition.size() - 1);
  }

  @Override
  public List<Integer> compute() {
    if (partition.size() < 2) {
      return partition;
    } else {
      var left = new ForkJoinQuickSort(partition.stream().filter(e -> e.compareTo(pivot) < 0).collect(toList())).fork();
      var right = new ForkJoinQuickSort(partition.stream().filter(e -> e.compareTo(pivot) > 0).collect(toList())).fork();
      return concat3(left.join(), List.of(pivot), right.join());
    }
  }

  private List<Integer> concat3(List<Integer> s1, List<Integer> s2, List<Integer> s3) {
    var result = new ArrayList<>(s1);
    result.addAll(s2);
    result.addAll(s3);
    return result;
  }
}

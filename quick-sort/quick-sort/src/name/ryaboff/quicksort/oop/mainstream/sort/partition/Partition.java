package name.ryaboff.quicksort.oop.mainstream.sort.partition;

import java.util.List;

public interface Partition<T extends Comparable<T>> {

    int doPartition(List<T> coll, int begin, int end);
}

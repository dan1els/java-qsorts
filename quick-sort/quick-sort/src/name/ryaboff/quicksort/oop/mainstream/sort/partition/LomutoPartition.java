package name.ryaboff.quicksort.oop.mainstream.sort.partition;

import java.util.List;

import static java.util.Collections.swap;

public class LomutoPartition<T extends Comparable<T>> implements Partition<T> {

    @Override
    public int doPartition(List<T> list, int begin, int end) {
        var pivotPosition = begin;
        var pivotValue = list.get(end);

        for (int i = begin; i < end; i++) {
            if (list.get(i).compareTo(pivotValue) < 0) {
                swap(list, i, pivotPosition);
                pivotPosition++;
            }
        }

        swap(list, pivotPosition, end);
        return pivotPosition;
    }
}

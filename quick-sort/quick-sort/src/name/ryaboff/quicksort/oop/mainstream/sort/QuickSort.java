package name.ryaboff.quicksort.oop.mainstream.sort;

import name.ryaboff.quicksort.oop.mainstream.sort.partition.LomutoPartition;
import name.ryaboff.quicksort.oop.mainstream.sort.partition.Partition;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    private final Partition<T> partition = new LomutoPartition<>();

    @Override
    public List<T> sort(List<T> list) {
        var mutableList = new ArrayList<>(list); // here we safe us from getting immutable one in arg
        sortInternal(list, 0, list.size() - 1);
        return mutableList;
    }

    private void sortInternal(List<T> coll, int begin, int end) {
        if (begin < end) {
            var pivotIdx = partition.doPartition(coll, begin, end);
            sortInternal(coll, begin, pivotIdx - 1);
            sortInternal(coll, pivotIdx + 1, end);
        }
    }
}
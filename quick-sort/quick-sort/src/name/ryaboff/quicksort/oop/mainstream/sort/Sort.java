package name.ryaboff.quicksort.oop.mainstream.sort;

import java.util.List;

public interface Sort<T extends Comparable<T>> {
    List<T> sort(List<T> collection);
}

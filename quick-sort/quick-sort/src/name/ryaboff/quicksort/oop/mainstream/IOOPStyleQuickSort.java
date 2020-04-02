package name.ryaboff.quicksort.oop.mainstream;

import name.ryaboff.quicksort.oop.mainstream.sort.QuickSort;
import name.ryaboff.quicksort.oop.mainstream.sort.Sort;

import java.util.List;

import static java.lang.System.*;

public class IOOPStyleQuickSort {

    private static Sort<Integer> quickSort = new QuickSort<>();

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 6, 2, 4};
        out.println(
                quickSort.sort(
                        List.of(arr)
                )
        );
    }
}

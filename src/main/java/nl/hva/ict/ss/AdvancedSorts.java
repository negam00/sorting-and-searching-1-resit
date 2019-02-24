package nl.hva.ict.ss;

import nl.hva.ict.ss.util.ArraySort;
import nl.hva.ict.ss.util.LinkedListSort;

import java.util.LinkedList;

public class AdvancedSorts {

    private static ArraySort arraySort =  new ArraySort();
    private static LinkedListSort linkedListSort =  new LinkedListSort();
    /**
     * Implement quicksort using LinkedList only! Usage of anything but LinkedList will result in failing the assignment!
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted)
    {
        return linkedListSort.LinkedListSorted(unsorted);
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will result in failing the assignment!
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {
        return arraySort.sortArray(unsorted);
    }

}

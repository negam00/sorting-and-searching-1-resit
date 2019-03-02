package nl.hva.ict.ss.util;

import java.util.LinkedList;

public class LinkedListSort {

    public static <E extends Comparable<E>> LinkedList<E> LinkedListSorted(LinkedList<E> sortingList) {

        if (1 == sortingList.size()) {
            return sortingList;
        }
        else if(sortingList.size() == 0 || sortingList == null){
            return sortingList;
        }
        else {
            LinkedList LinkedListReturn = new LinkedList();

            E pivot = sortingList.getFirst();
            LinkedList<E> highBound = new LinkedList<>();
            LinkedList<E> lowBound = new LinkedList<>();
                while (sortingList.size() != 1){
                    E comparedObject = sortingList.pollLast();
                    if( 0 <= pivot.compareTo(comparedObject)){
                        lowBound.add(comparedObject);
                    }
                    else{
                        highBound.add(comparedObject);
                    }

                }
            lowBound = LinkedListSorted(lowBound);
            while (0 != lowBound.size()){
                LinkedListReturn.add(lowBound.pollFirst());
            }

            LinkedListReturn.add(pivot);

            highBound = LinkedListSorted(highBound);
            while (0 < highBound.size()){
                LinkedListReturn.add(highBound.pollFirst());

            }


            return LinkedListReturn;

        }
    }
}

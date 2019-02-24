package nl.hva.ict.ss.util;

public class ArraySort {


    public <E extends Comparable<E>> E[] sortArray(E[] input) {

        // check to see if array is empty
        if (input == null || input.length == 0) {
            return input;
        }

        input = quickSort(input, 0, input.length -1);


        return input;
    }

    private <E extends Comparable<E>> E[] quickSort(E[] array, int low, int high) {
        int k = low;
        int l = high;

        E pivot = array[low + (high - low) / 2];

        while (k <= l) {

            while (array[k].compareTo(pivot) == -1){
                k++;
            }

            while (array[l].compareTo(pivot) == 1){
                l--;
            }

            if( k <= l){
                array = switchNumbers(array, k, l);
            k++;
                l--;
            }
        }

        // todo comment
        if(l > low){
            quickSort(array, low, l);
        }

        //todo comment
        if(k < high){
            quickSort(array, k, high);
        }

        return array;
    }

    private <E extends Comparable<E>> E[] switchNumbers(E[] array, int low, int high) {
        E temp = array[low];
        array[low] = array[high];
        array[high] = temp;
        return array;
    }

    }

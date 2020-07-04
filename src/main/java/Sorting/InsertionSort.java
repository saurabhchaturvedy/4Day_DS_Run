package Sorting;

import java.util.stream.IntStream;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        for (int unsortedPartitionIndex = 1; unsortedPartitionIndex < arr.length; unsortedPartitionIndex++) {
            int newElement = arr[unsortedPartitionIndex];
            int i = 0;
            for (i = unsortedPartitionIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = newElement;
        }
        IntStream.of(arr).boxed().map(x -> x + " ").forEach(System.out::print);
    }
}

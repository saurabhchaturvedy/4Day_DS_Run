package Sorting;

import java.util.stream.IntStream;

public class SelectionSort {


    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        for (int unsortedPartitionIndex = arr.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            int largest = 0;
            for (int i = 1; i <= unsortedPartitionIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }
            swap(arr, unsortedPartitionIndex, largest);
        }

        IntStream.of(arr).boxed().map(x -> x + " ").forEach(System.out::print);
    }

}

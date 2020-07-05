package Sorting;

import java.util.stream.IntStream;

public class ShellSort {

    private static void shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > newElement) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = newElement;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        shellSort(arr);
        IntStream.of(arr).boxed().map(x -> x + " ").forEach(System.out::print);
    }
}

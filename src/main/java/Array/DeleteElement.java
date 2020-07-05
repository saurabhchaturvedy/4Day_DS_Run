package Array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DeleteElement {


    public static int[] deleteFromArray(int[] arr, int index) {
        if (arr == null || index < 0 || index > arr.length)
            return arr;

        int[] holderArray = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            holderArray[k++] = arr[i];
        }
        return holderArray;
    }

    public static int[] deleteFromArrayStreams(int[] arr, int index) {
        if (arr == null || index < 0 || index > arr.length) return arr;

        return IntStream.range(0, arr.length).filter(i -> i != index).map(i -> arr[i]).toArray();
    }


    public static void main(String[] args) {
        int[] arr = {7, 3, 11, 8, 5};
        System.out.println("array elements " + Arrays.toString(arr));
        // int[] ints = deleteFromArray(arr, 2);
        int[] ints = deleteFromArrayStreams(arr, 2);
        System.out.println("array elements " + Arrays.toString(ints));
        System.out.println(ints.length);
    }
}

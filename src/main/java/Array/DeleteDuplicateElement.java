package Array;

import java.util.stream.IntStream;

public class DeleteDuplicateElement {

    public static int deleteDuplicate(int[] arr) {
        int[] temp = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[k++] = arr[i];
            }
        }
        temp[k++] = arr[arr.length - 1];
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        return k;
    }

    public static int deleteDuplicateIndex(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[k++] = arr[i];

            }
        }
        arr[k++] = arr[arr.length - 1];
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 4, 5, 6, 7, 7, 7, 8};

        // int i = deleteDuplicate(arr);
        int i = deleteDuplicateIndex(arr);
        for (int k = 0; k < i; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}

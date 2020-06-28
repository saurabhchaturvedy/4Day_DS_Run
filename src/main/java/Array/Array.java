package Array;

import java.util.Arrays;

public class Array {

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 3, 5, 9, 2};
        //int[] ints = Arrays.copyOf(arr, 2 * arr.length);
        // System.out.println("size of resized array is "+ints.length);
        System.out.print("Array elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Minimum value in the array : " + minValue(arr));
        reverseArray(arr);
        System.out.print("Array elements after reversing : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

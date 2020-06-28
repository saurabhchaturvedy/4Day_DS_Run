package Search;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class LinearSearch {

    private static int search(int[] arr, int key) throws Exception {
        if (arr == null || arr.length == 0)
            throw new Exception("Invalid argument");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return arr[i];
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {5, 8, 13, 7, 22, 6};
        int search = search(arr, 22);
        System.out.println("the element is found in array ? : " + search);
    }
}

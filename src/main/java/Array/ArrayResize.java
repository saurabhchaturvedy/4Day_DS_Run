package Array;

public class ArrayResize {

    public static int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 8, 2, 7};
        System.out.println("size of array : " + arr.length);
        int[] resize = resize(arr, arr.length * 2);
        System.out.println("size of array after resize : " + resize.length);
    }
}

package Search;

public class BinarySearch {


    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return arr[mid];
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 13, 21, 27, 31};
        int search = binarySearch(arr, 5);
        System.out.println("the element is found in array ? : " + search);
    }
}

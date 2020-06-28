package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSumProblem {

    private static int[] twoSum(int[] arr, int target) {
        int[] twoSumIndexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], i);
            } else {
                twoSumIndexes[1] = i;
                twoSumIndexes[0] = map.get(target - arr[i]);
            }
        }
        return twoSumIndexes;
    }

    public static void main(String[] args) {
        int[] arr = {2, 11, 5, 10, 7, 8};
        int[] ints = twoSum(arr, 9);
        System.out.print("Two sum indexes are : ");
        IntStream.of(ints).boxed().map(x -> x + " ").forEach(System.out::print);
    }
}

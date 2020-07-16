package DynamicProgramming;

public class NthFibonacci {

    private static int NthFibonacciBottomUp(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    private static int NthFibonacciTopDown(int[] memo, int n) {
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            } else {
                int left = NthFibonacciTopDown(memo, n - 1);
                int right = NthFibonacciTopDown(memo, n - 2);
                memo[n] = left + right;
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {

        int x = 5;
        int i = NthFibonacciBottomUp(5);
        System.out.println("Fibonacci number is " + i);
        int[] memo = new int[x + 1];
        int i1 = NthFibonacciTopDown(memo, x);
        System.out.println("Fibonacci number (Top-down) is " + i1);
    }
}
